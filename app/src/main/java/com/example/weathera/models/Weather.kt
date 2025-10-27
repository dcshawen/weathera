package com.example.weathera.models

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("name") val name: String,
    @SerializedName("region") val region: String,
    @SerializedName("country") val country: String,
)

data class Weather(
    @SerializedName("current") val current: CurrentWeather,
    @SerializedName("forecast") val forecast: Forecast
)

data class CurrentWeather(
    @SerializedName("temp_c") val temperature: Float,
    @SerializedName("condition") val condition: Condition,
    @SerializedName("precip_mm") val precipitationAmount: Float,
    @SerializedName("wind_dir") val windDirection: String,
    @SerializedName("wind_kph") val windSpeed: Float
)

data class Forecast(
    @SerializedName("forecastday") val forecastDays: List<ForecastDay>
)

data class ForecastDay(
    @SerializedName("date") val date: String,
    @SerializedName("day") val day: Day
)

data class Day(
    @SerializedName("maxtemp_c") val highTemp: Float,
    @SerializedName("mintemp_c") val lowTemp: Float,
    @SerializedName("totalprecip_mm") val precipitationAmount: Float,
    @SerializedName("maxwind_kph") val widthSpeed: Float,
    @SerializedName("avghumidity") val humidity: Float,
    @SerializedName("daily_chance_of_rain") val precipitationChance: Float,
    @SerializedName("condition") val condition: Condition
)

data class Condition(
    @SerializedName("text") val text: String,
    @SerializedName("icon") val icon: String,
)