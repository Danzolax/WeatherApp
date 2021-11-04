package com.zolax.weatherapp.data.api

import com.zolax.weatherapp.data.models.Response
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherReqeustApi {
    @GET("data/2.5/weather")
    fun getCurrentWeather(@Query("q") city:String, @Query("appid") key: String): Observable<Response>
}