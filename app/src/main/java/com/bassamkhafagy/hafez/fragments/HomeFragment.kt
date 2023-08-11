package com.bassamkhafagy.hafez.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.bassamkhafagy.hafez.R
import com.bassamkhafagy.hafez.databinding.FragmentHomeBinding
import com.bassamkhafagy.hafez.util.parseImportedStudentsExcelFile
import com.bassamkhafagy.hafez.viewModel.HafezViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {
    private val viewModel by viewModels<HafezViewModel>()

    private lateinit var binding: FragmentHomeBinding

    // Set up the file picker contract
    private val studentFilePickerContract =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            uri?.let {
                val inputStream = requireContext().contentResolver.openInputStream(it)
                inputStream?.let { stream ->
                    lifecycleScope.launch (Dispatchers.IO){
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
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpCallBacks(view)
    }

    private fun setUpCallBacks(view: View) {
        binding.apply {
            importStudentExcel.setOnClickListener {
                selectExcelFile()
            }

            createReview.setOnClickListener {
                val action =
                    HomeFragmentDirections.actionHomeFragmentToCreateSoraCompleteFragment()
                Navigation.findNavController(view).navigate(action)
            }
            studentQueryByCode.setOnClickListener {
                val action =
                    HomeFragmentDirections.actionHomeFragmentToShowStudentsByCodeFragment()
                Navigation.findNavController(view).navigate(action)
            }
            exportReviewExcel.setOnClickListener {

                lifecycleScope.launch(Dispatchers.IO) {
//                    exportToExcel(
//                        viewModel.getAllSorReview(),
//                        requireActivity().applicationContext,
//                        ""
//                    )
                }
            }
        }
    }

    private fun selectExcelFile() {
        lifecycleScope.launch(Dispatchers.IO) {
            studentFilePickerContract.launch("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
        }
    }
}