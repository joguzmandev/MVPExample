package org.softhk.mvp.presenter.di

import dagger.Module
import dagger.Provides
import org.softhk.mvp.data.repository.Repository
import org.softhk.mvp.presenter.NoteMainPresenter
import org.softhk.mvp.contract.MainActivityPresenterContract
import javax.inject.Singleton

@Module
class NoteMainPresenterModule {

    @Provides
    @Singleton
    fun providerNoteMainPresenter(
        view: MainActivityPresenterContract.view,
        repository: Repository
    ): MainActivityPresenterContract.presenter {
        return NoteMainPresenter(view, repository)
    }
}