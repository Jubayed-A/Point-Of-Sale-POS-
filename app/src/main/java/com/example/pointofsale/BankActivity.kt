package com.example.pointofsale

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class BankActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bank)

        // select bank payment method code here
        // bank payment text code here
        val payment = arrayOf(
            "Bank Asia", "Islamic Bank", "Sonali Bank", "Rupali Bank", "Jonota Bank", "Uttora Bank"
        )

        val arrayAdapter = ArrayAdapter(this, R.layout.drop_down_item, payment)
        val bankPaymentList = findViewById<AutoCompleteTextView>(R.id.bankList)
        bankPaymentList.setAdapter(arrayAdapter)

        bankPaymentList.setOnItemClickListener { parent, _, position, _ ->
            val selectedPayment = parent.getItemAtPosition(position).toString()
            Toast.makeText(this, "You Selected $selectedPayment", Toast.LENGTH_SHORT).show()

        }

        // val declaration
        val bankBranch = findViewById<EditText>(R.id.branchName)
        val accountNum = findViewById<EditText>(R.id.accountNum)
        val btnOkay = findViewById<Button>(R.id.btnBuy)

        // defaultValue code here for bankPaymentList
        val defaultValue = "Chose Bank Name"

        // btnOkay button code here
        btnOkay.setOnClickListener {
            val currentText = bankPaymentList.text.toString()
            val branchText = bankBranch.text.toString()
            val accountNumText = accountNum.text.toString()

            if (branchText.isNotEmpty() && accountNumText.isNotEmpty() && currentText != defaultValue) {
                Toast.makeText(this, "this feature will be develop soon", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please fill up all the filed", Toast.LENGTH_SHORT).show()
            }
        }

    }
}