package com.example.pointofsale

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class OutputActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_output)

        val name = intent.getStringExtra("name")
        val qty = intent.getStringExtra("qty")
        val price = intent.getStringExtra("price")
        val total = intent.getStringExtra("total")

        val tvName = findViewById<TextView>(R.id.tvName)
        val tvQty = findViewById<TextView>(R.id.tvQty)
        val tvPrice = findViewById<TextView>(R.id.tvPrice)
        val tvDisplay = findViewById<TextView>(R.id.tvDisplay)

        tvName.text = "Item Name is : $name"
        tvQty.text = "Item Qty is : $qty"
        tvPrice.text = "Item price is : $price"
        tvDisplay.text = "Total Price is : $total"







    }
}