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

@Composable
fun DailyForecast() {
    Column {
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Text(text = "Daily Forecasts")
        }
        LazyColumn {
            items(7) { day ->
                Row(modifier = Modifier.padding(all = 10.dp)) {
                    Text(text = "Day ${day + 1}")
                    Text(text = "☀️")
                    Text(text = "High: 75°F")
                    Text(text = "Low: 55°F")
                    Text(text = "P.O.P.: 10%")
                }
            }
        }
    }

}