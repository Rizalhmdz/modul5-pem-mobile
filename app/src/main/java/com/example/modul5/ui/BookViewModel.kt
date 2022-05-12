package com.example.modul5.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.modul5.network.Book
import com.example.modul5.network.BookApi
import kotlinx.coroutines.launch
import java.lang.Exception

enum class BookApiStatus{
    LOADING, DONE, ERROR
}

class BookViewModel: ViewModel() {

    private val _status = MutableLiveData<BookApiStatus>()
    val status: LiveData<BookApiStatus> = _status

    private val _books = MutableLiveData<List<Book>>()
    val books: LiveData<List<Book>> = _books

    private val _book = MutableLiveData<Book>()
    val book: LiveData<Book> = _book


    fun getListBook(){
        viewModelScope.launch {
            try {
                _books.value = BookApi.retrofitService.getListBook()
                _status.value = BookApiStatus.DONE
            } catch (e: Exception){
                _books.value = BookApi.retrofitService.getListBook()
                _status.value = BookApiStatus.ERROR
            }
        }

    }

    fun onAmphibianClicked(book: Book) {
        _book.value = book
    }
}