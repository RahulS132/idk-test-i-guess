package com.example.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RVAdapter(private var dataList: List<Item> = listOf()) : RecyclerView.Adapter<ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view =
            LayoutInflater.from(parent.context) .inflate(R.layout.listviewholder, parent,  false)
        return ListViewHolder(view)
    }
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(dataList[position])
    }
    override fun getItemCount() = dataList.size
    fun updateData(newDataList: List<Item>) {
        dataList = newDataList
        notifyDataSetChanged()
    }
}
