package com.training.androidfundametalsapp.baseui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.training.androidfundametalsapp.model.Topics
import com.training.androidfundametalsapp.model.UiTopics

@Composable
fun topicListScreen(data: List<UiTopics>, onClick : (UiTopics) -> Unit){
    LazyColumn(content = {
        items(data, key = {it.topicID}){ topic ->
            topicList(topic, onClick)
        }
    })
}