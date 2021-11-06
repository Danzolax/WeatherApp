package com.zolax.weatherapp.di

import com.zolax.weatherapp.data.api.WeatherService
import com.zolax.weatherapp.presentation.weatherinfo.WeatherInfoActivity
import com.zolax.weatherapp.presentation.weatherinfo.WeatherInfoPresenter
import com.zolax.weatherapp.presentation.weatherinfo.WeatherInfoPresenter_Factory
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(activity: WeatherInfoActivity)
}