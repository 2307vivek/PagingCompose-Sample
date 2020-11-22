package com.training.pagingcompose.data.repository

import com.training.pagingcompose.data.network.MovieApi

class MovieRepository(
    private val movieApi: MovieApi
) {
    suspend fun getPopularMovies(pageNumber: Int) =
        movieApi.getPopularMovies(pageNumber)
}