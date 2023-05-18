package com.example.week7

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var tvTimer: TextView
    private val timerDuration: Long = 30 * 1000 // 타이머 지속 시간 (30초)

    private val handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            val elapsedTime = System.currentTimeMillis() - startTime
            val remainingTime = timerDuration - elapsedTime

            if (remainingTime > 0) {
                // 남은 시간을 TextView에 업데이트
                val seconds = (remainingTime / 1000).toInt()
                tvTimer.text = "남은 시간: $seconds 초"
                sendEmptyMessageDelayed(0, 1000) // 1초마다 업데이트
            } else {
                // 타이머 종료 시 처리
                tvTimer.text = "타이머 종료"
            }
        }
    }

    private var startTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvTimer = findViewById(R.id.tvTimer)
        startTimer()
    }

    private fun startTimer() {
        startTime = System.currentTimeMillis()
        handler.sendEmptyMessage(0)
    }
}

