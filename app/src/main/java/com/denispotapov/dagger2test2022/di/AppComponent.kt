package com.denispotapov.dagger2test2022.di

import com.denispotapov.dagger2test2022.MainActivity
import com.denispotapov.dagger2test2022.NewsDetailsFragment
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(activity: MainActivity)

    fun inject(fragment: NewsDetailsFragment)

}