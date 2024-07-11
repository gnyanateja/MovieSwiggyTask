package com.somanchi.findmovies.domain.usecases

import com.somanchi.findmovies.data.model.SearchMoviesResponse
import com.somanchi.findmovies.domain.repository.MovieRepository
import com.somanchi.samplenews.data.util.Resource

class GetSearchMoviesUseCase(
    private val movieRepository: MovieRepository
) {
    suspend fun execute(searchQuery: String, page: Int): Resource<SearchMoviesResponse> {
        return movieRepository.getSearchedMovies(searchQuery, page)
    }
}