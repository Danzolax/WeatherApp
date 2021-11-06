package com.zolax.weatherapp.utils

import android.content.Context
import com.zolax.weatherapp.App
import com.zolax.weatherapp.di.AppComponent

val Context.appComponent: AppComponent
    get() = when(this){
        is App -> appComponent
        else -> this.applicationContext.appComponent
    }