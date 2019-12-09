package org.softhk.mvp.data.repository.di

import dagger.Module
import dagger.Provides
import org.softhk.mvp.data.repository.LocalRepository
import org.softhk.mvp.data.repository.Repository
import org.softhk.mvp.data.repository.ds.NoteDataSource
import org.softhk.mvp.data.repository.local.NoteLocalDataSource
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun providerRepository(noteDataSource: NoteDataSource): Repository {
        return LocalRepository(noteDataSource)
    }
}