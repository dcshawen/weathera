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
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.res.painterResource
import com.example.weathera.R
import kotlin.random.Random
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import java.util.Calendar
import java.text.SimpleDateFormat
import java.util.Locale
import androidx.compose.material3.MaterialTheme

@Composable
fun DailyForecast() {
    val forecasts = generateRandomForecasts()

    Column {
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Text(text = "Daily Forecasts",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.primary)
        }
        LazyColumn() {
            items(forecasts) { data ->
                Row(modifier = Modifier.padding(all = 10.dp)) {
                    Text(
                        text = data.day,
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Image(
                        painter = painterResource(data.icon),
                        contentDescription = "Weather Icon",
                        modifier = Modifier.padding(start = 8.dp)
                    )
                    Column {
                        Text(
                            text = "High: ${data.highTemp}",
                            modifier = Modifier.padding(start = 8.dp)
                        )
                        Text(
                            text = "Low: ${data.lowTemp}",
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }

                    Text(
                        text = "P.O.P.: ${data.pop}",
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        }
    }
}

fun generateRandomForecasts(): List<DailyForecastData> {
    val icons = listOf(R.drawable.sunny, R.drawable.rain, R.drawable.cloudy, R.drawable.snow, R.drawable.sunny_cloudy)
    val sdf = SimpleDateFormat("MMM dd", Locale.getDefault())
    val calendar = Calendar.getInstance()
    val days = List(8) { i ->
        calendar.time = Calendar.getInstance().time
        calendar.add(Calendar.DAY_OF_YEAR, i)
        sdf.format(calendar.time)
    }
    return days.mapIndexed { i, date ->
        DailyForecastData(
            day = date,
            icon = icons.random(),
            highTemp = "${Random.nextInt(18, 25)}°C",
            lowTemp = "${Random.nextInt(5, 20)}°C",
            pop = "${Random.nextInt(0, 100)}%"
        )
    }
}

class DailyForecastData(
    val day: String,
    val icon: Int,
    val highTemp: String,
    val lowTemp: String,
    val pop: String
)