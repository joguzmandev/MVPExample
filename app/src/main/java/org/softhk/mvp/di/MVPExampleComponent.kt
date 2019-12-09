package org.softhk.mvp.di

import dagger.Component
import org.softhk.mvp.data.repository.di.RepositoryModule
import org.softhk.mvp.data.repository.local.di.NoteLocalDataSourceModule
import org.softhk.mvp.presenter.di.NoteMainPresenterModule
import org.softhk.mvp.ui.main.MainActivity
import org.softhk.mvp.ui.main.di.MainActivityModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        MVPExampleModule::class,
        NoteLocalDataSourceModule::class,
        RepositoryModule::class,
        NoteMainPresenterModule::class,
        MainActivityModule::class
    ]
)
interface MVPExampleComponent {

    fun inject(mainActivity: MainActivity)
}