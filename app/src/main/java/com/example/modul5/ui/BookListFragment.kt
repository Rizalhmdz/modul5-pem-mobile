package com.example.modul5.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.modul5.R
import com.example.modul5.databinding.FragmentBookListBinding

class BookListFragment : Fragment() {
    private val viewModel: BookViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentBookListBinding.inflate(inflater)
        viewModel.getListBook()
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.adapter = ListBookAdapter(
            BookListener { book ->
                viewModel.onBookClicked(book)
                findNavController()
                    .navigate(R.id.action_bookListFragment_to_bookDetailFragment)
            })

        // Inflate the layout for this fragment
        return binding.root
    }
}