package com.example.pointofsale

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemName = findViewById<EditText>(R.id.itemName)
        val itemQty = findViewById<EditText>(R.id.itemQty)
        val itemPrice = findViewById<EditText>(R.id.itemPrice)
        val itemAdd = findViewById<Button>(R.id.btnAdd)
        val itemConfirm = findViewById<Button>(R.id.btnConfirm)

        // val array declare to add item
        val itemList = mutableListOf<String>()
        val itemQtyArray = mutableListOf<String>()
        val itemPriceArray = mutableListOf<String>()
        val itemTotalPrice = mutableListOf<String>()


        // btn add code here
        itemAdd.setOnClickListener {

            // to convert string and float
            val name = itemName.text.toString()
            val qty = itemQty.text.toString().toFloatOrNull()
            val price = itemPrice.text.toString().toFloatOrNull()

            if (name.isNotEmpty() && qty !== null && price !== null) {

                itemList.add("Item name is : $name")
                itemQtyArray.add("Item Qty is : $qty")
                itemPriceArray.add("Item Price is : $price")
                val total = qty * price
                itemTotalPrice.add("Item Total Price : $total")

                // show toast that item added
                Toast.makeText(this, "Item added: $name", Toast.LENGTH_SHORT).show()

                // Clear input fields after adding the item
                itemName.text.clear()
                itemQty.text.clear()
                itemPrice.text.clear()
                itemName.requestFocus()

            } else {
                Toast.makeText(this, "Please input all the filled", Toast.LENGTH_SHORT).show()
            }
        }


        // btn confirm code here
        itemConfirm.setOnClickListener {

            if (itemList.isNotEmpty() && itemQtyArray.isNotEmpty() && itemPriceArray.isNotEmpty()
                && itemTotalPrice.isNotEmpty()
            ) {


                // for sum calculate of all item
                var sum = 0.0
                for (priceString in itemTotalPrice) {
                    val priceSum = priceString.substringAfter(":").trim().toDoubleOrNull()
                    if (priceSum != null) {
                        sum += priceSum
                    }
                }

                val intentOutput = Intent(this, OutputActivity::class.java)
                intentOutput.putStringArrayListExtra("itemList", ArrayList(itemList))
                intentOutput.putStringArrayListExtra("itemQty", ArrayList(itemQtyArray))
                intentOutput.putStringArrayListExtra("itemPrice", ArrayList(itemPriceArray))
                intentOutput.putStringArrayListExtra("itemTotalPrice", ArrayList(itemTotalPrice))
                intentOutput.putExtra("sum", sum)
                startActivity(intentOutput)
            } else {
                Toast.makeText(this, "Please Input all the fill.", Toast.LENGTH_SHORT).show()
            }

        }

    }
}


