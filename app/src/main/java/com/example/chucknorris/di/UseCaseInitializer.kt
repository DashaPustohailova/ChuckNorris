package com.example.chucknorris.di

import com.example.chucknorris.model.use_case.GetJokesUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory<GetJokesUseCase> {
        GetJokesUseCase(get())
    }
}