package com.denispotapov.dagger2test2022.di

import android.app.Application
import com.denispotapov.dagger2test2022.api_module.NewsService
import com.denispotapov.news_list_module.ArticlesDeps
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Qualifier
import javax.inject.Scope

@[AppScope Component(modules = [AppModule::class])]
interface AppComponent : ArticlesDeps {

    override val newsService: NewsService

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        @BindsInstance
        fun apiKey(@NewsApiQualifier apiKey: String): Builder

        fun build(): AppComponent
    }
}

@Module
class AppModule {

    @[Provides AppScope]
    fun provideNewsService(@NewsApiQualifier apiKey: String) = NewsService(apiKey)
}

@Qualifier
annotation class NewsApiQualifier

@Scope
annotation class AppScope
