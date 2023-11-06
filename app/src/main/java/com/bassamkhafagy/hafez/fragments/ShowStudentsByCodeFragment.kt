package com.bassamkhafagy.hafez.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.bassamkhafagy.hafez.R
import com.bassamkhafagy.hafez.databinding.FragmentShowStudentBycodeBinding
import com.bassamkhafagy.hafez.viewModel.HafezViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class ShowStudentsByCodeFragment : Fragment(R.layout.fragment_show_student_bycode) {

    private lateinit var binding: FragmentShowStudentBycodeBinding

    private val viewModel by viewModels<HafezViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentShowStudentBycodeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpCallbacks()
        observeStudentData()
    }


    private fun setUpCallbacks() {
        binding.apply {
           searchIv.setOnClickListener {
                val studentCode = searchEd.text?.trim().toString()
                getStudentByCode(studentCode)
            }

            showStudentData.setOnClickListener {
                val studentCode = searchEd.text?.trim().toString()
                getStudentByCode(studentCode)
            }
        }
    }

    private fun getStudentByCode(studentCode: String) {
        if (studentCode.isNotEmpty()) {
            lifecycleScope.launch(Dispatchers.IO) {

                if (viewModel.checkIFStudentExist(studentCode.toLong()) > 0) {

                    viewModel.getStudentDataByCode(
                        studentCode.toLong()
                    )

                } else {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            requireContext(),
                            resources.getString(R.string.student_code) + " ${resources.getString(R.string.isNotFounded)}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

            }
        } else {
            Toast.makeText(
                requireContext(),
                resources.getString(R.string.student_code) + " ${resources.getString(R.string.cantBeEmpty)}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun observeStudentData() {
        viewModel.studentLiveDate.observe(viewLifecycleOwner) {
            Log.d("ShowStudentData", it.phoneNumber.toString())
            binding.apply {
                studentNameTv.text = it.studentsName
                ringTv.text = it.ring
                payingStateTv.text = it.payingState
                phoneNumberTv.text = it.phoneNumber
            }
        }
    }

}