package com.example.chucknorris.di

import com.example.chucknorris.model.data_source.ApiJokesDataSource
import com.example.chucknorris.model.data_source.JokesDataSource
import com.example.chucknorris.model.retrofit.ApiJokes
import com.example.chucknorris.model.retrofit.CommonRetrofit
import org.koin.dsl.module

val retrofitModule = module {
    single<ApiJokes> {
        CommonRetrofit.apiJokes
    }

    factory<JokesDataSource> {
        ApiJokesDataSource(get())
    }
}