package com.bassamkhafagy.hafez.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bassamkhafagy.hafez.R
import com.bassamkhafagy.hafez.databinding.FragmentShowStudentBycodeBinding

class ShowStudentsByCodeFragment : Fragment(R.layout.fragment_show_student_bycode) {
    private lateinit var binding: FragmentShowStudentBycodeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShowStudentBycodeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}