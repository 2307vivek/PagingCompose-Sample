package com.training.pagingcompose

import android.app.Application
import com.training.pagingcompose.di.networkModule
import com.training.pagingcompose.di.repositoryModule
import com.training.pagingcompose.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApp)
            modules(listOf(networkModule, repositoryModule, viewModelModule))
        }
    }
}