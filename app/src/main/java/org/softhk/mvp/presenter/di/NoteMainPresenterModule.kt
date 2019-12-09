package org.softhk.mvp.presenter.di

import dagger.Module
import dagger.Provides
import org.softhk.mvp.data.repository.Repository
import org.softhk.mvp.data.repository.ds.NoteDataSource
import org.softhk.mvp.presenter.NoteMainPresenter
import org.softhk.mvp.presenter.NoteMainPresenterContract
import org.softhk.mvp.ui.main.MainActivityContract
import javax.inject.Singleton

@Module
class NoteMainPresenterModule {

    @Provides
    @Singleton
    fun providerNoteMainPresenter(
        view: MainActivityContract,
        repository: Repository
    ): NoteMainPresenterContract {
        return NoteMainPresenter(view, repository)
    }
}