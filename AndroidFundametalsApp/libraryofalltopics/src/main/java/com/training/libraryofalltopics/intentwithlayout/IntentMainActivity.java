package com.training.libraryofalltopics.intentwithlayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.training.libraryofalltopics.R;

public class IntentMainActivity extends AppCompatActivity {

    Button linearLayoutBtn, constraintLayoutBtn, relativeLayoutBtn, explicitIntentBtn, implicitContentBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.intent_activity_main);
        linearLayoutBtn = findViewById(R.id.linearLayoutBtn);
        constraintLayoutBtn = findViewById(R.id.constraintLayoutBtn);
        relativeLayoutBtn = findViewById(R.id.relativeLayoutBtn);
        explicitIntentBtn = findViewById(R.id.explicitIntentBtn);
        implicitContentBtn = findViewById(R.id.implicitContentBtn);

        linearLayoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayoutPage();
            }
        });
        relativeLayoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativeLayoutPage();
            }
        });
        constraintLayoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                constraintLayoutPage();
            }
        });
        implicitContentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                implicitIntentPage();
            }
        });
        explicitIntentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                explicitIntentPage();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void linearLayoutPage(){
        Intent linearIntent = new Intent(this, LinearLayoutActivity.class);
        startActivity(linearIntent);
    }

     public void relativeLayoutPage(){
        Intent reativeIntent = new Intent(this, RelativeLayoutActivity.class);
        startActivity(reativeIntent);
    }
    public void constraintLayoutPage(){
        Intent constraintIntent = new Intent(this, ConstraintLayout.class);
        startActivity(constraintIntent);
    }
    public void explicitIntentPage(){
        Intent explicitIntent = new Intent(this, ExplicitIntent.class);
        startActivity(explicitIntent);
    }

    public void implicitIntentPage(){
        Uri webPage = Uri.parse("https://www.google.com");
        Intent implicitIntent = new Intent(Intent.ACTION_VIEW, webPage);
        startActivity(implicitIntent);
    }
}