package com.example.chucknorris.di


import com.example.chucknorris.ui.jokes.JokesViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

val viewModelModule = module {
    viewModel<JokesViewModel> {
        JokesViewModel(get())
    }
}