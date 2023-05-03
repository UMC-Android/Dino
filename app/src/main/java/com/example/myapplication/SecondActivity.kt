package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    private lateinit var button1: Button
    private lateinit var button2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)

        button1.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, Fragment1())
                .commit()
        }

        button2.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, Fragment2())
                .commit()
        }
    }
}
