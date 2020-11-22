package com.training.pagingcompose.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import com.training.pagingcompose.ui.screen.MainScreen
import com.training.pagingcompose.ui.screen.MainViewModel
import com.training.pagingcompose.ui.theme.PagingComposeTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PagingComposeTheme {
                MainScreen(mainViewModel)
            }
        }
    }
}