package com.training.currencyconvertorapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
//    lateinit var title: TextView
    lateinit var rupeesAmount: EditText
    lateinit var convertorBtn: Button
    lateinit var resultTxt: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

//        title = findViewById(R.id.textView)
        resultTxt = findViewById(R.id.dollarResult)
        rupeesAmount = findViewById(R.id.indRupee)
        convertorBtn = findViewById(R.id.convertorBtn)

        convertorBtn.setOnClickListener {
            var rupees: String = rupeesAmount.text.toString()
            var dollars =convertRupeeIntoDollar(rupees.toDouble())
            resultTxt.text = String.format("%.2f", dollars) + " $"
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    public fun convertRupeeIntoDollar(rupees: Double): Double {
        return rupees / 91.44
    }
}