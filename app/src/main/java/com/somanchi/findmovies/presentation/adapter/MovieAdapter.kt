package com.somanchi.findmovies.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.somanchi.findmovies.R
import com.somanchi.findmovies.data.model.Search
import com.somanchi.findmovies.databinding.ItemMovieBinding

class MovieAdapter(
    private val movieList: List<Search>,
    private val listener: ItemClickListener
): RecyclerView.Adapter<MovieAdapter.ItemMovieHolder>() {

    inner class ItemMovieHolder(val binding: ItemMovieBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemMovieHolder {
        return ItemMovieHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_movie,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemMovieHolder, position: Int) {
        val movieItem = movieList[position]
        holder.binding.tvName.text = movieItem.Title
        holder.binding.tvYear.text = movieItem.Year
        Glide.with(holder.itemView.context)
            .load(movieItem.Poster)
            .error(R.drawable.ic_launcher_background)
            .into(holder.binding.ivPoster)

    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    interface ItemClickListener{
        fun itemClicked(movieItem: Search)
    }
}