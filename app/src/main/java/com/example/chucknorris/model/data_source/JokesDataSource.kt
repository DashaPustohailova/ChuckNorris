package com.example.chucknorris.model.data_source

import com.example.chucknorris.model.server_model.JokesResponse

interface JokesDataSource {
    suspend fun getJokesList(count: String): List<JokesResponse.Joke>
}