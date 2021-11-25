package com.gamecast.movies.di

import android.content.Context
import com.gamecast.domain.di.DataComponent
import com.gamecast.movies.home.di.HomeComponent
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        ViewModelModule::class,
        SubcomponentsModule::class
    ]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }

    fun homeComponent(): HomeComponent.Factory
}

@Module(
    subcomponents = [
        DataComponent::class,
        HomeComponent::class
    ]
)
object SubcomponentsModule