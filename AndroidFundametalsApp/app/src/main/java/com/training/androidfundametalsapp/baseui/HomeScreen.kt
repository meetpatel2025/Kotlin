package com.training.androidfundametalsapp.baseui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.training.androidfundametalsapp.model.Topics

@Composable
fun topicsHomeScreen(data: Array<Topics>/*, onClick : () -> Unit*/) {
    Column() {
        Text(
            "Android Fundamentals",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(8.dp, 44.dp, 8.dp, 14.dp)
                .fillMaxWidth(1f),
            style = MaterialTheme.typography.headlineMedium
        )

        topicListScreen(data = data/*, onClick*/)
    }
}