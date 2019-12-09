package org.softhk.mvp.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import org.softhk.mvp.ui.main.MainActivity
import org.softhk.mvp.ui.main.MainActivityContract
import javax.inject.Singleton
import kotlin.contracts.ReturnsNotNull

@Module
class MVPExampleModule constructor(var application: Application, var mainActivity: MainActivity) {


    @Provides
    @Singleton
    fun providerContext(): Context = application.applicationContext


    @Provides
    fun providerMainActivy(): MainActivityContract {
        return mainActivity
    }


}