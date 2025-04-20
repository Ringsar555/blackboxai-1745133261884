package com.college.attendease.network

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

data class LoginRequest(val userId: String, val password: String, val portal: String)
data class LoginResponse(val success: Boolean, val message: String, val userId: String?)
data class RegisterRequest(
    val fullName: String,
    val email: String,
    val departmentClass: String,
    val mobileNumber: String,
    val rollNumber: String,
    val portal: String
)
data class RegisterResponse(val success: Boolean, val message: String)

interface ApiService {

    @POST("login")
    fun login(@Body request: LoginRequest): Call<LoginResponse>

    @POST("register")
    fun register(@Body request: RegisterRequest): Call<RegisterResponse>

    @GET("attendance/{userId}")
    fun getAttendance(@Path("userId") userId: String): Call<List<Any>> // Replace Any with actual attendance model

    // Add other API endpoints as needed
}
