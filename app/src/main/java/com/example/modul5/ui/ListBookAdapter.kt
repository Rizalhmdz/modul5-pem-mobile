package com.example.modul5.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.modul5.databinding.ItemViewLayoutBinding
import com.example.modul5.network.Book

class ListBookAdapter(val clickListener: BookListener) :
    ListAdapter<Book, ListBookAdapter.BookViewHolder>(DiffCallback) {

    class BookViewHolder(
        var binding: ItemViewLayoutBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(clickListener: BookListener, book: Book) {
            binding.book = book
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Book>() {

        override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
            return oldItem.publishDate == newItem.publishDate && oldItem.description == newItem.description
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
        holder.bind( clickListener, book)
    }
}

class BookListener(val clickListener: (book: Book) -> Unit) {
    fun onClick(book: Book) = clickListener(book)
}