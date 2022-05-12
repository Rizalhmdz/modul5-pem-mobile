package com.example.modul5.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.modul5.network.BookApi
import com.example.modul5.network.Items
import kotlinx.coroutines.launch


enum class BookApiStatus {
    LOADING, DONE, ERROR
}

class BookViewModel : ViewModel() {

    private val _status = MutableLiveData<BookApiStatus>()
    val status: LiveData<BookApiStatus> = _status

    private val _books = MutableLiveData<List<Items>>()
    val books: LiveData<List<Items>> = _books

    private val _book = MutableLiveData<Items>()
    val book: LiveData<Items> = _book


    fun getListBook() {
        viewModelScope.launch {
            try {
                _books.value = BookApi.retrofitService.getListBook().items
                _status.value = BookApiStatus.DONE
            } catch (e: Exception) {
                _books.value = listOf()
                Log.e("ErrorMsg", "${e.message}")
                _status.value = BookApiStatus.ERROR
            }
        }

    }

    fun onBookClicked(book: Items) {
        _book.value = book
    }
}