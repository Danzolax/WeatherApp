package com.zolax.weatherapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.zolax.weatherapp.BuildConfig
import com.zolax.weatherapp.R
import com.zolax.weatherapp.data.api.Network
import com.zolax.weatherapp.data.models.Response
import com.zolax.weatherapp.databinding.ActivityMainBinding
import retrofit2.*
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Network.service.getCurrentWeather("moscow", BuildConfig.WEATHER_API_KEY).enqueue(object : Callback<Response>{
            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                binding.text.text = response.body().toString()
            }

            override fun onFailure(call: Call<Response>, t: Throwable) {
                Timber.d("(")
            }

        })
    }
}