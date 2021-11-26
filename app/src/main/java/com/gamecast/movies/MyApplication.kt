package com.gamecast.movies

import android.app.Application
import com.gamecast.movies.di.DaggerAppComponent

class MyApplication : Application() {

    val appComponent by lazy {
        DaggerAppComponent.factory().create(this)
    }

}