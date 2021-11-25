package com.gamecast.movies.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gamecast.movies.BuildConfig
import com.gamecast.movies.databinding.ItemCardBinding

class HomeCardAdapter(
    private val dataSet: Array<MovieItem>
) : RecyclerView.Adapter<HomeCardAdapter.MyViewHolder>() {

    class MyViewHolder(private val itemBinding: ItemCardBinding, private val context: Context) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(item: MovieItem) = with(itemBinding) {
            movieItem = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemCardBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        return MyViewHolder(binding, parent.context)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount(): Int = dataSet.size

}

data class MovieItem(
    val image: String,
    val title: String,
    val subtitle: String
)