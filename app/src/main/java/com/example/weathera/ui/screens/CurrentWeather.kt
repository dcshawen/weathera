package com.example.weathera.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun CurrentWeather() {
    val date = "September 24 2025" // Example date
    Column {
        Text(text = "Current Weather Screen")
        Text(text = "The daily forecast for $date is:")
    }
}