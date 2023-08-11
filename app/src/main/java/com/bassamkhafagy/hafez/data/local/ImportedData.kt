package com.bassamkhafagy.hafez.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bassamkhafagy.hafez.util.Constant

@Entity(tableName = Constant.IMPORTED_DATA_TABLE)
data class ImportedData(
    @PrimaryKey(autoGenerate = false)
    val code: Long,
    val studentsName: String?,
    val ring: String?,
    val sheikhName: String?,
    val phoneNumber: String?,
    val payingState: String?,
)
