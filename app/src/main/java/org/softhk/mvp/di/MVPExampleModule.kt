package org.softhk.mvp.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import org.softhk.mvp.ui.main.MainActivity
import org.softhk.mvp.contract.MainActivityPresenterContract
import javax.inject.Singleton

@Module
class MVPExampleModule constructor(var application: Application, var mainActivity: MainActivity) {

    @Provides
    @Singleton
    fun providerContext(): Context = application.applicationContext

    @Provides
    fun providerMainActivy(): MainActivityPresenterContract.view {
        return mainActivity
    }


}