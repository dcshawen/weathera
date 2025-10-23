package com.example.weathera.models

data class Weather(
   val current: CurrentWeather,
   val forecast: List<Forecast>
)

data class CurrentWeather(
    val temperature: Float,
    val condition: Condition,
    val precipitationType: String,
    val precipitationAmount: Float,
    val windDirection: String,
    val windSpeed: Float,
    val forecast: Forecast
)

data class WeatherIcon(
    val condition: String,
    val resourceId: Int
)

data class Forecast(
    val date: String,
    val highTemp: Float,
    val lowTemp: Float,
    val condition: Condition,
    val precipitationChance: Float,
    val precipitationType: String,
    val precipitationAmount: Float,
    val windDirection: String,
    val windSpeed: Float,
    val humidity: Float,
)

data class Condition(
    val text: String,
    val weatherIcon: WeatherIcon
)