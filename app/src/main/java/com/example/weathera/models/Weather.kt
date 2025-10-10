package com.example.weathera.models

data class Weather(
   val current: CurrentWeather,
   val forecast: List<Forecast>
)

data class CurrentWeather(
    val temperature: String,
    val condition: String,
    val precipitationChance: String,
    val precipitationType: String,
    val precipitationAmount: String,
    val windDirection: String,
    val windSpeed: String,
    val weatherIcon: WeatherIcon
)

data class WeatherIcon(
    val condition: String,
    val resourceId: Int
)

data class Forecast(
    val date: String,
    val highTemp: String,
    val lowTemp: String,
    val condition: String,
    val precipitationChance: String,
    val precipitationType: String,
    val precipitationAmount: String,
    val windDirection: String,
    val windSpeed: String,
    val humidity: String,
    val weatherIcon: WeatherIcon
)