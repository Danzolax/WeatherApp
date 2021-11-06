package com.zolax.weatherapp

import android.app.Application
import android.content.Context
import com.zolax.weatherapp.di.AppComponent
import com.zolax.weatherapp.di.DaggerAppComponent
import timber.log.Timber

class App : Application() {

    lateinit var  appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        appComponent = DaggerAppComponent.create()

    }

}