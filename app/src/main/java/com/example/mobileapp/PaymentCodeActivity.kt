package com.example.mobileapp

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class PaymentCodeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_code)
        val ccValue = findViewById<EditText>(R.id.cc)
        val verifyCC = findViewById<Button>(R.id.verifyCC)
        val builder = androidx.appcompat.app.AlertDialog.Builder(this)
        builder.setTitle("Alert!")
        verifyCC.setOnClickListener {
            val ccValue1: String = ccValue.text.toString().trim()
            if (ccValue1.isNotEmpty()) {
                val otp = (1000..9999).shuffled().first()
                val codeTransfer = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                val clip = ClipData.newPlainText("CC Card", otp.toString())
                codeTransfer.setPrimaryClip(clip)
                builder.setMessage("OTP Generated and Copied: $otp")
                Toast.makeText(this, "OTP Generated and Copied: $otp", Toast.LENGTH_LONG).show()
            } else {
                builder.setMessage("Credit Card shouldn't be blank")
                Toast.makeText(this, "Credit Card shouldn't be blank", Toast.LENGTH_LONG).show()
            }
            builder.setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            val dialog = builder.create()
            dialog.show()
        }
    }
}
