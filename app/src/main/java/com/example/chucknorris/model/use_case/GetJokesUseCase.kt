package com.example.chucknorris.model.use_case

import android.util.Log
import com.example.chucknorris.model.data_source.JokesDataSource
import com.example.chucknorris.model.server_model.JokesResponse.Joke
import java.lang.Exception

class GetJokesUseCase(
    private val datasource: JokesDataSource
) {
    suspend fun updateJokesList(count: String): List<Joke>? {
        var jokesList: List<Joke>?
        try{
            jokesList = datasource.getJokesList(count = count)
        }
        catch (e: Exception){
            jokesList = emptyList()
        }
        return jokesList
    }
}