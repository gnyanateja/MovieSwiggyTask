package com.somanchi.findmovies.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.somanchi.findmovies.data.model.MovieDetailResponse
import com.somanchi.findmovies.data.model.SearchMoviesResponse
import com.somanchi.findmovies.domain.usecases.GetMovieDetailsUseCase
import com.somanchi.findmovies.domain.usecases.GetSearchMoviesUseCase
import com.somanchi.samplenews.data.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieViewModel(
    private val app: Application,
    private val getSearchMoviesUseCase: GetSearchMoviesUseCase,
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase
    ): AndroidViewModel(app) {

    val searchMovies = MutableLiveData<Resource<SearchMoviesResponse>>()

    fun fetchSearchMovies(searchQuery: String, page: Int) = viewModelScope.launch(Dispatchers.IO) {
        searchMovies.postValue(Resource.Loading())
        try{
            if(searchQuery.length<3){
                searchMovies.postValue(Resource.Error("Please enter at-least 3 chars to search!"))
            } else {
                val apiResult = getSearchMoviesUseCase.execute(searchQuery, page)
                searchMovies.postValue(apiResult)
            }
        } catch (ex: Exception){
            searchMovies.postValue(Resource.Error(ex.message.toString()))
        }
    }

    val movieDetails = MutableLiveData<Resource<MovieDetailResponse>>()

    fun fetchMovieDetails(imdbId: String) = viewModelScope.launch(Dispatchers.IO) {
        movieDetails.postValue(Resource.Loading())
        try{
            val apiResult = getMovieDetailsUseCase.execute(imdbId)
            movieDetails.postValue(apiResult)
        } catch (ex: Exception){
            movieDetails.postValue(Resource.Error(ex.message.toString()))
        }
    }
}