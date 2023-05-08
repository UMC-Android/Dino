package com.example.week5

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
//import com.example.week5.MemoAdapter

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
//import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var memoAdapter: MemoAdapter
    private val memoList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        memoAdapter = MemoAdapter(memoList)
        recyclerView.adapter = memoAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val addButton: Button = findViewById(R.id.addButton)
        addButton.setOnClickListener {
            val intent = Intent(this, EditMemoActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE_ADD_MEMO)
        }
    }

    private fun MemoAdapter(memoList: MutableList<String>): MemoAdapter {

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_ADD_MEMO && resultCode == Activity.RESULT_OK) {
            val newMemo = data?.getStringExtra(EXTRA_MEMO) ?: return
            memoList.add(newMemo)
            memoAdapter.notifyDataSetChanged()
        }
    }

    companion object {
        private const val REQUEST_CODE_ADD_MEMO = 100
        const val EXTRA_MEMO = "EXTRA_MEMO"
    }
}

