package com.somanchi.findmovies.data.api

import com.somanchi.findmovies.BuildConfig
import com.somanchi.findmovies.data.model.MovieDetailResponse
import com.somanchi.findmovies.data.model.SearchMoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPIService {

    @GET("/")
    suspend fun getSearchedMovies(
        @Query("s") searchQuery: String,
        @Query("page") page: Int,
        @Query("apikey") apiKey: String = BuildConfig.API_KEY
    ) : Response<SearchMoviesResponse>

    @GET("/")
    suspend fun getMovieDetails(
        @Query("i") imdbId: String,
        @Query("apikey") apiKey: String = BuildConfig.API_KEY
    ) : Response<MovieDetailResponse>

}