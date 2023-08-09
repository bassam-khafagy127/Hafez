package com.bassamkhafagy.hafez.di

import com.bassamkhafagy.hafez.data.database.HafezAppDataBase
import com.bassamkhafagy.hafez.repositories.HafezRepository
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
    fun provideHafezRepository(
        hafezAppDataBase: HafezAppDataBase
    ): HafezRepository {
        return HafezRepository(
            hafezAppDataBase
        )
    }

}