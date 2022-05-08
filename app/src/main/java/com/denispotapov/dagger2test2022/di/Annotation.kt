package com.denispotapov.dagger2test2022.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Prod


@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Stage