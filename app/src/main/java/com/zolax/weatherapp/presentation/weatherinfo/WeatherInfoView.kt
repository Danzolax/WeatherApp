package com.zolax.weatherapp.presentation.weatherinfo

interface WeatherInfoView {
    fun showWeather(text: String)
    fun showLoading(isShow:Boolean)
    fun showError(text: String)
}