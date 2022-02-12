package com.example.chucknorris.model.retrofit

object CommonRetrofit {
    private val BASE_URL = "http://api.icndb.com/jokes/"
    val apiJokes: ApiJokes
        get() = RetrofitClient.getClient(BASE_URL).create(ApiJokes::class.java)
}