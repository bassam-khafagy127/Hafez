package com.bassamkhafagy.hafez.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bassamkhafagy.hafez.data.local.Sheikh
import com.bassamkhafagy.hafez.data.local.ReviewComplete
import com.bassamkhafagy.hafez.data.local.Students

@Database(
    entities = [Sheikh::class, Students::class, ReviewComplete::class],
    version = 1,
    exportSchema = false
)
abstract class HafezAppDataBase : RoomDatabase() {
    abstract fun shuyukhDao(): ShuyukhDao
    abstract fun studentsDao(): StudentsDao
    abstract fun soraDao(): SoraReviewDao
}

