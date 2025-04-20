package com.college.attendease

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class ProfileActivity : AppCompatActivity() {

    private lateinit var ivProfileImage: ImageView
    private lateinit var tvProfileName: TextView
    private lateinit var tvProfileEmail: TextView
    private lateinit var tvProfileDepartment: TextView
    private lateinit var tvProfileMobile: TextView
    private lateinit var tvProfileRollNumber: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        ivProfileImage = findViewById(R.id.ivProfileImage)
        tvProfileName = findViewById(R.id.tvProfileName)
        tvProfileEmail = findViewById(R.id.tvProfileEmail)
        tvProfileDepartment = findViewById(R.id.tvProfileDepartment)
        tvProfileMobile = findViewById(R.id.tvProfileMobile)
        tvProfileRollNumber = findViewById(R.id.tvProfileRollNumber)

        // TODO: Load user data from Room or API

        // Sample data for demonstration
        val sampleUser = User(
            fullName = "John Doe",
            email = "john.doe@example.com",
            departmentClass = "Computer Science",
            mobileNumber = "1234567890",
            rollNumber = "CS2023001",
            profileImageUrl = "https://randomuser.me/api/portraits/men/1.jpg"
        )

        tvProfileName.text = sampleUser.fullName
        tvProfileEmail.text = sampleUser.email
        tvProfileDepartment.text = sampleUser.departmentClass
        tvProfileMobile.text = sampleUser.mobileNumber
        tvProfileRollNumber.text = sampleUser.rollNumber

        Glide.with(this)
            .load(sampleUser.profileImageUrl)
            .circleCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(ivProfileImage)
    }
}

data class User(
    val fullName: String,
    val email: String,
    val departmentClass: String,
    val mobileNumber: String,
    val rollNumber: String,
    val profileImageUrl: String
)
