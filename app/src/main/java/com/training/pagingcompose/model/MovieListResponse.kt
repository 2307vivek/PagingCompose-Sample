package com.training.pagingcompose.model

import com.google.gson.annotations.SerializedName

data class MovieListResponse(
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("total_results") val totalResults: Int,
    @SerializedName("results") val results: List<Movie>,
    @SerializedName("page") val page: Int
)