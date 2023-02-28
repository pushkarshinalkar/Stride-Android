package com.tutorial.courser.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tutorial.courser.model.courses.CoursesApiService
import com.tutorial.courser.model.courses.CoursesItem
import com.tutorial.courser.model.favourites.Favourites
import com.tutorial.courser.model.favourites.FavouritesApiService
import com.tutorial.courser.model.favourites.FavouritesItem
import com.tutorial.courser.singletons.RetrofitInstance
import kotlinx.coroutines.launch

class FavCourseViewModel: ViewModel() {

    private val _favouritesLiveData = MutableLiveData<List<FavouritesItem>>()
    val coursesLiveData: LiveData<List<FavouritesItem>> = _favouritesLiveData

    private val favouritesApiService = RetrofitInstance.getInstance().create(FavouritesApiService::class.java)

    fun fetchCourses() {
        viewModelScope.launch {
            val courses = favouritesApiService.getFavourites()
            _favouritesLiveData.postValue(courses)
        }
    }

}