package com.tutorial.courser.model.whistory

import retrofit2.http.GET

interface WhistoryApiService {
    @GET("history")
    suspend fun getWhistory(): List<WhistoryItem>

}