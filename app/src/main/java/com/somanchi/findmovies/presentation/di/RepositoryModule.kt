package com.somanchi.findmovies.presentation.di

import com.somanchi.findmovies.data.dataSource.MovieRemoteDataSource
import com.somanchi.findmovies.data.repository.MovieRepositoryImpl
import com.somanchi.findmovies.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(movieRemoteDataSource)
    }

}














