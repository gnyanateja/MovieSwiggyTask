package com.somanchi.findmovies.presentation.di

import android.app.Application
import com.somanchi.findmovies.domain.usecases.GetMovieDetailsUseCase
import com.somanchi.findmovies.domain.usecases.GetSearchMoviesUseCase
import com.somanchi.findmovies.presentation.viewmodel.MovieViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {
    @Provides
    @Singleton
    fun provideMovieViewModelFactory(
        app: Application,
        getSearchMoviesUseCase: GetSearchMoviesUseCase,
        getMovieDetailsUseCase: GetMovieDetailsUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(app, getSearchMoviesUseCase, getMovieDetailsUseCase)
    }


}








