package com.bassamkhafagy.hafez.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.bassamkhafagy.hafez.R
import com.bassamkhafagy.hafez.databinding.FragmentImportExportExcelBinding
import com.bassamkhafagy.hafez.util.exportSoraReviews
import com.bassamkhafagy.hafez.util.parseImportedStudentsExcelFile
import com.bassamkhafagy.hafez.viewModel.HafezViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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
    }

    private fun setUpCallBacks() {
        binding.apply {
            exportDataBtn.setOnClickListener {
                val name = nameEd.text.toString()
                exportData(name)
            }
            importDataExcel.setOnClickListener {
                selectExcelFile()
            }

        }

    }

    private fun exportData(name: String) {
        if (name.isNotEmpty() && name.length > 6) {
            lifecycleScope.launch(Dispatchers.IO) {
                val allReviews = viewModel.getAllSoraReviews()
                exportSoraReviews(allReviews, name)
            }
        }
        if (name.isEmpty() || name.length < 6) {
            Toast.makeText(
                requireContext(),
                "${resources.getString(R.string.shiekh)} ${resources.getString(R.string.cantBeEmpty)}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun selectExcelFile() {
        lifecycleScope.launch(Dispatchers.IO) {
            studentFilePickerContract.launch("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
        }
    }
}