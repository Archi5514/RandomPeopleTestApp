package com.example.randompeopletestapp.presentation.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.randompeopletestapp.databinding.ItemUserBinding
import com.example.randompeopletestapp.domain.entity.appstate.LocalUser

class UsersListAdapter(
    private val itemClickListener: (LocalUser) -> Unit
) : ListAdapter<LocalUser, UserViewHolder>(UsersDiffUtilItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding.root, binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val item = getItem(position)
        holder.onBind(item)
        holder.itemView.setOnClickListener {
            itemClickListener(item)
        }
    }

    override fun onBindViewHolder(
        holder: UserViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads)
        } else {
            (payloads.last() as? LocalUser)?.let {
                holder.onBind(it)
            }
        }
    }
}