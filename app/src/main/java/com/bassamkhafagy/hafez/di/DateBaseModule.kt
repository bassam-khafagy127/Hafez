package com.bassamkhafagy.hafez.di

import android.content.Context
import androidx.room.Room
import com.bassamkhafagy.hafez.data.database.TaskedInAppDataBase
import com.bassamkhafagy.hafez.util.Constant.TASKED_IN_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DateBaseModule {
    @Provides
    fun TaskedInAppDataBase(@ApplicationContext context: Context): TaskedInAppDataBase {
        return Room.databaseBuilder(
            context,
            TaskedInAppDataBase::class.java,
            TASKED_IN_DATABASE_NAME
        ).build()
    }
}