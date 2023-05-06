package com.example.week4

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ConfirmActivity : AppCompatActivity() {
    private lateinit var memoTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.confirm)

        memoTextView = findViewById(R.id.tv_memo)
        val memo = intent.getStringExtra("memo")
        memoTextView.text = memo
    }
}



// edit button click
