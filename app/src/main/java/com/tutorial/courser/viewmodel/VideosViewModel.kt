package com.tutorial.courser.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tutorial.courser.model.courses.CoursesApiService
import com.tutorial.courser.model.courses.CoursesItem
import com.tutorial.courser.model.videos.VideosApiService
import com.tutorial.courser.model.videos.VideosItem
import com.tutorial.courser.singletons.RetrofitInstance
import kotlinx.coroutines.launch

class VideosViewModel: ViewModel() {

    private val _videosLiveData = MutableLiveData<List<VideosItem>>()
    val videosLiveData: LiveData<List<VideosItem>> = _videosLiveData

    private val videosApiService = RetrofitInstance.getInstance().create(VideosApiService::class.java)

    fun fetchVideos() {
        viewModelScope.launch {
            val videos = videosApiService.getVideos()
            _videosLiveData.postValue(videos)
        }
    }
}