package com.example.week8

// MemoDao.kt
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MemoDao {

    @Query("SELECT * FROM memo")
    fun getAllMemos(): List<Memo>

    @Insert
    fun insert(memo: Memo)

    @Delete
    fun delete(memo: Memo)
}
