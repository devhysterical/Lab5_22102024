package com.example.bai3_11_2

import android.graphics.Color
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener {

    private lateinit var mainLayout: LinearLayout
    private lateinit var gestureDetector: GestureDetector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Tham chiếu đến LinearLayout
        mainLayout = findViewById(R.id.mainLayout)

        // Khởi tạo GestureDetector
        gestureDetector = GestureDetector(this, this)
    }

    // Xử lý sự kiện chạm và vuốt
    override fun onTouchEvent(event: MotionEvent): Boolean {
        return gestureDetector.onTouchEvent(event)
    }

    override fun onDown(e: MotionEvent): Boolean {
        return true
    }

    override fun onSingleTapUp(e: MotionEvent): Boolean {
        // Chạm một lần -> Đổi nền sang màu xanh
        mainLayout.setBackgroundColor(Color.BLUE)
        return true
    }

    override fun onFling(
        p0: MotionEvent?,
        e1: MotionEvent,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        // Kiểm tra hướng vuốt
        val deltaY = p0!!.y - e1.y

        if (deltaY > 0) {
            // Vuốt xuống -> Đổi nền sang màu đỏ
            mainLayout.setBackgroundColor(Color.RED)
        } else {
            // Vuốt lên -> Đổi nền sang màu vàng
            mainLayout.setBackgroundColor(Color.YELLOW)
        }
        return true
    }

    override fun onShowPress(e: MotionEvent) {}

    override fun onLongPress(e: MotionEvent) {}

    override fun onScroll(
        p0: MotionEvent?,
        e1: MotionEvent,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        return false
    }
}
