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

@Composable
fun CurrentWeather() {
    val date = "September 24 2025"
    Column(
        modifier = Modifier
            .padding(all = 10.dp)
        ) {
        Text(text = date,
            modifier = Modifier.padding(bottom = 10.dp),
            style = androidx.compose.material3.MaterialTheme.typography.headlineLarge,
            color = androidx.compose.material3.MaterialTheme.colorScheme.primary)
        Row(modifier = Modifier.padding(bottom = 10.dp)) {
            Image(painter = androidx.compose.ui.res.painterResource(id = com.example.weathera.R.drawable.sunny),
                contentDescription = "Sunny Icon")
            Text(text = "22°C",
                modifier = Modifier.padding(start = 10.dp)
                    .align(Alignment.CenterVertically),
                style = androidx.compose.material3.MaterialTheme.typography.headlineLarge,
                color = androidx.compose.material3.MaterialTheme.colorScheme.primary)
        }
        Column(
            modifier = Modifier
                .fillMaxWidth(.5f)
                .padding(all = 10.dp)
        ) {
            Row(modifier = Modifier.padding(all = 8.dp)){
                Text(modifier = Modifier.padding(end = 8.dp),
                    text = "10% P.O.P.")
                Text(text = "Showers")
            }

            Text(modifier = Modifier.padding(all = 8.dp),
                text = "Wind NW at 14km/h")
        }
    }
}