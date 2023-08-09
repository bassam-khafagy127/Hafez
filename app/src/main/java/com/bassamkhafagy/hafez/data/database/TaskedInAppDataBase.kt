package com.bassamkhafagy.hafez.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bassamkhafagy.hafez.data.local.Task

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class TaskedInAppDataBase : RoomDatabase() {
    abstract fun tasksDao(): TasksDao
}