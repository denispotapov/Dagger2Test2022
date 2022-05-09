package com.denispotapov.dagger2test2022.set

import com.denispotapov.dagger2test2022.utils.AppScope
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.multibindings.ElementsIntoSet
import dagger.multibindings.IntoSet

@Component(modules = [AppModule::class])
@AppScope
interface AppComponent {

    val analyticsTrackers: Set<@JvmSuppressWildcards AnalyticsTracker>

    val analytics: Analytics
}

@Module
class AppModule {

    @Provides
    @IntoSet // Добавление зависимости в Set
    fun provideFacebookTracker(): AnalyticsTracker = FacebookAnalyticsTracker()

    @Provides
    @ElementsIntoSet // Возможность добавить несколько элементов в Set
    fun provideMultipleTrackers(
        firebaseAnalyticsTracker: FirebaseAnalyticsTracker,
        appMetricaTracker: AppMetricaTracker
    ): Set<AnalyticsTracker> = setOf(firebaseAnalyticsTracker, appMetricaTracker)
}