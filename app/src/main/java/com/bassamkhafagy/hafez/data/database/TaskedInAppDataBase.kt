package com.bassamkhafagy.hafez.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bassamkhafagy.hafez.data.local.SoraReview
import com.bassamkhafagy.hafez.data.local.ImportedData

@Database(
    entities = [ImportedData::class, SoraReview::class],
    version = 1,
    exportSchema = false
)
abstract class HafezAppDataBase : RoomDatabase() {
    abstract fun importedStudentsDao(): ImportedDataDao
    abstract fun soraReviewDao(): SoraReviewDao
}

