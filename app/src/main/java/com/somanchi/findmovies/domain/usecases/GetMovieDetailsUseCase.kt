package com.somanchi.findmovies.domain.usecases

import com.somanchi.findmovies.data.model.MovieDetailResponse
import com.somanchi.findmovies.domain.repository.MovieRepository
import com.somanchi.samplenews.data.util.Resource

class GetMovieDetailsUseCase(
    private val movieRepository: MovieRepository
) {
    suspend fun execute(imdbId: String): Resource<MovieDetailResponse> {
        return movieRepository.getMovieDetails(imdbId)
    }
}