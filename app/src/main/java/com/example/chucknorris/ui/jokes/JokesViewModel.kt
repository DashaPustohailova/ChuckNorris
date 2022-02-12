package com.example.chucknorris.ui.jokes

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chucknorris.model.server_model.JokesResponse.Joke
import com.example.chucknorris.model.use_case.GetJokesUseCase
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

class JokesViewModel(
    private val getJokesUseCase: GetJokesUseCase
): ViewModel(), KoinComponent {

    private val _currencyList = MutableLiveData<List<Joke>>()
    var currencyList: LiveData<List<Joke>> = _currencyList
    var count = "0"

    fun getCurrency(count: String) {
        viewModelScope.launch  {
            _currencyList.postValue(getJokesUseCase.updateJokesList(count = count))
        }
    }

}
