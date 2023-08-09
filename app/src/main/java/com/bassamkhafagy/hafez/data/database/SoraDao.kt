package com.bassamkhafagy.hafez.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.bassamkhafagy.hafez.data.local.SoraComplete
import com.bassamkhafagy.hafez.data.local.Students

@Dao
interface SoraDao {
    @Insert
    suspend fun insertSora(soraComplete: SoraComplete): Long

    @Query("SELECT*FROM `SORA_COMPLETE_DATABASE_TABLE_NAME` ORDER BY id")
    suspend fun getAllSor(): List<SoraComplete>

    @Query("SELECT * FROM `SORA_COMPLETE_DATABASE_TABLE_NAME` WHERE id = :studentsId")
    fun getSoraById(studentsId: Long): SoraComplete?

}