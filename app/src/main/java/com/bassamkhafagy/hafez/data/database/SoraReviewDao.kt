package com.bassamkhafagy.hafez.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.bassamkhafagy.hafez.data.local.ReviewComplete

@Dao
interface SoraReviewDao {
    @Insert
    suspend fun insertSoraReview(reviewComplete: ReviewComplete)

    @Query("SELECT*FROM `SORA_COMPLETE_DATABASE_TABLE_NAME`")
    suspend fun getAllSorReview(): List<ReviewComplete>

}