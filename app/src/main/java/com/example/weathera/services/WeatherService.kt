package com.example.weathera.services

import retrofit2.http.GET
import retrofit2.http.Path
import com.example.weathera.models.Weather
import retrofit2.http.Query

interface WeatherService {
    @GET("forecast.json")
    suspend fun getWeather(
        @Query("key") apiKey: String,
        @Query("q") location: String, // Location
        @Query("days") days: Int = 7
    ): Weather
}