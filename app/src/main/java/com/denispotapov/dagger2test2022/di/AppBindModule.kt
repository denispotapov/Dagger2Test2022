package com.denispotapov.dagger2test2022.di

import com.denispotapov.dagger2test2022.data.NewsRepository
import com.denispotapov.dagger2test2022.data.NewsRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface AppBindModule {

    @Suppress("FunctionName")
    @Binds
    fun bindNewsRepositoryImpl(newsRepositoryImpl: NewsRepositoryImpl): NewsRepository

}