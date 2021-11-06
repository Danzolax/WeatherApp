package com.zolax.weatherapp.presentation.weatherinfo

import android.util.Log
import com.zolax.weatherapp.BuildConfig
import com.zolax.weatherapp.data.api.WeatherService
import com.zolax.weatherapp.presentation.views.WeatherView
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import timber.log.Timber
import java.util.concurrent.TimeUnit

class WeatherInfoPresenter @AssistedInject constructor(
    @Assisted("weatherInfoView") private val weatherInfoView: WeatherInfoView,
    private val api: WeatherService
) {


    fun loadWeather() {
        weatherInfoView.showLoading(true)
        api.getCurrentWeather("moscow", BuildConfig.WEATHER_API_KEY)
            .delay(5, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .map { response -> Pair(response.weather[0].main, response.main.temp.toString()) }
            .doAfterTerminate { weatherInfoView.showLoading(false) }
            .subscribe { temp ->
                weatherInfoView.showWeather(temp.second)
                Timber.d("type = ${temp.first}")

                when (temp.first) {
                    "Rain" -> weatherInfoView.showWeatherType(WeatherView.WeatherType.RAIN)
                    "Clear" -> weatherInfoView.showWeatherType(WeatherView.WeatherType.SUN)
                    "Clouds" -> weatherInfoView.showWeatherType(WeatherView.WeatherType.CLOUDS)
                    else -> weatherInfoView.showWeatherType(WeatherView.WeatherType.SUN)
                }
            }
    }

    @AssistedFactory
    interface Factory {
        fun create(@Assisted("weatherInfoView") weatherInfoView: WeatherInfoView): WeatherInfoPresenter
    }

}

