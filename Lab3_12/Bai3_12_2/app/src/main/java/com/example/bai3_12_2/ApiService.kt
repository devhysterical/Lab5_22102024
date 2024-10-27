package com.example.bai3_12_2

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    // Lấy danh sách người dùng (GET request)
    @GET("users")
    suspend fun getUsers(): List<User>

    // Thêm người dùng mới (POST request)
    @POST("users")
    suspend fun addUser(@Body user: User): User
}
