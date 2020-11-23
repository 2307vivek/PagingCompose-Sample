/*
 * MIT License
 *
 * Copyright (c) 2020 Vivek Singh
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.training.pagingcompose.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.training.pagingcompose.BuildConfig
import com.training.pagingcompose.R
import com.training.pagingcompose.model.Movie
import com.training.pagingcompose.ui.state.*
import dev.chrisbanes.accompanist.coil.CoilImage
import kotlinx.coroutines.flow.Flow

@Composable
fun MainScreen(mainViewModel: MainViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "PopularMovies") }
            )
        },
        bodyContent = {
            MovieList(movies = mainViewModel.movies)
        }
    )
}

@Composable
fun MovieList(movies: Flow<PagingData<Movie>>) {
    val lazyMovieItems = movies.collectAsLazyPagingItems()

    LazyColumn {

        items(lazyMovieItems) { movie ->
            MovieItem(movie = movie!!)
        }

        lazyMovieItems.apply {
            when {
                loadState.refresh is LoadState.Loading -> {
                    item { LoadingView(modifier = Modifier.fillParentMaxSize()) }
                }
                loadState.append is LoadState.Loading -> {
                    item { LoadingItem() }
                }
                loadState.refresh is LoadState.Error -> {
                    val e = lazyMovieItems.loadState.refresh as LoadState.Error
                    item {
                        ErrorItem(
                            message = e.error.localizedMessage!!,
                            modifier = Modifier.fillParentMaxSize(),
                            onClickRetry = { retry() }
                        )
                    }
                }
                loadState.append is LoadState.Error -> {
                    val e = lazyMovieItems.loadState.append as LoadState.Error
                    item {
                        ErrorItem(
                            message = e.error.localizedMessage!!,
                            onClickRetry = { retry() }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun MovieItem(movie: Movie) {
    Row(
        modifier = Modifier
            .padding(start = 16.dp, top = 16.dp, end = 16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        MovieTitle(
            movie.title!!,
            modifier = Modifier.weight(1f)
        )
        MovieImage(
            BuildConfig.LARGE_IMAGE_URL + movie.backdrop_path,
            modifier = Modifier.padding(start = 16.dp).preferredSize(90.dp)
        )
    }
}

@Composable
fun MovieImage(
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    CoilImage(
        data = imageUrl,
        modifier = modifier,
        fadeIn = true,
        contentScale = ContentScale.Crop,
        loading = {
            Image(vectorResource(id = R.drawable.ic_photo), alpha = 0.45f)
        },
        error = {
            Image(vectorResource(id = R.drawable.ic_broken_image), alpha = 0.45f)
        }
    )
}

@Composable
fun MovieTitle(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = title,
        maxLines = 2,
        style = MaterialTheme.typography.h6,
        overflow = TextOverflow.Ellipsis
    )
}