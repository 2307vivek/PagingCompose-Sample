package com.training.pagingcompose.data.network

import com.training.pagingcompose.model.MovieListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("3/movie/popular")
    suspend fun getPopularMovies(
        @Query("page") pageNumber: Int
    ): MovieListResponse
}