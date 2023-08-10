package com.bassamkhafagy.hafez.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.bassamkhafagy.hafez.data.local.Students

@Dao
interface StudentsDao {
    @Insert
    suspend fun insertAllStudent(student: List<Students>)

    @Query("SELECT*FROM `STUDENTS_DATABASE_TABLE_NAME` ORDER BY code")
    suspend fun getAllStudents(): List<Students>

    @Query("SELECT * FROM `STUDENTS_DATABASE_TABLE_NAME` WHERE code = :studentsId")
    suspend fun getStudentById(studentsId: Int): Students?

    @Query("DELETE FROM students_database_table_name") // "excel_data" is the table name
    suspend fun clearTable()

    @Query("SELECT COUNT(*) FROM students_database_table_name WHERE code = :studentsId")
    suspend fun checkIfIdExists(studentsId: Int): Int

}