package com.klu.onlinegrocery

import com.klu.onlinegrocery.models.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("/api/auth/register")
    fun registerUser(@Body user: User): Call<User>

    @POST("/api/auth/login")
    fun loginUser(@Body user: User): Call<LoginResponse>
}