package com.denispotapov.dagger2test2022

import android.app.Application
import android.content.Context
import com.denispotapov.dagger2test2022.di.AppComponent
import com.denispotapov.dagger2test2022.di.DaggerAppComponent

class MainApp : Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }

}

val Context.appComponent: AppComponent
    get() = when (this) {
        is MainApp -> appComponent
        else -> this.applicationContext.appComponent

    }