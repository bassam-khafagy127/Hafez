package com.bassamkhafagy.hafez.fragments.showallstudent.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.bassamkhafagy.hafez.R
import com.bassamkhafagy.hafez.data.local.SoraReview
import com.bassamkhafagy.hafez.data.local.Student

@Composable
fun ShowAllStudentsDataContent(studentList: List<SoraReview>, navController: NavController) {
    Column {
//        StudentListHeader()
        LazyColumn {
            itemsIndexed(studentList) { index: Int, student: SoraReview ->
                BoxHeader(id = R.string.studentName)
            }
        }
    }
}