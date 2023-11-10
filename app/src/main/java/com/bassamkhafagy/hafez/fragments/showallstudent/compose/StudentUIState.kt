package com.bassamkhafagy.hafez.fragments.showallstudent.compose

import com.bassamkhafagy.hafez.data.local.ImportedData

sealed class StudentUIState {

    object Error : StudentUIState()

    object Loading : StudentUIState()
    data class Success(
        val students: List<ImportedData>
    ) : StudentUIState()
}