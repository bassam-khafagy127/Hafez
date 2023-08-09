package com.bassamkhafagy.hafez.di

import android.content.Context
import androidx.room.Room
import com.bassamkhafagy.hafez.data.database.HafezAppDataBase
import com.bassamkhafagy.hafez.util.Constant.HAFEZ_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DateBaseModule {
    @Provides
    fun HafezAppDataBase(@ApplicationContext context: Context): HafezAppDataBase {
        return Room.databaseBuilder(
            context,
            HafezAppDataBase::class.java,
            HAFEZ_DATABASE_NAME
        ).build()
    }
}