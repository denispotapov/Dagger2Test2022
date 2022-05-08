package com.denispotapov.dagger2test2022.data

import javax.inject.Inject

class Analytics @Inject constructor() {

    fun trackScreenShow() {}

    fun trackNewsRequest(newsId: String) {
        // Do nothing
    }
}

