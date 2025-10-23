package com.example.weathera

import androidx.lifecycle.ViewModel
import com.example.weathera.models.Weather
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.example.weathera.models.CurrentWeather
import com.example.weathera.models.Forecast
import com.example.weathera.R
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import com.example.weathera.models.Condition
import com.example.weathera.models.WeatherIcon

class MainViewModel : ViewModel() {
    private val _weather = MutableStateFlow<Weather?>(null)
    val weather: StateFlow<Weather?> = _weather.asStateFlow()

    init {
        val dateFormat = SimpleDateFormat("MMM dd yyyy", Locale.getDefault())
        val calendar = Calendar.getInstance()

        val weather = Weather(
            current = CurrentWeather(
                temperature = 22.5f,
                condition = Condition(
                    text = "Partly Cloudy",
                    weatherIcon = WeatherIcon(
                        condition = "Partly Cloudy",
                        resourceId = R.drawable.sunny_cloudy
                    )
                ),
                precipitationType = "Rain",
                precipitationAmount = 0.01f,
                windDirection = "NE",
                windSpeed = 15.0f,
                forecast = Forecast(
                    date = dateFormat.format(System.currentTimeMillis()),
                    highTemp = 24.0f,
                    lowTemp = 16.0f,
                    condition = Condition(
                        text = "Partly Cloudy",
                        weatherIcon = WeatherIcon(
                            condition = "Partly Cloudy",
                            resourceId = R.drawable.sunny_cloudy
                        )
                    ),
                    precipitationChance = 0.10f,
                    precipitationType = "Rain",
                    precipitationAmount = 0.01f,
                    windDirection = "NE",
                    windSpeed = 15.0f,
                    humidity = 0.6f,
                )
            ),
            forecast = List<Forecast>(
                7) { index ->
                calendar.timeInMillis = System.currentTimeMillis()
                calendar.add(Calendar.DAY_OF_YEAR, index)
                val formattedDate = dateFormat.format(calendar.time)
                Forecast(
                    date = formattedDate,
                    highTemp = 18.0f + index,
                    lowTemp = 10.0f + index,
                    condition = Condition(
                        text = if (index % 2 == 0) "Sunny" else "Cloudy",
                        weatherIcon = WeatherIcon(
                            condition = if (index % 2 == 0) "Sunny" else "Cloudy",
                            resourceId = if (index % 2 == 0) R.drawable.sunny else R.drawable.cloudy
                        )
                    ),
                    precipitationChance = if (index % 3 == 0) 0.20f else 0.10f,
                    precipitationType = if (index % 3 == 0) "Rain" else "None",
                    precipitationAmount = if (index % 3 == 0) 2.0f else 0.0f,
                    windDirection = if (index % 2 == 0) "NW" else "NE",
                    windSpeed = 10.0f + index,
                    humidity = 55.0f + index,
                )

            }
        )

        _weather.value = weather
    }
}