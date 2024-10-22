package com.example.bai3_12_1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var imageAdapter: ImageAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Danh sách các URL hình ảnh
        val imageUrls = listOf(
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT04yKySqCnobIuS9y3JFv9LduIJv5oR8uiLQ&s",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRqJ4WemU1ywDTfszHfsVtcJKLkScwnG5Cfmg&s",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSfM5LIikrRhNZoCWuBnBJoggWQteovDeYzJA&s",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRLPNQlhV4nImvNHv45MH7gBSxEhJ6cazzY6g&s",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRqpkMcocGIq92ao8uzU33sasX643JsAOhKmQ&s",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTDj4qyzqd18eQ5uaros5zO20rvjy9dQjCj9w&s",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQSNhmEsQ7Maew_rC_fmcI-OFxeTPnrAyfDiA&s",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT6YitWMu8lCwOycghDLnD722g1uhysgAzjKQ&s",
            // Thêm nhiều URL khác
        )
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Cài đặt adapter cho RecyclerView
        imageAdapter = ImageAdapter(imageUrls)
        recyclerView.adapter = imageAdapter
    }
}
