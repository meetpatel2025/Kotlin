package com.training.androidfundametalsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.training.androidfundametalsapp.baseui.topicsHomeScreen
import com.training.androidfundametalsapp.model.Topics
import com.training.androidfundametalsapp.ui.theme.AndroidFundametalsAppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        CoroutineScope(Dispatchers.IO).launch {
            TopicsController.loadAssetsFromJSON(applicationContext)
        }
        setContent {
            app()
        }
    }
}

@Composable
private fun MainActivity.app() {
    val context = LocalContext.current
    topicsHomeScreen(data = TopicsController.topicsList, onClick = { topic ->
        openLegacyActivity(context, topic.file)})
}
