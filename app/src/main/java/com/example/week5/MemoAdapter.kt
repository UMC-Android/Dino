package com.example.week5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MemoAdapter(private val memoList: MutableList<String>, private val onClickDelete: (Int) -> Unit) : RecyclerView.Adapter<MemoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_memo, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.memoTextView.text = memoList[position]
        holder.deleteButton.setOnClickListener { onClickDelete(position) }
    }

    override fun getItemCount(): Int {
        return memoList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val memoTextView: TextView = itemView.findViewById(R.id.memo_text_view)
        val deleteButton: ImageButton = itemView.findViewById(R.id.delete_button)
    }
}
