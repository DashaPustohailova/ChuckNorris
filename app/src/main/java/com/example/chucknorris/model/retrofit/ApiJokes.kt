package com.example.chucknorris.model.retrofit

import com.example.chucknorris.model.server_model.JokesResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiJokes {
    @GET("random/{count}")
//    suspend fun getRandomJokes(): JokesResponse
    suspend fun getRandomJokes(@Path("count") count:String): JokesResponse
}