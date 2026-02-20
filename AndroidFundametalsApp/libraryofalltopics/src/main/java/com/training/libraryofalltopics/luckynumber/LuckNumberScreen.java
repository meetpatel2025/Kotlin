package com.training.libraryofalltopics.luckynumber;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.training.libraryofalltopics.R;

import java.util.Random;

public class LuckNumberScreen extends AppCompatActivity {

    Button shareButton;
    TextView luckNumberTitle, luckNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_luck_number_screen);

        shareButton = findViewById(R.id.shareButton);
        luckNumberTitle = findViewById(R.id.luckNumberTitle);
        luckNumber = findViewById(R.id.luckyNumber);

        Intent i = getIntent();
        String userName = i.getStringExtra("userName");
        int luckyNumber = luckyNumber();

        luckNumber.setText(""+luckyNumber);
        shareButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick (View v){
                    shareData(userName, luckyNumber);
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public int luckyNumber() {
        Random random = new Random();
        int limitOfNumber = 100;
        int randomNumber = random.nextInt(limitOfNumber);
        return randomNumber;
    }

    public void shareData(String userName, int luckyNumber){
        Intent i = new Intent(Intent.ACTION_SEND); //send data to other app
        i.setType("text/plain");

        i.putExtra(Intent.EXTRA_SUBJECT, userName +" got lucky today!!");
        i.putExtra(Intent.EXTRA_TEXT, "Lucky number is : "+ luckyNumber);

        startActivity(Intent.createChooser(i, "Choose a Platform"));


    }


}