package com.tutorial.courser.model.courses

import retrofit2.http.GET
import retrofit2.http.Query

interface CoursesApiService {
    @GET("courses")
    suspend fun getCourses(): List<CoursesItem>

    @GET("courses/featured")
    suspend fun getFeatured(): List<CoursesItem>

    @GET("courses/search")
    suspend fun getSearched(@Query("keyword") keyword: String): List<CoursesItem>
}