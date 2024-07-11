package com.somanchi.findmovies.presentation.di

import com.somanchi.findmovies.data.api.MovieAPIService
import com.somanchi.findmovies.data.dataSource.MovieRemoteDataSource
import com.somanchi.findmovies.data.dataSourceImpl.MovieRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(
        movieAPIService: MovieAPIService
    ): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(movieAPIService)
    }
}












