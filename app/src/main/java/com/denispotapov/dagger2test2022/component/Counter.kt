package com.denispotapov.dagger2test2022.component

import dagger.Reusable
import javax.inject.Inject

@Reusable
class Counter @Inject constructor() {

    var count = 0
}