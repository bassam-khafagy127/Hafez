package com.bassamkhafagy.hafez.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.bassamkhafagy.hafez.data.local.Students

@Dao
interface StudentsDao {
    @Insert
    suspend fun insertStudent(student: Students): Long

    @Query("SELECT*FROM `STUDENTS_DATABASE_TABLE_NAME` ORDER BY code")
    suspend fun getAllStudents(): List<Students>

    @Query("SELECT * FROM `STUDENTS_DATABASE_TABLE_NAME` WHERE code = :studentsId")
    fun getStudentById(studentsId: Long): Students?

}