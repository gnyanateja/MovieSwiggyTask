package com.somanchi.findmovies.domain.repository

import com.somanchi.samplenews.data.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

abstract class BaseRepository() {
 
    // we'll use this function in all 
    // repos to handle api errors.
    suspend fun <T> safeApiCall(apiToBeCalled: suspend () -> Response<T>): Resource<T> {
 
        // Returning api response 
        // wrapped in Resource class
        return withContext(Dispatchers.IO) {
            try {
               
                // Here we are calling api lambda 
                // function that will return response
                // wrapped in Retrofit's Response class
                val response: Response<T> = apiToBeCalled()
                 
                if (response.isSuccessful) {
                    // In case of success response we 
                    // are returning Resource.Success object
                    // by passing our data in it.
                    Resource.Success(data = response.body()!!)
                } else {
                    Resource.Error(errorMessage = response.message() ?: "Something went wrong")
                }
            } catch (e: Exception) {
                Resource.Error(errorMessage = e.message.toString())
            }  
        }
    }

}