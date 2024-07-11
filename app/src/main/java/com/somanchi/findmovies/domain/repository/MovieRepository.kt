package com.somanchi.findmovies.domain.repository

import com.somanchi.findmovies.data.model.MovieDetailResponse
import com.somanchi.findmovies.data.model.SearchMoviesResponse
import com.somanchi.samplenews.data.util.Resource

interface MovieRepository {
    suspend fun getSearchedMovies(searchQuery: String, page: Int): Resource<SearchMoviesResponse>

    suspend fun getMovieDetails(imdbId: String): Resource<MovieDetailResponse>
}