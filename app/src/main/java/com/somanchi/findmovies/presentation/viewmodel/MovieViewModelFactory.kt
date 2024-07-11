package com.somanchi.findmovies.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.somanchi.findmovies.domain.usecases.GetMovieDetailsUseCase
import com.somanchi.findmovies.domain.usecases.GetSearchMoviesUseCase

class MovieViewModelFactory(
    private val app: Application,
    private val getSearchMoviesUseCase: GetSearchMoviesUseCase,
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieViewModel(app, getSearchMoviesUseCase, getMovieDetailsUseCase) as T
    }
}