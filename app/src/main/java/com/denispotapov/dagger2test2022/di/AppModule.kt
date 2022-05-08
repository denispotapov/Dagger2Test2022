package com.denispotapov.dagger2test2022.di

import com.denispotapov.dagger2test2022.data.NewsService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create

@Module(includes = [NetworkModule::class, AppBindModule::class])
class AppModule

@Module
class NetworkModule {

    @Provides
    fun provideProductionNewsService(): NewsService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://androidbrodcast.dev")
            .build()
        return retrofit.create()
    }

    @Provides
    @Stage
    fun provideStageNewsService(): NewsService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://stage.androidbrodcast.dev")
            .build()
        return retrofit.create()
    }

}