package com.somanchi.findmovies.data.dataSource

import com.somanchi.findmovies.data.model.MovieDetailResponse
import com.somanchi.findmovies.data.model.SearchMoviesResponse
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getSearchedMovies(searchQuery: String, page: Int): Response<SearchMoviesResponse>
    suspend fun getMovieDetails(imdbId: String): Response<MovieDetailResponse>
}