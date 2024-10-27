package com.example.bai3_12_2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class UserAdapter(private val users: List<User>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val avatar: ImageView = itemView.findViewById(R.id.imageViewAvatar)
        val name: TextView = itemView.findViewById(R.id.textViewName)
        val email: TextView = itemView.findViewById(R.id.textViewEmail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        holder.name.text = user.name
        holder.email.text = user.email
        Glide.with(holder.itemView.context)
            .load(user.avatar)
            .into(holder.avatar)
    }

    override fun getItemCount() = users.size
}

