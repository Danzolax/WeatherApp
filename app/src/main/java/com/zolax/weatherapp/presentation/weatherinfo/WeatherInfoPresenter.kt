package com.zolax.weatherapp.presentation.weatherinfo

import com.zolax.weatherapp.BuildConfig
import com.zolax.weatherapp.data.api.WeatherService
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit

class WeatherInfoPresenter @AssistedInject constructor(
    @Assisted("weatherInfoView") private val weatherInfoView: WeatherInfoView,
    private val api: WeatherService
) {


    fun loadWeather() {
        weatherInfoView.showLoading(true)
        api.getCurrentWeather("moscow", BuildConfig.WEATHER_API_KEY)
            .delay(5,TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .map { response -> response.main.temp.toString() }
            .doAfterTerminate { weatherInfoView.showLoading(false) }
            .subscribe { temp ->
                weatherInfoView.showWeather(temp)
            }
    }

    @AssistedFactory
    interface Factory {
        fun create(@Assisted("weatherInfoView") weatherInfoView: WeatherInfoView): WeatherInfoPresenter
    }

}

