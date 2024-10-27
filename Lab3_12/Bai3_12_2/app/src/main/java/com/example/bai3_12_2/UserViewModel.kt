package com.example.bai3_12_2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserViewModel : ViewModel() {
    private val api = ApiClient.apiService

    // Hàm để lấy danh sách người dùng
    fun fetchUsers(onResult: (List<User>) -> Unit) {
        viewModelScope.launch {
            val users = api.getUsers()
            onResult(users)
        }
    }

    // Hàm để thêm người dùng mới
    fun addUser(user: User, onResult: (User) -> Unit) {
        viewModelScope.launch {
            val newUser = api.addUser(user)
            onResult(newUser)
        }
    }
}