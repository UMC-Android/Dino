package com.example.week5

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class EditMemoActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_memo)

        val saveButton = findViewById<Button>(R.id.saveButton)
        val memoEditText = findViewById<EditText>(R.id.memoEditText)

        saveButton.setOnClickListener {
            val memo = memoEditText.text.toString()
            if (!memo.isNullOrEmpty()) {
                val intent = Intent()
                intent.putExtra("memo", memo)
                setResult(Activity.RESULT_OK, intent)
            } else {
                setResult(Activity.RESULT_CANCELED)
            }
            finish()
        }
    }
}
