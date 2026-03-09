package com.training.roomapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var itemName: EditText
    lateinit var itemPrice: EditText
    lateinit var itemQty: EditText
    lateinit var databaseRecord: TextView
    lateinit var saveBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        databaseRecord = findViewById(R.id.dbRecords)
        saveBtn = findViewById(R.id.saveBtn)
        itemName = findViewById(R.id.name)
        itemPrice = findViewById(R.id.price)
        itemQty = findViewById(R.id.qty)

        val myDB = MyDatabase.getDatabase(this)
        val myDAO = myDB.itemDAO()

        myDAO.getAllItems().observe(this) { itemsList ->
            val displayData = StringBuilder()
            itemsList.forEach {
                displayData.append("${it.name} - $${it.price} (Qty: ${it.quantity})\n")
            }
            databaseRecord.text = displayData.toString()
        }

        saveBtn.setOnClickListener {
            insertItem(myDAO)
            itemName.text.clear()
            itemPrice.text.clear()
            itemQty.text.clear()

        }

    }

    fun insertItem(myDAO: ItemDAO) {


        val name = itemName.text.toString()
        val price = itemPrice.text.toString()
        val qty = itemQty.text.toString()

        val doublePrice = price.toDouble()
        val intQty = qty.toInt()

        val item: Item = Item(0, name, doublePrice, intQty)

        CoroutineScope(Dispatchers.IO).launch {
            myDAO.insertItem(item)
        }
    }
}
