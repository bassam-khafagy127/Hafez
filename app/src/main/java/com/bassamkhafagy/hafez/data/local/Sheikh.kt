package com.bassamkhafagy.hafez.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bassamkhafagy.hafez.util.Constant.SHUYUKH_DATABASE_TABLE_NAME

@Entity(tableName = SHUYUKH_DATABASE_TABLE_NAME)
data class Sheikh(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val sheikhName: String?,
    val sheikhRing: String?,
    val ring: String?,

)
