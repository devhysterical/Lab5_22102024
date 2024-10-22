package com.example.bai3_11_1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.util.Patterns

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emailInput = findViewById<EditText>(R.id.editTextEmail)
        val phoneInput = findViewById<EditText>(R.id.editTextPhone)
        val submitButton = findViewById<Button>(R.id.btnSubmit)

        submitButton.setOnClickListener {
            val email = emailInput.text.toString().trim()
            val phone = phoneInput.text.toString().trim()

            if (isValidEmail(email) && isValidPhone(phone)) {
                Toast.makeText(this, "Email và số điện thoại hợp lệ!", Toast.LENGTH_SHORT).show()
            } else {
                if (!isValidEmail(email)) {
                    Toast.makeText(this, "Email không hợp lệ!", Toast.LENGTH_SHORT).show()
                }
                if (!isValidPhone(phone)) {
                    Toast.makeText(this, "Số điện thoại không hợp lệ!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isValidPhone(phone: String): Boolean {
        return phone.matches("\\d+".toRegex())
    }
}