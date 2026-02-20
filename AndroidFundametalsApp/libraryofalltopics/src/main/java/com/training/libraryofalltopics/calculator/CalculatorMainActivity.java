package com.training.libraryofalltopics.calculator;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.training.libraryofalltopics.R;

public class CalculatorMainActivity extends AppCompatActivity {

    Button  number0, number1, number2, number3, number4, number5, number6, number7, number8, number9, sumBtn, subBtn, divBtn, equalBtn, mulBtn;
    TextView resultText;
    double num1=0;
    int totalLen=0;
    String cur ="";
    String operation="";
    String resultTxt="";
    String calculation="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.calculator_activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0);
            return insets;
        });
        resultText = findViewById(R.id.resultText);
        sumBtn = findViewById(R.id.summation);
        subBtn = findViewById(R.id.substraction);
        mulBtn = findViewById(R.id.multiplication);
        divBtn = findViewById(R.id.division);
        equalBtn = findViewById(R.id.equals);
        resultText.setText("0");
    }
    public void numberClick(View v){
        Button b = (Button) v;
        String text = b.getText().toString();
        int txtLen = text.length();
        totalLen += txtLen;
        if(totalLen > 7 && totalLen < 14){
            resultText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 66);
        }else if (totalLen > 13 && totalLen < 21){
            resultText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 44);
        }else if (totalLen > 20){
            resultText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22);
        }else{
            resultText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 88);
        }

        if(cur.equals("0") && !cur.equals(".")){
            cur = "";
        }
        if(text.equals(".")){
            if(cur.isEmpty()){
                cur = "0";
            }else if(cur.contains(".")){
                cur +=".";
            }
        }else{
            cur +=text;
        }

//        current += b.getText().toString();
        resultText.setText(calculation.concat(cur));
    }

    public void mathOperation(View v){
        Button b = (Button) v;
        if(!cur.isEmpty()){
        num1 = Double.parseDouble(cur);
        }
        operation = b.getText().toString();
        calculation = cur.concat(operation);
        resultText.setText(calculation);
        cur = "";
    }

    public void equalsClick(View view) {
        double num2 = Double.parseDouble(cur);
        double result = 0;
//        resultText.setText(calculation.concat(String.valueOf(num2)));
        switch(operation) {
            case "+": {
                result = num1 + num2;
                break;
            }
            case "-": {
                result = num1 - num2;
                break;
            }
            case "*": {
                result = num1 * num2;
                break;
            }
            case "/": {
                if(num2 ==0){
                    Toast.makeText(this, "Can't devide by zeo", Toast.LENGTH_SHORT).show();
                    cur = "";
                    operation = "";
                    return;
                }
                result = num1 / num2;
                break;
            }
        }

        resultTxt = String.valueOf(result);
        resultText.setText(resultTxt);
        cur = "";
        calculation="";

        if(!resultText.getText().toString().equals("0")){
            subBtn.setEnabled(false);
            sumBtn.setEnabled(false);
            mulBtn.setEnabled(false);
            divBtn.setEnabled(false);
            equalBtn.setEnabled(false);
            Toast.makeText(this, "You have to clear this result for further operation", Toast.LENGTH_LONG).show();
        }
    }

    public void clearClick(View view) {
        subBtn.setEnabled(true);
        sumBtn.setEnabled(true);
        mulBtn.setEnabled(true);
        divBtn.setEnabled(true);
        equalBtn.setEnabled(true);
        cur = "";
        operation = "";
        calculation="";
        num1 = 0;
        totalLen=0;
        resultText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 88);
        resultText.setText("0");
    }

    public void ceClick(View view) {
        subBtn.setEnabled(true);
        sumBtn.setEnabled(true);
        mulBtn.setEnabled(true);
        divBtn.setEnabled(true);
        equalBtn.setEnabled(true);
        cur = "";
        operation = "";
        calculation="";
        num1 = 0;
        totalLen=0;
        resultText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 88);
        resultText.setText("0");
    }

    public void sizeVariation(int totalLen){
        if(totalLen > 7){
            resultText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 66);
        }else if (totalLen > 14){
            resultText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 44);
        }else if (totalLen > 21){
            resultText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22);
        }else{
            resultText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 88);
        }
        resultText.setText(resultTxt);
    }


}