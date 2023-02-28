package com.tutorial.courser.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tutorial.courser.model.courses.CoursesApiService
import com.tutorial.courser.model.courses.CoursesItem
import com.tutorial.courser.model.users.UsersApiService
import com.tutorial.courser.model.users.UsersItem
import com.tutorial.courser.singletons.RetrofitInstance
import kotlinx.coroutines.launch

class CoursesViewModel : ViewModel() {

    private val _coursesLiveData = MutableLiveData<List<CoursesItem>>()
    val coursesLiveData: LiveData<List<CoursesItem>> = _coursesLiveData

    private val _featuredLiveData = MutableLiveData<List<CoursesItem>>()
    val featuredLiveData: LiveData<List<CoursesItem>> = _featuredLiveData

    private val coursesApiService = RetrofitInstance.getInstance().create(CoursesApiService::class.java)

    fun fetchCourses() {
        viewModelScope.launch {
            val courses = coursesApiService.getCourses()
            _coursesLiveData.postValue(courses)
        }
    }

    fun fetchFeaturedCourses(){
        viewModelScope.launch {
            val featured = coursesApiService.getFeatured()
            _featuredLiveData.postValue(featured)
        }
    }

    fun fetchSearchedCourses(message : String){
        viewModelScope.launch {
            val searched = coursesApiService.getSearched(message)
            _coursesLiveData.postValue(searched)
        }
    }


}

