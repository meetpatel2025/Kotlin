package com.training.androidfundametalsapp

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.training.androidfundametalsapp.baseui.topicList
import com.training.androidfundametalsapp.baseui.topicsHomeScreen
import com.training.androidfundametalsapp.model.Topics
import com.training.androidfundametalsapp.model.UiTopics

@Composable
fun listOfTopics(data: List<UiTopics>, onClick: (UiTopics) -> Unit) {
    LazyColumn(content = {
        items(data, key = { it.topicID }) { topic ->
            topicList(topic = topic, onClick = onClick)
        }
    })

}