package com.training.libraryofalltopics.unit;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.training.libraryofalltopics.R;

public class UnitMainActivity extends AppCompatActivity {

    TextView unitConvertionTitle, poundDigit;
    Button convertButton;
    EditText inputWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.unit_activity_main);

        unitConvertionTitle = findViewById(R.id.unitConverterTitle);
        poundDigit = findViewById(R.id.poundDigit);
        convertButton = findViewById(R.id.convertBtn);
        inputWeight = findViewById(R.id.inputWeight);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weightInString = inputWeight.getText().toString();
                if (weightInString.isEmpty()) {
                    inputWeight.setError("Please enter weight");
                    return;
                }

                double weightInKG = Double.parseDouble(weightInString);
                poundDigit.setText("" + unitConversion(weightInKG));
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public double unitConversion(double kg){
        return kg * 2.20462;
    }
}