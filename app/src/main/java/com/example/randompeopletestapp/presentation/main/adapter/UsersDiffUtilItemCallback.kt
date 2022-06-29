package com.example.randompeopletestapp.presentation.main.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.randompeopletestapp.domain.entity.appstate.LocalUser

class UsersDiffUtilItemCallback : DiffUtil.ItemCallback<LocalUser>() {
    override fun areItemsTheSame(oldItem: LocalUser, newItem: LocalUser): Boolean =
        oldItem.uuid == newItem.uuid

    override fun areContentsTheSame(oldItem: LocalUser, newItem: LocalUser): Boolean =
        oldItem == newItem

    override fun getChangePayload(oldItem: LocalUser, newItem: LocalUser): Any? {
        return if (oldItem != newItem) {
            return newItem
        } else {
            null
        }
    }
}