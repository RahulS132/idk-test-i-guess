package com.example.myapp1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val email = findViewById<EditText>(R.id.emailInput)
        val password = findViewById<EditText>(R.id.passwordInput)
        val loginButton = findViewById<Button>(R.id.loginButton)
        val status = findViewById<TextView>(R.id.statusText)
        val button100 = findViewById<Button>(R.id.button100)

        Log.d("Rahul", "App started")

        // 🔹 Login button logic
        loginButton.setOnClickListener {
            val emailText = email.text.toString()
            val passText = password.text.toString()

            if (emailText.isEmpty() || passText.isEmpty()) {
                status.text = "Please fill all fields"
                Log.d("Rahul", "Empty fields")
            } else if (emailText == "test@test.com" && passText == "1234") {
                status.text = "Login successful ✅"
                Log.d("Rahul", "Login success")
            } else {
                status.text = "Invalid credentials ❌"
                Log.d("Rahul", "Login failed")
            }
        }

        // 🔹 button100 navigation
        button100.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}