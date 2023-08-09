package com.bassamkhafagy.hafez.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bassamkhafagy.hafez.R
import com.bassamkhafagy.hafez.databinding.FragmentCreateRecivingSorraBinding

class CreateSoraCompleteFragment : Fragment(R.layout.fragment_create_reciving_sorra) {
    private lateinit var binding: FragmentCreateRecivingSorraBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreateRecivingSorraBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}