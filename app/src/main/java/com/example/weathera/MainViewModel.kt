package com.example.weathera

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weathera.models.Weather
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.example.weathera.models.CurrentWeather
import com.example.weathera.models.Forecast
import com.example.weathera.models.ForecastDay
import com.example.weathera.models.Day
import com.example.weathera.models.Condition
import com.example.weathera.R
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.weathera.services.WeatherService
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _weather = MutableStateFlow<Weather?>(null)
    val weather: StateFlow<Weather?> = _weather.asStateFlow()
    // Development Variables
    val location = "Halifax, NS"
    val apiKey = "62f4d53552f74096a92120610251710"

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.weatherapi.com/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val weatherService: WeatherService = retrofit.create(WeatherService::class.java)

    init {
        val dateFormat = SimpleDateFormat("MMM dd yyyy", Locale.getDefault())
        val calendar = Calendar.getInstance()

        viewModelScope.launch {
            val weather = weatherService.getWeather(apiKey, location)
            _weather.value = weather
        }


    }
}