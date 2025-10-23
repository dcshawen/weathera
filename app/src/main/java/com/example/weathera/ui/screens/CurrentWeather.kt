package com.example.weathera.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.example.weathera.models.CurrentWeather
import com.example.weathera.models.WeatherIcon
import com.example.weathera.R

@Composable
fun CurrentWeather(current: CurrentWeather) {
    Column(
        modifier = Modifier
            .padding(all = 10.dp)
    ) {
        Text(
            text = current.condition.text,
            modifier = Modifier.padding(bottom = 10.dp),
            style = androidx.compose.material3.MaterialTheme.typography.headlineLarge,
            color = androidx.compose.material3.MaterialTheme.colorScheme.primary
        )
        Row(modifier = Modifier.padding(bottom = 10.dp)) {
            Image(
                painter = androidx.compose.ui.res.painterResource(id = current.condition.weatherIcon.resourceId),
                contentDescription = "${current.condition} Icon"
            )
            Text(
                text = current.temperature.toString() + "°C",
                modifier = Modifier.padding(start = 10.dp)
                    .align(Alignment.CenterVertically),
                style = androidx.compose.material3.MaterialTheme.typography.headlineLarge,
                color = androidx.compose.material3.MaterialTheme.colorScheme.primary
            )
        }
        Column(
            modifier = Modifier
                .padding(all = 10.dp)
        ) {
            Row(modifier = Modifier.padding(all = 8.dp)){
                Text(
                    modifier = Modifier.padding(end = 8.dp),
                    text = "${current.forecast.precipitationChance * 100}% Chance of Precipitation."
                )
            }
            Row(modifier = Modifier.padding(all = 8.dp)){
                Text(
                    modifier = Modifier.padding(end = 8.dp),
                    text = "Condition: ${current.condition.text}"
                )
            }
            Text(
                modifier = Modifier.padding(all = 8.dp),
                text = "Wind ${current.windDirection} at ${current.windSpeed} km/h"
            )
        }
    }
}