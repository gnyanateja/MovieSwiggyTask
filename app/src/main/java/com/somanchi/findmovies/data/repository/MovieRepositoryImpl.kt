package com.somanchi.findmovies.data.repository

import com.somanchi.findmovies.data.dataSource.MovieRemoteDataSource
import com.somanchi.findmovies.data.model.MovieDetailResponse
import com.somanchi.findmovies.data.model.SearchMoviesResponse
import com.somanchi.findmovies.domain.repository.BaseRepository
import com.somanchi.findmovies.domain.repository.MovieRepository
import com.somanchi.samplenews.data.util.Resource

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource
): MovieRepository, BaseRepository() {
    override suspend fun getSearchedMovies(
        searchQuery: String,
        page: Int
    ): Resource<SearchMoviesResponse> {
        return safeApiCall { movieRemoteDataSource.getSearchedMovies(searchQuery, page) }
    }

    override suspend fun getMovieDetails(imdbId: String): Resource<MovieDetailResponse> {
        return safeApiCall { movieRemoteDataSource.getMovieDetails(imdbId) }
    }

}