package com.tutorial.courser.model.videos

import retrofit2.http.GET

interface VideosApiService {
    @GET("videos")
    suspend fun getVideos(): List<VideosItem>
}