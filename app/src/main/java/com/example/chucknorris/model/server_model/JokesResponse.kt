package com.example.chucknorris.model.server_model

import com.google.gson.annotations.SerializedName

data class JokesResponse (
    @SerializedName("value")
    val value: List<Joke>?
){
    data class Joke(
        @SerializedName("id")
        val id: String?,
        @SerializedName("joke")
        val joke: String?
    )
}