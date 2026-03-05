package com.training.retrofitapp

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val title : TextView = findViewById(R.id.title)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val retrofitService = RetrofitInstance
            .getRetrofitInstance()
            .create(AlbumService::class.java)

        val responseLiveData : LiveData<Response<Albums>> =
            liveData {
            val response = retrofitService.getAlbums()
//                val responseOfUserID = retrofitService.getAlbumByUserID(4)
            emit(response)
        }

        responseLiveData.observe(
            this,
            {
                val albumsList = it.body()?.listIterator()

                if(albumsList != null){
                    val allTitles = StringBuilder()

                    while(albumsList.hasNext()){
                        val albumItem = albumsList.next()
                        Log.i("TAG",   albumItem.title)

                        val result = "Album Title : ${albumItem.title}\n"
                        allTitles.append(result)
                    }
                        title.text = allTitles.toString()
                }
            }
        )
    }
}