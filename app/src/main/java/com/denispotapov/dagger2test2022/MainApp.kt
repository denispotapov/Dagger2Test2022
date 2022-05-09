package com.denispotapov.dagger2test2022

import android.app.Application
import android.content.Context
import com.denispotapov.dagger2test2022.component.AppComponent
import com.denispotapov.dagger2test2022.subcomponent.DaggerAppComponent

class MainApp : Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .context(this)
            .build()
    }
}

val Context.appComponent: AppComponent
    get() = when (this) {
        is MainApp -> appComponent
        else -> applicationContext.appComponent
    }