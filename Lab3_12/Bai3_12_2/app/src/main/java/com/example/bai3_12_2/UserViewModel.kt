package com.example.bai3_12_2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {
    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> get() = _users
    init {
        loadUsers()
    }
    private fun loadUsers() {
        viewModelScope.launch {
            try {
                val userList = ApiClient.apiService.getUsers()
                _users.value = userList
            } catch (e: Exception) {
                // Xử lý lỗi nếu cần
            }
        }
    }
}