package com.training.pagingcompose.ui.screen

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.training.pagingcompose.data.repository.MovieRepository
import com.training.pagingcompose.data.repository.paged.MovieSource
import com.training.pagingcompose.model.Movie
import kotlinx.coroutines.flow.Flow

class MainViewModel(
    movieRepository: MovieRepository
) : ViewModel() {

    val movies: Flow<PagingData<Movie>> = Pager(PagingConfig(pageSize = 20)) {
        MovieSource(movieRepository)
    }.flow
}