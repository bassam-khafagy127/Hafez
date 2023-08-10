package com.bassamkhafagy.hafez.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.bassamkhafagy.hafez.data.local.Sheikh

@Dao
interface ShuyukhDao {
    @Insert
    suspend fun insertSheikh(sheikh: Sheikh): Long

    @Query("SELECT*FROM `shuyukh_database_table_name` ORDER BY id")
    suspend fun getAllShuyukh(): List<Sheikh>

}