package com.somanchi.findmovies.data.model

data class SearchMoviesResponse(
    val Response: String,
    val Search: List<Search>,
    val totalResults: String
)