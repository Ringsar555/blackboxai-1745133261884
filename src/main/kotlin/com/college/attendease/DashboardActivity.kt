package com.college.attendease

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DashboardActivity : AppCompatActivity() {

    private lateinit var tvWelcome: TextView
    private lateinit var tvUserInfo: TextView
    private lateinit var btnViewAttendance: Button
    private lateinit var btnTakeAttendance: Button
    private lateinit var btnApproveUsers: Button
    private lateinit var btnProfile: Button

    private var portal: String? = null
    private var userId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        portal = intent.getStringExtra("portal")
        userId = intent.getStringExtra("userId")

        tvWelcome = findViewById(R.id.tvWelcome)
        tvUserInfo = findViewById(R.id.tvUserInfo)
        btnViewAttendance = findViewById(R.id.btnViewAttendance)
        btnTakeAttendance = findViewById(R.id.btnTakeAttendance)
        btnApproveUsers = findViewById(R.id.btnApproveUsers)
        btnProfile = findViewById(R.id.btnProfile)

        tvWelcome.text = "Welcome, $userId"
        tvUserInfo.text = "Logged in as: $portal"

        // Show/hide buttons based on portal
        when (portal) {
            "student" -> {
                btnViewAttendance.visibility = View.VISIBLE
                btnTakeAttendance.visibility = View.GONE
                btnApproveUsers.visibility = View.GONE
            }
            "faculty" -> {
                btnViewAttendance.visibility = View.GONE
                btnTakeAttendance.visibility = View.VISIBLE
                btnApproveUsers.visibility = View.GONE
            }
            "admin" -> {
                btnViewAttendance.visibility = View.GONE
                btnTakeAttendance.visibility = View.GONE
                btnApproveUsers.visibility = View.VISIBLE
            }
            else -> {
                btnViewAttendance.visibility = View.GONE
                btnTakeAttendance.visibility = View.GONE
                btnApproveUsers.visibility = View.GONE
            }
        }

        btnProfile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra("userId", userId)
            startActivity(intent)
        }
    }
}
