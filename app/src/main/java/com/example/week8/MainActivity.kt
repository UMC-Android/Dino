package com.example.week8

// MainActivity.kt
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MemoAdapter
    private lateinit var memoDao: Mem`oDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MemoAdapter()
        recyclerView.adapter = adapter

        // Initialize RoomDB database and get DAO instance
        val database = Room.databaseBuilder(applicationContext, MemoDatabase::class.java, "memo-db").build()
        memoDao = database.memoDao()

        loadMemos()

        // Handle user action to add a new memo
        // Implement your logic to open a new activity/fragment for creating a memo and save it to the database
        // Update the RecyclerView adapter with the new memo data

        // Handle user action to edit/delete a memo
        // Implement your logic to open an activity/fragment for editing/deleting a memo
        // Update the RecyclerView adapter with the modified memo data
    }

    private fun loadMemos() {
        val memos = memoDao.getAllMemos()

        // Update the RecyclerView adapter with the memo data
        adapter.submitList(memos)
    }
}
