package com.example.pointofsale

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemName = findViewById<EditText>(R.id.itemName)
        val itemQty = findViewById<EditText>(R.id.itemQty)
        val itemPrice = findViewById<EditText>(R.id.itemPrice)
        val itemAdd = findViewById<Button>(R.id.btnAdd)
        val itemConfirm = findViewById<Button>(R.id.btnConfirm)

        itemConfirm.setOnClickListener {
            val name = itemName.text.toString()
            val qty = itemQty.text.toString().toFloatOrNull()
            val price = itemPrice.text.toString().toFloatOrNull()

            if (qty !== null && price !== null){
                val total = qty * price

                val intentOutput = Intent(this, OutputActivity::class.java)
                intentOutput.putExtra("name", name)
                intentOutput.putExtra("qty", qty.toString())
                intentOutput.putExtra("price", price.toString())
                intentOutput.putExtra("total", total.toString())
                startActivity(intentOutput)
            } else{
                Toast.makeText(this, "Please Input all the fill.", Toast.LENGTH_SHORT).show()
            }

        }

    }
}


