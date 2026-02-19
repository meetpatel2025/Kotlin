package com.training.androidfundametalsapp.baseui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled._4kPlus
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import com.training.androidfundametalsapp.model.Topics
import com.training.androidfundametalsapp.model.UiTopics

//@Preview
@Composable
fun topicList(topic : UiTopics, onClick : (UiTopics) -> Unit){
    Card(colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .clickable{ onClick(topic)}
        ) {
        Row(modifier = Modifier.padding(16.dp)
            .height(IntrinsicSize.Min),
        verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                imageVector = topic.imageName,
                alignment = Alignment.TopStart,
                colorFilter = ColorFilter.tint(Color.Black),
                contentDescription = "Activity Lifecycle",
                modifier = Modifier.size(94.dp)
                    .background(Color.Transparent)

            )
            Spacer(modifier = Modifier.padding(12.dp))

            VerticalDivider(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(2.dp),
                color = Color(0xFFBBBBBB)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column() {
                Text(text = topic.topicHeader,
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(bottom = 4.dp))

                Text(text = topic.topicDescription,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 4.dp))
            }

        }
    }
}