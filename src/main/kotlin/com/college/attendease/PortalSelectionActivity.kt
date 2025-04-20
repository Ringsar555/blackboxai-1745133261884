package com.college.attendease

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class PortalSelectionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_portal_selection)

        val btnStudent = findViewById<Button>(R.id.btnStudent)
        val btnFaculty = findViewById<Button>(R.id.btnFaculty)
        val btnAdmin = findViewById<Button>(R.id.btnAdmin)

        btnStudent.setOnClickListener {
            navigateToLogin("student")
        }

        btnFaculty.setOnClickListener {
            navigateToLogin("faculty")
        }

        btnAdmin.setOnClickListener {
            navigateToLogin("admin")
        }
    }

    private fun navigateToLogin(portal: String) {
        val intent = Intent(this, LoginActivity::class.java)
        intent.putExtra("portal", portal)
        startActivity(intent)
    }
}
