package com.bassamkhafagy.hafez.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bassamkhafagy.hafez.util.Constant.SHUYUKH_DATABASE_TABLE_NAME
import com.bassamkhafagy.hafez.util.Constant.SORA_COMPLETE_DATABASE_TABLE_NAME

@Entity(tableName = SORA_COMPLETE_DATABASE_TABLE_NAME)
data class ReviewComplete(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val date: String?,
    val studentCode: String?,
    val studentName: String?,
    val ring: String?,
    val sheikhName: String?,
    val soraName: String?,
    val state: String?,
    val degree: String?,
)
