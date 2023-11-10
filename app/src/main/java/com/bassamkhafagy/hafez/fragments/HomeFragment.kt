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
import com.bassamkhafagy.hafez.util.exportSoraReviews
import com.bassamkhafagy.hafez.util.parseImportedStudentsExcelFile
import com.bassamkhafagy.hafez.viewModel.HafezViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding
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
            importExportReviewExcel.setOnClickListener {
                val action =
                    HomeFragmentDirections.actionHomeFragmentToImportExportExcelFragment()
                Navigation.findNavController(view).navigate(action)
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

            showAllReview.setOnClickListener {
                val action =
                    HomeFragmentDirections.actionHomeFragmentToShowAllStudentsDataFragment()
                Navigation.findNavController(view).navigate(action)
            }
            backBtn.setOnClickListener {
                requireActivity().finish()
            }
        }
    }


}