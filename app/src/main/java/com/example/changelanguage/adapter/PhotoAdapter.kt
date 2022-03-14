package com.example.changelanguage.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.changelanguage.R
import com.example.changelanguage.model.Photo
import kotlinx.android.synthetic.main.item_photo.view.*

class PhotoAdapter(val photoList: List<Photo>) :
    RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {
    inner class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(photo: Photo) {
            itemView.tvId.text = "${photo.id}"
            itemView.tvTitle.text = photo.title
            Glide.with(itemView).load(photo.thumbnailUrl).into(itemView.image)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_photo, parent, false)
        return PhotoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bindData(photoList[position])
    }

    override fun getItemCount(): Int {
        return photoList.size
    }
}