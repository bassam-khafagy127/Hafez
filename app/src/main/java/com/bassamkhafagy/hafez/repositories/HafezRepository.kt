package com.bassamkhafagy.hafez.repositories

import com.bassamkhafagy.hafez.data.database.HafezAppDataBase
import com.bassamkhafagy.hafez.data.local.Sheikh
import com.bassamkhafagy.hafez.data.local.SoraComplete
import com.bassamkhafagy.hafez.data.local.Students
import javax.inject.Inject

class HafezRepository @Inject constructor(private val hafezAppDataBase: HafezAppDataBase) {


    //SoraComplete
    suspend fun insertSora(soraComplete: SoraComplete) =
        hafezAppDataBase.soraDao().insertSoraReview(soraComplete)
    suspend fun getAllSorReview() = hafezAppDataBase.soraDao().getAllSorReview()


    ////Students
    suspend fun insertStudent(students: Students) =
        hafezAppDataBase.studentsDao().insertStudent(students)
    suspend fun getAllStudents() = hafezAppDataBase.studentsDao().getAllStudents()
    fun getStudentById(id: Long) = hafezAppDataBase.studentsDao().getStudentById(id)

    ///Sheikh
    suspend fun insertSheikh(sheikh: Sheikh) =
        hafezAppDataBase.shuyukhDao().insertSheikh(sheikh)
    suspend fun getAllShuyukh() = hafezAppDataBase.shuyukhDao().getAllShuyukh()

}