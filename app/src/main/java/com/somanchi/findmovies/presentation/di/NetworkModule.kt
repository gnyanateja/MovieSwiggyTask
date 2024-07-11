package com.somanchi.findmovies.presentation.di

import com.somanchi.findmovies.BuildConfig
import com.somanchi.findmovies.data.api.MovieAPIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        val logging = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        } else {
            logging.setLevel(HttpLoggingInterceptor.Level.NONE)
        }
        val oktHttpClient = OkHttpClient.Builder()
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(5, TimeUnit.SECONDS)
            .connectionPool(ConnectionPool(3, 10, TimeUnit.MINUTES))
            .protocols(listOf(Protocol.HTTP_1_1))
        if(BuildConfig.DEBUG) {
            // Adding NetworkConnectionInterceptor with okHttpClientBuilder.
            oktHttpClient.addInterceptor(logging)
        }
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(oktHttpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieAPIService(retrofit: Retrofit):MovieAPIService{
        return retrofit.create(MovieAPIService::class.java)
    }

}