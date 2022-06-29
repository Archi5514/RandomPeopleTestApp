package com.example.randompeopletestapp.presentation.main.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.randompeopletestapp.data.image.loadImage
import com.example.randompeopletestapp.databinding.ItemUserBinding
import com.example.randompeopletestapp.domain.entity.appstate.LocalUser

class UserViewHolder(
    itemView: View,
    private val binding: ItemUserBinding
) : RecyclerView.ViewHolder(itemView) {

    fun onBind(item: LocalUser) {
        binding.run {
            loadImage(item.thumbnailPic, image)
            title.text = item.title
            first.text = item.first
            last.text = item.last
        }

    }

}