package com.training.quotesapp

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
import androidx.compose.ui.tooling.preview.Preview
import com.training.quotesapp.layouts.QuoteListItem
import com.training.quotesapp.layouts.QuoteListScreen
import com.training.quotesapp.ui.theme.QuotesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        DataManager.loadAssetsFromFile(this)
        setContent {
            app()
        }
    }
}

@Composable
fun app(){
    if(DataManager.isDataLoaded.value){
        QuoteListScreen(data = DataManager.data){

        }
    }
}