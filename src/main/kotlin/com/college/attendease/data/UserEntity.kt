package com.college.attendease.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey val userId: String,
    val fullName: String,
    val email: String,
    val departmentClass: String,
    val mobileNumber: String,
    val rollNumber: String,
    val portal: String,
    val profileImageUrl: String?
)
