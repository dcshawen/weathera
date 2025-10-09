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
    val weatherImage: Int
)

data class Forecast(
    val date: String,
    val weatherImage: Int,
    val highTemp: String,
    val lowTemp: String,
    val condition: String,
    val precipitationChance: String,
    val precipitationType: String,
    val precipitationAmount: String,
    val windDirection: String,
    val windSpeed: String,
    val humidity: String
)