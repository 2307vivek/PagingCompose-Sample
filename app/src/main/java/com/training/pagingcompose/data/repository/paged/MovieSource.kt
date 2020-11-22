package com.training.pagingcompose.data.repository.paged

import androidx.paging.PagingSource
import com.training.pagingcompose.data.repository.MovieRepository
import com.training.pagingcompose.model.Movie

class MovieSource(
    private val movieRepository: MovieRepository
) : PagingSource<Int, Movie>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val nextPage = params.key ?: 1
            val movieListResponse = movieRepository.getPopularMovies(nextPage)

            LoadResult.Page(
                data = movieListResponse.results,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = movieListResponse.page.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}