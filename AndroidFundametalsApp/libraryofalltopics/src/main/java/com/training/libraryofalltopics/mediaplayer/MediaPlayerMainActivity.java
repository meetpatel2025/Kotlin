package com.training.libraryofalltopics.mediaplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.training.libraryofalltopics.R;

public class MediaPlayerMainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button mahadev, radhaVallabh, radha;
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.media_player_activity_main);

        mahadev = findViewById(R.id.mahadev);
        radhaVallabh = findViewById(R.id.radhaVallabh);
        radha = findViewById(R.id.radha);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mahadev.setOnClickListener(this);
        radhaVallabh.setOnClickListener(this);
        radha.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int clickedBtnID = v.getId();

        if(clickedBtnID == R.id.mahadev){
            makeSound(R.raw.mahadev_mahadev);
        }else if (clickedBtnID == R.id.radhaVallabh){
            makeSound(R.raw.radhavallabh);
        }else if(clickedBtnID == R.id.radha){
            makeSound(R.raw.radha);
        }
    }

    public void makeSound(int id){
        MediaPlayer mediaPlayer = MediaPlayer.create(
                this,
                id
        );
        mediaPlayer.start();
    }
}