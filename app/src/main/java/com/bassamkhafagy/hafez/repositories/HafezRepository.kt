package com.bassamkhafagy.hafez.repositories

import com.bassamkhafagy.hafez.data.database.HafezAppDataBase
import com.bassamkhafagy.hafez.data.local.ReviewComplete
import com.bassamkhafagy.hafez.data.local.Sheikh
import com.bassamkhafagy.hafez.data.local.Students
import kotlinx.coroutines.delay
import javax.inject.Inject

class HafezRepository @Inject constructor(private val hafezAppDataBase: HafezAppDataBase) {


    //SoraComplete
    suspend fun insertSoraReview(reviewComplete: ReviewComplete) =
        hafezAppDataBase.soraDao().insertSoraReview(reviewComplete)

    suspend fun getAllSorReview() = hafezAppDataBase.soraDao().getAllSorReview()


    ////Students
    suspend fun insertAllStudent(students: List<Students>) {
        hafezAppDataBase.studentsDao().clearTable()
        delay(100)
        hafezAppDataBase.studentsDao().insertAllStudent(students)
    }

    suspend fun getAllStudents() = hafezAppDataBase.studentsDao().getAllStudents()
    suspend fun clearAllStudents() = hafezAppDataBase.studentsDao().clearTable()

    suspend fun checkIfStudentIsInTable(studentsId: Int) =
        hafezAppDataBase.studentsDao().checkIfIdExists(studentsId)

    suspend fun getStudentById(id: Int) = hafezAppDataBase.studentsDao().getStudentById(id)

    ///Sheikh
    suspend fun insertAllSheikh(sheikh: List<Sheikh>) {
        hafezAppDataBase.shuyukhDao().clearTable()
        delay(100)
        hafezAppDataBase.shuyukhDao().insertAllSheikh(sheikh)
    }

    suspend fun getAllShuyukh() = hafezAppDataBase.shuyukhDao().getAllShuyukh()

    suspend fun clearAllShuyukh() = hafezAppDataBase.shuyukhDao().clearTable()
}