package com.example.modul5.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.modul5.databinding.ItemViewLayoutBinding
import com.example.modul5.network.BookItem
import com.example.modul5.network.Items

class ListBookAdapter(
    private val clickListener: BookListener
) :
    ListAdapter<BookItem, ListBookAdapter.BookViewHolder>(DiffCallback) {

    class BookViewHolder(
        var binding: ItemViewLayoutBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            clickListener: BookListener,
            book: BookItem
        ) {
            binding.bookItem = book
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<BookItem>() {

        override fun areItemsTheSame(oldItem: BookItem, newItem: BookItem): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: BookItem, newItem: BookItem): Boolean {
            return oldItem.cover == newItem.cover
                    && oldItem.authors == newItem.authors
                    && oldItem.publisher == newItem.publisher
                    && oldItem.publishedDate == newItem.publishedDate
                    && oldItem.description == newItem.description
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

class BookListener(val clickListener: (book: BookItem) -> Unit) {
    fun onClick(book: BookItem) = clickListener(book)
}