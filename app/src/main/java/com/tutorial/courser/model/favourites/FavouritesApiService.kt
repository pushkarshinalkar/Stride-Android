package com.tutorial.courser.model.favourites

import com.tutorial.courser.model.courses.CoursesItem
import retrofit2.http.GET

interface FavouritesApiService {
    @GET("favourites")
    suspend fun getFavourites(): List<FavouritesItem>
}