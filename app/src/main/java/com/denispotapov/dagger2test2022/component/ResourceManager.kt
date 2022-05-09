package com.denispotapov.dagger2test2022.component

import android.content.Context
import javax.inject.Inject

@AppScope
class ResourceManager @Inject constructor(private val context: Context)