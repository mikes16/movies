package com.gamecast.movies.di

import android.content.Context
import com.gamecast.data.di.DataBindModule
import com.gamecast.data.di.DataModule
import com.gamecast.domain.di.DomainModule
import com.gamecast.domain.repository.MoviesRepository
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
        SubcomponentsModule::class,
        DataModule::class,
        DomainModule::class
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
        HomeComponent::class
    ]
)
object SubcomponentsModule