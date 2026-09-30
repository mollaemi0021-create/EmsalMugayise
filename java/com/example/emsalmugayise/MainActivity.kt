package com.example.emsalmugayise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class Match(
    val home: String,
    val away: String,
    val time: String,
    val homeOdds: Double,
    val drawOdds: Double,
    val awayOdds: Double
)

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            EmsalMugayiseApp()
        }
    }
}

@Composable
fun EmsalMugayiseApp() {

    val matches = listOf(
        Match(
            home = "İspaniya",
            away = "Xorvatiya",
            time = "21:45",
            homeOdds = 1.55,
            drawOdds = 4.20,
            awayOdds = 5.80
        ),
        Match(
            home = "Bolqarıstan",
            away = "Estoniya",
            time = "20:00",
            homeOdds = 2.10,
            drawOdds = 3.20,
            awayOdds = 3.40
        )
    )

    MaterialTheme {

        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text("Əmsal Müqayisə")
                    }
                )
            }
        ) { padding ->

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                items(matches) { match ->

                    MatchCard(match)
                }
            }
        }
    }
}

@Composable
fun MatchCard(match: Match) {

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = match.time,
                style = MaterialTheme.typography.labelMedium
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = match.home,
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = match.away,
                    style = MaterialTheme.typography.titleMedium
                )
            }

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text("1: ${match.homeOdds}")

                Text("X: ${match.drawOdds}")

                Text("2: ${match.awayOdds}")
            }

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Button(
                onClick = {
                    // Növbəti mərhələdə əmsal müqayisəsi burada açılacaq.
                },
                modifier = Modifier.fillMaxWidth()
            ) {

                Text("Əmsalları müqayisə et")
            }
        }
    }
}
