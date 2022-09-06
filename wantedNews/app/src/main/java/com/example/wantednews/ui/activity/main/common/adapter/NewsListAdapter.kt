package com.example.wantednews.ui.activity.main.common.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wantednews.data.TopHeadlinesData
import com.example.wantednews.databinding.ViewTopNewsListItemBinding

class NewsListAdapter(private val newsList: ArrayList<TopHeadlinesData.Article>?, private val onClickListener: OnClickListener) : RecyclerView.Adapter<NewsListAdapter.ViewHolder>() {

    interface OnClickListener {
        fun onItemClickListener(article: TopHeadlinesData.Article)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(ViewTopNewsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount() = newsList?.size ?: 0

    inner class ViewHolder(private val binding: ViewTopNewsListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            newsList!![adapterPosition].run {
                Glide.with(itemView.context)
                    .load(urlToImage)
                    .centerCrop()
                    .into(binding.imgBanner)

                binding.txtTitle.text = title
                binding.txtWriter.text = author
                binding.txtDate.text = publishedAt

                itemView.setOnClickListener { onClickListener.onItemClickListener(this) }
            }
        }
    }
}