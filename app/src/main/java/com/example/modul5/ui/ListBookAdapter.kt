package com.example.modul5.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.modul5.databinding.ItemViewLayoutBinding
import com.example.modul5.network.Items

class ListBookAdapter(
    private val clickListener: BookListener
) :
    ListAdapter<Items, ListBookAdapter.BookViewHolder>(DiffCallback) {

    class BookViewHolder(
        var binding: ItemViewLayoutBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            clickListener: BookListener,
            book: Items
        ) {
            binding.bookItem = book
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Items>() {

        override fun areItemsTheSame(oldItem: Items, newItem: Items): Boolean {
            return oldItem.bookItems.title == newItem.bookItems.title
        }

        override fun areContentsTheSame(oldItem: Items, newItem: Items): Boolean {
            return oldItem.bookItems.cover == newItem.bookItems.cover
                    && oldItem.bookItems.authors == newItem.bookItems.authors
                    && oldItem.bookItems.publisher == newItem.bookItems.publisher
                    && oldItem.bookItems.publishedDate == newItem.bookItems.publishedDate
                    && oldItem.bookItems.description == newItem.bookItems.description
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return BookViewHolder(
            ItemViewLayoutBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = getItem(position)
        holder.bind(clickListener, book)
    }
}

class BookListener(val clickListener: (book: Items) -> Unit) {
    fun onClick(book: Items) = clickListener(book)
}