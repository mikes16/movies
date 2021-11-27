package com.gamecast.movies.home.adapter

import androidx.recyclerview.widget.RecyclerView
import com.gamecast.domain.models.Movie
import com.gamecast.movies.databinding.ItemCardBinding

class MovieCardViewHolder(
    private val itemBinding: ItemCardBinding
) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(item: Movie) = with(itemBinding) {
        movieItem = item
    }
}