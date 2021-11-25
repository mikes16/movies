package com.gamecast.domain.di

import dagger.Provides
import dagger.Subcomponent

@Subcomponent(
    modules = [DomainModule::class]
)
interface DataComponent {}