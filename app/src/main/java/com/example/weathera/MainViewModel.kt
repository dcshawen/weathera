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


class MainViewModel : ViewModel() {
    private val _weather = MutableStateFlow<Weather?>(null)
    val weather: StateFlow<Weather?> = _weather.asStateFlow()

    init {
        val dateFormat = SimpleDateFormat("MMM dd yyyy", Locale.getDefault())
        val calendar = Calendar.getInstance()

        val weather = Weather(
            current = CurrentWeather(
                temperature = "15°C",
                condition = "Sunny",
                precipitationChance = "10%",
                precipitationType = "None",
                precipitationAmount = "0 mm",
                windDirection = "NW",
                windSpeed = "8 km/h",
                weatherIcon = com.example.weathera.models.WeatherIcon(
                    condition = "Sunny",
                    resourceId = R.drawable.sunny
                )
            ),
            forecast = List<Forecast>(
                7) { index ->
                calendar.timeInMillis = System.currentTimeMillis()
                calendar.add(Calendar.DAY_OF_YEAR, index)
                val formattedDate = dateFormat.format(calendar.time)
                Forecast(
                    date = formattedDate,
                    highTemp = "${18 + index}°C",
                    lowTemp = "${10 + index}°C",
                    condition = if (index % 2 == 0) "Sunny" else "Cloudy",
                    precipitationChance = if (index % 3 == 0) "20%" else "10%",
                    precipitationType = if (index % 3 == 0) "Rain" else "None",
                    precipitationAmount = if (index % 3 == 0) "2 mm" else "0 mm",
                    windDirection = if (index % 2 == 0) "NW" else "NE",
                    windSpeed = "${10 + index} km/h",
                    humidity = "${55 + index}%",
                    weatherIcon = com.example.weathera.models.WeatherIcon(
                        condition = if (index % 2 == 0) "Sunny" else "Cloudy",
                        resourceId = if (index % 2 == 0) R.drawable.sunny else R.drawable.cloudy
                    )
                )
            }
        )

        _weather.value = weather
    }
}