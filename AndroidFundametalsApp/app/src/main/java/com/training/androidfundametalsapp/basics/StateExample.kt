package com.training.androidfundametalsapp.basics

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun NotificationScreen(){
    var count: MutableState<Int> = rememberSaveable { mutableIntStateOf(0) }
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(1f)) {
        NotificationCounter(count.value, {count.value++}, Modifier.padding(12.dp))

    }
}

@Composable
fun NotificationCounter(count:Int, increment:() -> Unit, modifier: Modifier){
    Column(verticalArrangement = Arrangement.Center) {
        Text(text = "You have sent $count notifications")
        Button(onClick = {increment()}) {
            Text(text = "Send Notification")
        }
    }
}