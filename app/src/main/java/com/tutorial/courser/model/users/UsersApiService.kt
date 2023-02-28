package com.tutorial.courser.model.users

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface UsersApiService {
    @GET("users")
    suspend fun getUsers(): List<UsersItem>

    @POST("login")
    @FormUrlEncoded
    suspend fun login(@Field("u_email") email: String, @Field("u_password") password: String): UsersItem
}

