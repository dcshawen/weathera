package com.example.weathera.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import com.example.weathera.models.Forecast
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.Image
import coil.compose.rememberAsyncImagePainter
import androidx.compose.foundation.layout.size

@Composable
fun DailyForecast(forecasts: Forecast) {
    Column {
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Text(
                text = "Daily Forecasts",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.primary
            )
        }
        LazyColumn {
            items(forecasts.forecastDays) { forecast ->
                Row(modifier = Modifier.padding(all = 10.dp)) {
                    Text(
                        text = forecast.date,
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    val imageUrl = "https:${forecast.day.condition.icon}"
                    Image(
                        painter = rememberAsyncImagePainter(imageUrl),
                        contentDescription = "${forecast.day.condition.text} Icon",
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .size(48.dp)
                    )
                    Column {
                        Text(
                            text = "High: ${forecast.day.highTemp}°C",
                            modifier = Modifier.padding(start = 8.dp)
                        )
                        Text(
                            text = "Low: ${forecast.day.lowTemp}°C",
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                    Text(
                        text = "P.O.P.: ${forecast.day.precipitationChance}%",
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        }
    }
}
