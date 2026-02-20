package com.training.libraryofalltopics.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.training.libraryofalltopics.R;

public class AdapterMainActivity extends AppCompatActivity {

    Button arrayAdapterBtn, customArrayAdapterBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.adapter_activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        arrayAdapterBtn = findViewById(R.id.adapterArrayBtn);
        customArrayAdapterBtn = findViewById(R.id.customAdapeterBtn);

        arrayAdapterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayAdapterPage();
            }
        });

        customArrayAdapterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customAdapterPage();
            }
        });

    }

    public void arrayAdapterPage(){
        Intent intent = new Intent(
                this,
                ArrayAdapter.class
        );
        startActivity(intent);
    }
    public void customAdapterPage(){
        Intent intent = new Intent(
                this,
                CustomAdapter.class
        );
        startActivity(intent);
    }
}