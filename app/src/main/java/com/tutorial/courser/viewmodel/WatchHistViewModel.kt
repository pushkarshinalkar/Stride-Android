package com.tutorial.courser.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tutorial.courser.model.whistory.WhistoryApiService
import com.tutorial.courser.model.whistory.WhistoryItem
import com.tutorial.courser.singletons.RetrofitInstance
import kotlinx.coroutines.launch

class WatchHistViewModel: ViewModel() {

    private val _whistoryLiveData = MutableLiveData<List<WhistoryItem>>()
    val whistoryLiveData: LiveData<List<WhistoryItem>> = _whistoryLiveData

    private val whistoryApiService = RetrofitInstance.getInstance().create(WhistoryApiService::class.java)

    fun fetchWhistory() {
        viewModelScope.launch {
            val whistory = whistoryApiService.getWhistory()
            _whistoryLiveData.postValue(whistory)
        }
    }
}