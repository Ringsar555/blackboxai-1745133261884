package com.college.attendease

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {

    private lateinit var etUserId: TextInputEditText
    private lateinit var etPassword: TextInputEditText
    private lateinit var btnLogin: Button
    private lateinit var tvRegisterLink: TextView

    private var portal: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        portal = intent.getStringExtra("portal")

        etUserId = findViewById(R.id.etUserId)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tvRegisterLink = findViewById(R.id.tvRegisterLink)

        btnLogin.setOnClickListener {
            performLogin()
        }

        // Show registration link only for Student and Faculty portals
        if (portal == "student" || portal == "faculty") {
            tvRegisterLink.setOnClickListener {
                val intent = Intent(this, RegistrationActivity::class.java)
                intent.putExtra("portal", portal)
                startActivity(intent)
            }
        } else {
            tvRegisterLink.visibility = android.view.View.GONE
        }
    }

    private fun performLogin() {
        val userId = etUserId.text.toString().trim()
        val password = etPassword.text.toString().trim()

        if (userId.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter User ID and Password", Toast.LENGTH_SHORT).show()
            return
        }

        // TODO: Implement actual login logic with Retrofit API call

        Toast.makeText(this, "Login successful for $portal", Toast.LENGTH_SHORT).show()

        val intent = Intent(this, DashboardActivity::class.java)
        intent.putExtra("portal", portal)
        intent.putExtra("userId", userId)
        startActivity(intent)
        finish()
    }
}
