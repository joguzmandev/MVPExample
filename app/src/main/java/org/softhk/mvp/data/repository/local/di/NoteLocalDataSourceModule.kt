package org.softhk.mvp.data.repository.local.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import org.softhk.mvp.data.repository.ds.NoteDataSource
import org.softhk.mvp.data.repository.local.NoteDao
import org.softhk.mvp.data.repository.local.NoteDataBase
import org.softhk.mvp.data.repository.local.NoteLocalDataSource
import javax.inject.Singleton

@Module
class NoteLocalDataSourceModule {


    @Provides
    @Singleton
    fun providerNoteDao(context: Context): NoteDao {
        return Room.databaseBuilder(context, NoteDataBase::class.java, "DB2.db")
            .build().noteDao()
    }

    @Provides
    @Singleton
    fun providerNoteLocalDataSource(noteDao: NoteDao): NoteDataSource {
        return NoteLocalDataSource(noteDao)
    }

}