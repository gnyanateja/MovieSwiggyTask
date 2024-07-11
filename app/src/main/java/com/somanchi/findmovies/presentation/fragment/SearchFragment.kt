package com.somanchi.findmovies.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.somanchi.findmovies.R
import com.somanchi.findmovies.data.model.Search
import com.somanchi.findmovies.databinding.FragmentSearchBinding
import com.somanchi.findmovies.presentation.MainActivity
import com.somanchi.findmovies.presentation.adapter.MovieAdapter
import com.somanchi.findmovies.presentation.viewmodel.MovieViewModel
import com.somanchi.samplenews.data.util.Resource


class SearchFragment : Fragment(), MovieAdapter.ItemClickListener {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var viewModel: MovieViewModel
    private var page: Int = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(LayoutInflater.from(container?.context))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        binding.svMovie.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(searchQuery: String?): Boolean {
                searchQuery?.let {
                    if(searchQuery.length>2){
                        viewModel.fetchSearchMovies(searchQuery, page)
                    } else {
                        Toast.makeText(requireContext(), "Please enter at-least 3 chars", Toast.LENGTH_SHORT).show()
                    }
                }
                return false
            }

            override fun onQueryTextChange(searchQuery: String?): Boolean {
                searchQuery?.let {
                    if(searchQuery.length>2){
                        viewModel.fetchSearchMovies(searchQuery, page)
                    } else {
                        Toast.makeText(requireContext(), "Please enter at-least 3 chars", Toast.LENGTH_SHORT).show()
                    }
                }
                return false
            }

        })
        setupObservers()
    }

    private fun setupObservers(){
        viewModel.searchMovies.observeForever { result ->
            when(result) {
                is Resource.Loading -> {

               }
                else -> {
                    val searchListResponse = result.data
                    searchListResponse?.let {
                        val adapter = MovieAdapter(searchListResponse.Search, this)
                        binding.rvMovies.adapter = adapter
                    }
                }
            }
        }
    }

    override fun itemClicked(movieItem: Search) {
        val bundle = Bundle()
//        binding.
//        findNavController().naviga
    }

}