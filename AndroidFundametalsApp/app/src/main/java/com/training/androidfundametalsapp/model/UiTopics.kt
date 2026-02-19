package com.training.androidfundametalsapp.model

import androidx.compose.ui.graphics.vector.ImageVector


data class UiTopics(
    val topicID: Int,
    val topicHeader: String,
    val topicDescription: String,
    val imageName: ImageVector,
    val file: String
)

