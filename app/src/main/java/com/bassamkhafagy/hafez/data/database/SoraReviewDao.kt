package com.bassamkhafagy.hafez.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.bassamkhafagy.hafez.data.local.SoraReview

@Dao
interface SoraReviewDao {
    @Insert
    suspend fun insertSoraReview(reviewComplete: SoraReview): Long

    @Query("DELETE FROM `SORA_REVIEW_DATABASE_TABLE_NAME` ")
    suspend fun clearTable()

    @Query("SELECT*FROM `SORA_REVIEW_DATABASE_TABLE_NAME`")
    suspend fun getAllSorReview(): List<SoraReview>

}