package com.training.pagingcompose.di

import com.training.pagingcompose.data.network.MovieApi
import com.training.pagingcompose.data.repository.MovieRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { createRepository(get()) }
}

fun createRepository(
    movieApi: MovieApi
) : MovieRepository = MovieRepository(movieApi)