package com.bassamkhafagy.hafez.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.bassamkhafagy.hafez.data.local.ImportedData
import com.bassamkhafagy.hafez.data.local.Student

@Dao
interface ImportedDataDao {
    @Insert
    suspend fun insertAllImportedData(importedData: List<ImportedData>)

    @Query("SELECT*FROM `IMPORTED_DATA_TABLE` ORDER BY code")
    suspend fun getAllImportedData(): List<ImportedData>

    @Query("SELECT sheikhName FROM `IMPORTED_DATA_TABLE` ")
    suspend fun getAllShuyukh(): List<String>

    @Query("SELECT studentsName From `IMPORTED_DATA_TABLE` WHERE code = :studentsId")
    suspend fun getStudentNameByCode(studentsId: Long): String?

    @Query("DELETE FROM `IMPORTED_DATA_TABLE` ")
    suspend fun clearTable()

    @Query("SELECT COUNT(*) FROM IMPORTED_DATA_TABLE WHERE code = :studentsId")
    suspend fun checkIfIdExists(studentsId: Long): Int

    @Query("SELECT code,studentsName,ring,phoneNumber,payingState From `IMPORTED_DATA_TABLE` WHERE code = :studentsId")
    suspend fun getStudentDataByCodeData(studentsId: Long):Student
}