package com.ditateum.githubuserapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.ditateum.githubuserapp.R
import com.ditateum.githubuserapp.model.GithubUser

class ListGithubUserAdapater(private val listGithubUser: ArrayList<GithubUser>): RecyclerView.Adapter<ListGithubUserAdapater.ListGithubUserHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    class ListGithubUserHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgAvatar: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvUserName: TextView = itemView.findViewById(R.id.tv_item_username)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: GithubUser)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListGithubUserHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_user, parent, false)
        return ListGithubUserHolder(view)
    }

    override fun onBindViewHolder(holder: ListGithubUserHolder, position: Int) {
        val (name, username, avatar) = listGithubUser[position]

        holder.imgAvatar.setImageResource(avatar)
        holder.tvName.text = name
        holder.tvUserName.text = username
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listGithubUser[holder.adapterPosition])

        }
    }

    override fun getItemCount(): Int = listGithubUser.size
}