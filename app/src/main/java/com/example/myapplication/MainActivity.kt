package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
    }

    fun sendMessage(view: android.view.View) {
        val message = editText.text.toString()
        val intent = Intent(this, SecondActivity::class.java).apply {
            putExtra("MESSAGE", message)
        }
        startActivity(intent)
    }
}
