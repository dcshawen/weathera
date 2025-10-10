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
import androidx.compose.foundation.Image
import com.example.weathera.models.Forecast
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.res.painterResource

@Composable
fun DailyForecast(forecasts: List<Forecast>) {
    Column {
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Text(
                text = "Daily Forecasts",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.primary
            )
        }
        LazyColumn {
            items(forecasts) { forecast ->
                Row(modifier = Modifier.padding(all = 10.dp)) {
                    Text(
                        text = forecast.date,
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Image(
                        painter = painterResource(forecast.weatherIcon.resourceId),
                        contentDescription = "Weather Icon",
                        modifier = Modifier.padding(start = 8.dp)
                    )
                    Column {
                        Text(
                            text = "High: ${forecast.highTemp}",
                            modifier = Modifier.padding(start = 8.dp)
                        )
                        Text(
                            text = "Low: ${forecast.lowTemp}",
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                    Text(
                        text = "P.O.P.: ${forecast.precipitationChance}",
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        }
    }
}
