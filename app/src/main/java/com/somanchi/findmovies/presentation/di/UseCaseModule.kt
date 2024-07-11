package com.somanchi.findmovies.presentation.di

import com.somanchi.findmovies.domain.repository.MovieRepository
import com.somanchi.findmovies.domain.usecases.GetMovieDetailsUseCase
import com.somanchi.findmovies.domain.usecases.GetSearchMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideGetSearchMoviesUseCase(
        movieRepository: MovieRepository
    ): GetSearchMoviesUseCase {
        return GetSearchMoviesUseCase(movieRepository)
    }

    @Provides
    @Singleton
    fun provideGetMovieDetailsUseCase(
        movieRepository: MovieRepository
    ): GetMovieDetailsUseCase {
        return GetMovieDetailsUseCase(movieRepository)
    }
}