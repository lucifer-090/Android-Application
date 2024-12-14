package com.example.myapplication.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class RecycleViewAdapter(
    val context: Context,
    val imageList: ArrayList<Int>,
    val nameList: ArrayList<String>,
    val descList: ArrayList<String>,
    ) : RecyclerView.Adapter<RecycleViewAdapter.RecycleViewHolder>(){

    class RecycleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val image : ImageView=itemView.findViewById(R.id.beautifulView)
        val title : TextView=itemView.findViewById(R.id.beautyTitle)
        val desc : TextView=itemView.findViewById(R.id.beautyBody)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewHolder {

        val view : View = LayoutInflater.from(context).inflate(R.layout.sample_rsv,parent,false)
        return  RecycleViewHolder(view)
    }

    override fun getItemCount(): Int {

        return 3
    }

    override fun onBindViewHolder(holder: RecycleViewHolder, position: Int) {

        holder.title.text = nameList[position]
        holder.desc.text = descList[position]
        holder.image.setImageResource(imageList[position])
    }
}