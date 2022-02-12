package com.example.chucknorris.enviroment.extention.toDomain

import com.example.chucknorris.model.server_model.JokesResponse

fun JokesResponse.toDomain() : List<JokesResponse.Joke> {
    val mutablelList = mutableListOf<JokesResponse.Joke>()
    val listValute: List<JokesResponse.Joke> = mutablelList
    value?.forEach {
        mutablelList.add(it)
    }
    return listValute
}

