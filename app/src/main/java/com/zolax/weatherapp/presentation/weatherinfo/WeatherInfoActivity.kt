package com.zolax.weatherapp.presentation.weatherinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.zolax.weatherapp.data.api.WeatherService
import com.zolax.weatherapp.databinding.ActivityWeatherInfoBinding
import com.zolax.weatherapp.presentation.views.WeatherView
import com.zolax.weatherapp.utils.appComponent
import dagger.Lazy
import timber.log.Timber
import javax.inject.Inject




class WeatherInfoActivity : AppCompatActivity(), WeatherInfoView {

    private lateinit var binding: ActivityWeatherInfoBinding

    @Inject
    lateinit var api: WeatherService


    @Inject
    lateinit var weatherInfoPresenterFactory: WeatherInfoPresenter.Factory

    private val weatherInfoPresenter: WeatherInfoPresenter by lazy { weatherInfoPresenterFactory.create(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        binding = ActivityWeatherInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        weatherInfoPresenter.loadWeather()
    }




    override fun showWeather(text: String){
        binding.text.text = text
    }

    override fun showLoading(isShow: Boolean) {
        Timber.d("Loading: $isShow")
    }

    override fun showError(text: String) {
        Snackbar.make(binding.root,text,Snackbar.LENGTH_SHORT).show()
    }

    override fun showWeatherType(type: WeatherView.WeatherType) {
        binding.weatherType.setWeatherType(type)
    }

}