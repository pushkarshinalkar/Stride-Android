package com.tutorial.courser.viewmodel

import android.util.Log
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
import retrofit2.HttpException

class UsersViewModel : ViewModel() {

    private val _usersLiveData = MutableLiveData<List<UsersItem>>()
    val usersLiveData: LiveData<List<UsersItem>> = _usersLiveData

    private val _loginLiveData = MutableLiveData<UsersItem>()
    val loginLiveData: LiveData<UsersItem> = _loginLiveData

    private val usersApiService = RetrofitInstance.getInstance().create(UsersApiService::class.java)

    fun fetchUsers() {
        viewModelScope.launch {
            val users = usersApiService.getUsers()
            _usersLiveData.postValue(users)
        }
    }

    fun login(email: String, password: String) {
        Log.d("REQUEST", "in login func")
        viewModelScope.launch {
            try {
                Log.d("REQUEST", "in try")
                val user = usersApiService.login(email, password)
                _loginLiveData.postValue(user)
                Log.d("REQUEST", user.u_profile_photo_link)
            } catch (e: Exception) {
                Log.d("REQUEST", e.toString())
                // Log error response from API
                if (e is HttpException) {
                    val responseBody = e.response()?.errorBody()?.string()
                    if (responseBody != null) {
                        Log.d("REQUEST", responseBody)
                    }
                }
                // Handle error
            }
        }
    }
}