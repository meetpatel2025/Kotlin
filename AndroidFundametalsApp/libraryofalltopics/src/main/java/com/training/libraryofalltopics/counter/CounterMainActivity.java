package com.training.libraryofalltopics.counter;

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

public class CounterMainActivity extends AppCompatActivity {

    int count = 0;
    Button counterButton;
    Button resetButton;
    TextView appTitle, digitCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.counter_activity_main);

        counterButton = findViewById(R.id.countButton);
        resetButton = findViewById(R.id.resetButton);
        digitCount = findViewById(R.id.digitCount);

        counterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                digitCount.setText("" + incrementCount());
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count=0;
                digitCount.setText("" + count);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public int incrementCount(){
        return ++count;
    }
}