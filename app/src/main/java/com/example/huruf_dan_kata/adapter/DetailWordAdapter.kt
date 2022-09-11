package com.example.huruf_dan_kata.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.huruf_dan_kata.R
import com.example.huruf_dan_kata.data.DataDetailWord

class DetailWordAdapter(private val listDetailWord: ArrayList<DataDetailWord>): RecyclerView.Adapter<DetailWordAdapter.ViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    class ViewHolder(itemDetailWordView: View, listener: onItemClickListener): RecyclerView.ViewHolder(itemDetailWordView){
        val detWord = itemDetailWordView.findViewById<TextView>(R.id.tv_detail_word)

        init {
            itemDetailWordView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_detail_word,parent,false)

        return ViewHolder(view, mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.detWord.text = listDetailWord[position].detWord
    }

    override fun getItemCount(): Int {
        return listDetailWord.size
    }
}