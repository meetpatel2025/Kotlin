package com.training.androidfundametalsapp.baseui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.training.androidfundametalsapp.model.Topics

@Composable
fun topicListScreen(data: Array<Topics>/*, onClick : () -> Unit*/){
    LazyColumn(content = {
        items(data){
            topicList(it/*, onClick*/)
        }
    })
}