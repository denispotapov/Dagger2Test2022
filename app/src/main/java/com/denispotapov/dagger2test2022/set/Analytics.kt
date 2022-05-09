package com.denispotapov.dagger2test2022.set

import javax.inject.Inject

class Analytics @Inject constructor(
    private val trackers: Set<@JvmSuppressWildcards AnalyticsTracker>
) {

    fun trackLogEvent(event: AnalyticsTracker.Event) {
        trackers.forEach { tracker ->
            tracker.trackEvent(event)
        }
    }
}