package com.example.myapplication.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemPhotoBinding

class PhotoAdapter2(
    private val context: Context,
    private val imageList: List<Int>,
    private val nameList: List<String>,
    private val descList: List<String>
) : RecyclerView.Adapter<PhotoAdapter2.PhotoViewHolder>() {

    inner class PhotoViewHolder(val binding: ItemPhotoBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding = ItemPhotoBinding.inflate(LayoutInflater.from(context), parent, false)
        return PhotoViewHolder(binding)
    }

    override fun getItemCount(): Int = imageList.size



    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.binding.imgPhoto.setImageResource(imageList[position])
        holder.binding.txtName.text = nameList[position]
        holder.binding.txtDescription.text = descList[position]
    }
}