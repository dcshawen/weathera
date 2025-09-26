package com.example.weathera.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CurrentWeather() {
    val date = "September 24 2025" // Example date
    Column(modifier = Modifier.padding(all = 10.dp)) {
        Row {
            Text(text = "☀️")
            Text(text = "72°F")
        }
        Column {
            Text(text = "The daily forecast for $date is:")
            Text(text = "Current Conditions: ")
            Text(text = "Temperature: ")
            Text(text = "Chance of Precipitation: ")
            Text(text = "Type of Precipitation: ")
            Text(text = "Wind Direction and Speed: ")
        }
    }
}