@file:Suppress("MemberVisibilityCanBePrivate", "unused")

package com.denispotapov.dagger2test2022

import android.app.Application
import com.denispotapov.dagger2test2022.di.AppComponent
import com.denispotapov.dagger2test2022.di.DaggerAppComponent
import com.denispotapov.news_list_module.ArticlesDepsStore

class NewsApp : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .application(this)
            .apiKey(BuildConfig.NEWS_API_KEY)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        ArticlesDepsStore.deps = appComponent
    }
}
