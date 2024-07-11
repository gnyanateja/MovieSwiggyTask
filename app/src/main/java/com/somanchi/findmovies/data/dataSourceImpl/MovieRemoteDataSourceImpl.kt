package com.somanchi.findmovies.data.dataSourceImpl

import com.somanchi.findmovies.data.api.MovieAPIService
import com.somanchi.findmovies.data.dataSource.MovieRemoteDataSource
import com.somanchi.findmovies.data.model.MovieDetailResponse
import com.somanchi.findmovies.data.model.SearchMoviesResponse
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val apiService: MovieAPIService
): MovieRemoteDataSource {
    override suspend fun getSearchedMovies(searchQuery: String, page: Int): Response<SearchMoviesResponse> {
        return apiService.getSearchedMovies(searchQuery, page)
    }

    override suspend fun getMovieDetails(imdbId: String): Response<MovieDetailResponse> {
        return apiService.getMovieDetails(imdbId)
    }
}