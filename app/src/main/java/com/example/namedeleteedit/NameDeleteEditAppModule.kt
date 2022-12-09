package com.example.namedeleteedit

import android.content.Context
import androidx.room.Room
import com.example.namedeleteedit.core.Common.Companion.tableName
import com.example.namedeleteedit.repository.NameRepository
import com.example.namedeleteedit.repository.NameRepositoryImpl
import com.example.namedeleteedit.room.NameDao
import com.example.namedeleteedit.room.NameDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class NameDeleteEditAppModule {

    @Provides
    fun provideNameDb(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            NameDb::class.java,
            tableName
        ).build()

    @Provides
    fun provideDao(nameDb: NameDb) = nameDb.nameDao()

    @Provides
    fun provideRepository(nameDao: NameDao): NameRepository {
        return NameRepositoryImpl(nameDao)
    }
}