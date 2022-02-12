package com.example.chucknorris.model.data_source

import com.example.chucknorris.enviroment.extention.toDomain.toDomain
import com.example.chucknorris.model.retrofit.ApiJokes
import com.example.chucknorris.model.server_model.JokesResponse

class ApiJokesDataSource(private val api: ApiJokes): JokesDataSource {
    override suspend fun getJokesList(count: String): List<JokesResponse.Joke> {
        var list: List<JokesResponse.Joke>  = api.getRandomJokes(count).toDomain()
        return list
    }
}