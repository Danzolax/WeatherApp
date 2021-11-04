package com.zolax.weatherapp.presentation.weatherinfo

import com.zolax.weatherapp.BuildConfig
import com.zolax.weatherapp.data.api.Network
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import timber.log.Timber

class WeatherInfoPresenter(
    private val weatherInfoView: WeatherInfoView,
    private val api: Network
) {


    public fun loadWeather() {
        weatherInfoView.showLoading(true)
        api.service.getCurrentWeather("moscow", BuildConfig.WEATHER_API_KEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { response -> response.main.temp.toString() }
            .subscribe(
                { temp ->
                    weatherInfoView.showWeather(temp)
                },
                { error ->
                    error.printStackTrace()
                    Timber.d("Error")

                })
    }
}

//api.service.getCurrentWeather("moscow", BuildConfig.WEATHER_API_KEY).sub
//.enqueue(object : Callback<Response> {
//    override fun onResponse(
//        call: Call<Response>,
//        response: retrofit2.Response<Response>
//    ) {
//        weatherInfoView.showLoading(false)
//
//        weatherInfoView.showWeather(response.body().toString())
//    }
//
//    override fun onFailure(call: Call<Response>, t: Throwable) {
//        weatherInfoView.showLoading(true)
//        weatherInfoView.showError("Can't bring information")
//
//    }
//
//})