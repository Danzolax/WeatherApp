package com.zolax.weatherapp.presentation.weatherinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import com.zolax.weatherapp.data.api.Network
import com.zolax.weatherapp.databinding.ActivityWeatherInfoBinding
import timber.log.Timber

class WeatherInfoActivity : AppCompatActivity(), WeatherInfoView {

    private lateinit var binding: ActivityWeatherInfoBinding

    private var weatherInfoPresenter: WeatherInfoPresenter = WeatherInfoPresenter(this,Network)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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


}