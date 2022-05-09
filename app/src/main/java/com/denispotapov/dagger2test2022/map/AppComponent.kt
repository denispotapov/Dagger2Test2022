package com.denispotapov.dagger2test2022.map

import androidx.lifecycle.ViewModel
import com.denispotapov.dagger2test2022.utils.AppScope
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.multibindings.IntoMap

@Component(modules = [AppBindsModule::class])
@AppScope
interface AppComponent {

    val factory: MultiViewModelFactory

    val secondComponent: SecondComponent.Builder

    @Component.Builder
    interface Builder {

        fun build(): AppComponent
    }
}

@Module(subcomponents = [SecondComponent::class])
interface AppBindsModule {

    @Binds
    @[IntoMap ViewModelKey(MainViewModel::class)]
    fun provideMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @[IntoMap ViewModelKey(DetailsViewModel::class)]
    fun provideDetailsViewModel(detailsViewModel: DetailsViewModel): ViewModel
}