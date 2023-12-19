package com.bassamkhafagy.hafez.fragments

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.bassamkhafagy.hafez.R
import com.bassamkhafagy.hafez.databinding.FragmentImportExportExcelBinding
import com.bassamkhafagy.hafez.util.Resource
import com.bassamkhafagy.hafez.util.exportSoraReviews
import com.bassamkhafagy.hafez.util.parseImportedStudentsExcelFile
import com.bassamkhafagy.hafez.util.showExportDataSuccessToast
import com.bassamkhafagy.hafez.util.showImportDataSuccessToast
import com.bassamkhafagy.hafez.util.showSuccessToast
import com.bassamkhafagy.hafez.viewModel.HafezViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class ImportExportExcelFragment : Fragment(R.layout.fragment_import_export_excel) {
    private lateinit var binding: FragmentImportExportExcelBinding
    private val viewModel by viewModels<HafezViewModel>()

    // Set up the file picker contract
    private val studentFilePickerContract =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            uri?.let {
                val inputStream = requireContext().contentResolver.openInputStream(it)
                inputStream?.let { stream ->
                    lifecycleScope.launch(Dispatchers.IO) {

                        viewModel.clearAllImportedData()
                        viewModel.insertAllImportedDate(parseImportedStudentsExcelFile(stream))
                        stream.close()
                        viewModel.setUiState(Resource.Success(getString(R.string.imported)))
                        delay(10)
                        viewModel.setUiState(Resource.Unspecified())
                    }

                }
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentImportExportExcelBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpCallBacks()
        observeUiStateLiveData()
    }

    private fun setUpCallBacks() {
        binding.apply {
            exportDataBtn.setOnClickListener {
                val name = nameEd.text.toString()
                if (name.isNotEmpty() && name.length > 2) {
                    confirmationDialog { exportData(name) }
                } else {
                    Toast.makeText(
                        requireContext(),
                        getString(R.string.shiekhtName) + " " + getString(R.string.cantBeEmpty),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            importDataExcel.setOnClickListener {
                selectExcelFile()
            }

        }

    }

    private fun confirmationDialog(exportData: () -> Unit) {
        val alertDialog = AlertDialog.Builder(requireContext())
        alertDialog.setTitle(getString(R.string.confirmationMessage))
        alertDialog.setPositiveButton(
            getString(R.string.ok)
        ) { p0, p1 ->
            exportData.invoke()
        }
        alertDialog.setNegativeButton(getString(R.string.cancel)) { p0, p1 ->
            p0.dismiss()
        }
        alertDialog.show()
    }

    private fun observeUiStateLiveData() {
        viewModel.uiStateLiveDate.observe(viewLifecycleOwner) { state ->
            when (state) {
                is Resource.Loading -> {}
                is Resource.Error -> {}
                is Resource.Success -> {
                    if (state.data == getString(R.string.imported)) {
                        showImportDataSuccessToast(requireContext())
                    }
                    if (state.data == getString(R.string.exported)) {
                        showExportDataSuccessToast(requireContext())
                    }
                }

                is Resource.Unspecified -> {}
            }
        }
    }

    private fun exportData(name: String) {
        lifecycleScope.launch(Dispatchers.IO) {
            val allReviews = viewModel.getAllSoraReviews()
            exportSoraReviews(allReviews, name)
            viewModel.setUiState(Resource.Success(getString(R.string.exported)))
        }

    }

    private fun selectExcelFile() {
        lifecycleScope.launch(Dispatchers.IO) {
            studentFilePickerContract.launch("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
        }
    }
}