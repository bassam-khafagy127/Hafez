package com.bassamkhafagy.hafez.fragments.showallstudent.compose

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bassamkhafagy.hafez.data.local.ImportedData

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ShowAllStudentsDataContent(studentUIState: StudentUIState) {
    Column {
        when (studentUIState) {
            StudentUIState.Error -> {

            }

            StudentUIState.Loading -> {
            CircularProgressIndicator()
            }

            is StudentUIState.Success -> {
                LazyColumn() {
                    stickyHeader {
                        StudentListHeader()
                    }
                    itemsIndexed(studentUIState.students) { index: Int, student: ImportedData ->
                       Spacer(modifier = Modifier.height(8.dp))
                        StudentItem(
                            studentName = student.studentsName.toString(),
                            shiehkName = student.sheikhName.toString(),
                            ring = student.ring.toString()
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        }
    }
}