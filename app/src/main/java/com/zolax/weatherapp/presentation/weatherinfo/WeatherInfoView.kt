package com.zolax.weatherapp.presentation.weatherinfo

import com.zolax.weatherapp.presentation.views.WeatherView
import com.zolax.weatherapp.utils.ActivityView
import com.zolax.weatherapp.utils.LoadingView

interface WeatherInfoView : LoadingView,ActivityView {
    fun showWeather(text: String)
    fun showError(text: String)
    fun showWeatherType(type: WeatherView.WeatherType)
}