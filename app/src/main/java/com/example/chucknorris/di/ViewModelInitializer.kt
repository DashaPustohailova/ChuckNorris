package com.example.chucknorris.di


import com.example.chucknorris.ui.jokes.JokesViewModel
import com.example.chucknorris.ui.web.WebViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

val viewModelModule = module {
    viewModel<WebViewModel> {
        WebViewModel()
    }

    viewModel<JokesViewModel> {
        JokesViewModel(get())
    }
}