package com.example.modul5.ui

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.modul5.R
import com.example.modul5.network.Items

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Items>?) {
    val adapter = recyclerView.adapter as ListBookAdapter
    adapter.submitList(data)
}

@BindingAdapter("apiStatus")
fun bindStatus(statusImageView: ImageView, status: BookApiStatus?) {
    when (status) {
        BookApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        BookApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
        BookApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
    }
}

@BindingAdapter("setCover")
fun bindCover(cover: ImageView, imgUrl: String) {
    imgUrl.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        cover.load(imgUri) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
        }
    }
}