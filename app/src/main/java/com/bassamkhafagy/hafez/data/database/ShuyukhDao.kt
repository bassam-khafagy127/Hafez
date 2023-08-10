package com.bassamkhafagy.hafez.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.bassamkhafagy.hafez.data.local.Sheikh

@Dao
interface ShuyukhDao {
    @Insert
    suspend fun insertAllSheikh(sheikh: List<Sheikh>)

    @Query("SELECT*FROM `shuyukh_database_table_name` ORDER BY id")
    suspend fun getAllShuyukh(): List<Sheikh>

    @Query("DELETE FROM SHUYUKH_DATABASE_TABLE_NAME") // "excel_data" is the table name
    suspend fun clearTable()

}