package com.example.bai3_12_2

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val viewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.fetchUsers { users ->
            recyclerView.adapter = UserAdapter(users)
        }

        // Ví dụ: Thêm người dùng mới
        val newUser = User(name = "John Doe", email = "john@example.com", avatar = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQAFAjK_0YbdY6NnrQ6gtG463vBLCytvojCPw&s")
        viewModel.addUser(newUser) { user ->
            println("User added: $user")
        }
    }
}
