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

public class LuckyNumberMainActivity extends AppCompatActivity {

    Button button;
    TextView editText,welcomeTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.luckynum_activity_main);

        button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);
        welcomeTxt = findViewById(R.id.welcomeTxt);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String userName = editText.getText().toString();
            Intent i = new Intent(getApplicationContext(), LuckNumberScreen.class);

            i.putExtra("userName", userName);
            startActivity(i);
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

}