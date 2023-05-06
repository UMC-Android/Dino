package com.example.week4

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MemoActivity : AppCompatActivity() {
    private lateinit var memoEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        memoEditText = findViewById(R.id.edit_memo)
        val nextButton: Button = findViewById(R.id.btn_confirm)
        nextButton.setOnClickListener {
            val memo = memoEditText.text.toString()
            val intent = Intent(this, ConfirmActivity::class.java)
            intent.putExtra("memo", memo)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        val memo = MemoData.memo
        if (memo.isNotEmpty()) {
            memoEditText.setText(memo)
        }
    }

    override fun onPause() {
        super.onPause()
        MemoData.memo = memoEditText.text.toString()
    }

    override fun onRestart() {
        super.onRestart()
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Do you want to start over?")
        builder.setPositiveButton("Yes") { _, _ ->
            MemoData.memo = ""
            memoEditText.text = null
        }
        builder.setNegativeButton("No", null)
        builder.show()
    }
}

