package com.bassamkhafagy.hafez.di

import com.bassamkhafagy.hafez.data.database.TaskedInAppDataBase
import com.bassamkhafagy.hafez.repositories.TasksRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTasksRepository(
        taskedInAppDataBase: TaskedInAppDataBase
    ): TasksRepository {
        return TasksRepository(
            taskedInAppDataBase
        )
    }

}