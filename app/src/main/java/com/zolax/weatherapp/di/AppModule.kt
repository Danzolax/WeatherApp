package com.zolax.weatherapp.di

import com.zolax.weatherapp.data.api.Network
import dagger.Module

@Module(includes = [NetworkModule::class])
object AppModule {
}