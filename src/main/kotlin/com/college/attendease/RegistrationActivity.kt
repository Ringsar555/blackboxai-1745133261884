package com.college.attendease

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class RegistrationActivity : AppCompatActivity() {

    private lateinit var etFullName: TextInputEditText
    private lateinit var etEmail: TextInputEditText
    private lateinit var etDepartmentClass: TextInputEditText
    private lateinit var etMobileNumber: TextInputEditText
    private lateinit var etRollNumber: TextInputEditText
    private lateinit var btnRegister: Button

    private var portal: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        portal = intent.getStringExtra("portal")

        etFullName = findViewById(R.id.etFullName)
        etEmail = findViewById(R.id.etEmail)
        etDepartmentClass = findViewById(R.id.etDepartmentClass)
        etMobileNumber = findViewById(R.id.etMobileNumber)
        etRollNumber = findViewById(R.id.etRollNumber)
        btnRegister = findViewById(R.id.btnRegister)

        btnRegister.setOnClickListener {
            performRegistration()
        }
    }

    private fun performRegistration() {
        val fullName = etFullName.text.toString().trim()
        val email = etEmail.text.toString().trim()
        val departmentClass = etDepartmentClass.text.toString().trim()
        val mobileNumber = etMobileNumber.text.toString().trim()
        val rollNumber = etRollNumber.text.toString().trim()

        if (fullName.isEmpty() || email.isEmpty() || departmentClass.isEmpty() ||
            mobileNumber.isEmpty() || rollNumber.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            return
        }

        // TODO: Implement actual registration logic with Retrofit API call

        Toast.makeText(this, "Registration successful for $portal", Toast.LENGTH_SHORT).show()
        finish()
    }
}
