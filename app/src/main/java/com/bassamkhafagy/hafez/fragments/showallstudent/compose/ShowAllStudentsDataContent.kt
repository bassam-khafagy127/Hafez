package com.bassamkhafagy.hafez.fragments.showallstudent.compose

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.bassamkhafagy.hafez.R
import com.bassamkhafagy.hafez.data.local.ImportedData
import com.bassamkhafagy.hafez.data.local.SoraReview
import com.bassamkhafagy.hafez.data.local.Student

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ShowAllStudentsDataContent(studentUIState: StudentUIState) {
    Column {
        when (studentUIState) {
            StudentUIState.Error -> {

            }

            StudentUIState.Loading -> {

            }

            is StudentUIState.Success -> {
                LazyColumn {
                    stickyHeader {
                        StudentListHeader()
                    }
                    itemsIndexed(studentUIState.students) { index: Int, student: ImportedData ->
                        StudentItem(
                            studentName = student.studentsName.toString(),
                            shiehkName = student.sheikhName.toString(),
                            ring = student.ring.toString()
                        )
                    }
                }
            }
        }
    }
}