package com.bassamkhafagy.hafez.fragments.showallstudent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.bassamkhafagy.hafez.fragments.showallstudent.compose.ShowAllStudentsDataContent
import com.bassamkhafagy.hafez.viewModel.HafezViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ShowAllStudentsDataFragment : Fragment() {
    private val viewModel: HafezViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        lifecycleScope.launch {
            viewModel.getAllStudent()
        }
        return ComposeView(requireContext()).apply {
            setContent {
                Column {
                    ShowAllStudentsDataContent(viewModel.studentsUiState.value)
                }
            }
        }
    }


}