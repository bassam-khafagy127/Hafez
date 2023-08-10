package com.bassamkhafagy.hafez.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.bassamkhafagy.hafez.data.local.SoraComplete

@Dao
interface SoraReviewDao {
    @Insert
    suspend fun insertSoraReview(soraComplete: SoraComplete): Long

    @Query("SELECT*FROM `SORA_COMPLETE_DATABASE_TABLE_NAME`")
    suspend fun getAllSorReview(): List<SoraComplete>

}