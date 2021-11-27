package com.gamecast.movies.home.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gamecast.domain.models.Movie
import com.gamecast.movies.BuildConfig
import com.gamecast.movies.databinding.ItemCardBinding

class HomeCardAdapter: ListAdapter<Movie, MovieCardViewHolder>(DiffCallback<Movie>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieCardViewHolder {
        val binding = ItemCardBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return MovieCardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieCardViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    private class DiffCallback<T>: DiffUtil.ItemCallback<T>() {
        override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
            return oldItem == newItem
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
           return oldItem == newItem
        }
    }

}