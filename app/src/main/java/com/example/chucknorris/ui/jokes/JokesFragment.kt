package com.example.chucknorris.ui.jokes

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.chucknorris.R
import com.example.chucknorris.enviroment.extention.gone
import com.example.chucknorris.enviroment.extention.observe
import com.example.chucknorris.enviroment.extention.visible
import com.example.chucknorris.model.server_model.JokesResponse
import kotlinx.android.synthetic.main.fragment_jokes.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class JokesFragment : Fragment(R.layout.fragment_jokes) {

    private val viewModel by viewModel<JokesViewModel>()
    private lateinit var mAdapter: JokesAdapter
    private lateinit var mRecyclerView: RecyclerView


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRv()
        setupObservers()
        setupClickListeners()
        reloadJokes()
    }

    private fun reloadJokes() {
        if(!viewModel.currencyList.value.isNullOrEmpty()) {
            backgroundStars.gone()
            recycler_view.visible()
            mAdapter.setList(viewModel.currencyList.value)
        }
        else{
            recycler_view.gone()
            backgroundStars.visible()
            mAdapter.setList(emptyList())
        }
    }

    private fun loadJoke(){
            backgroundStars.gone()
            recycler_view.visible()
            viewModel.getCurrency(countJokes.text.toString())
    }

    private fun setupRv() {
        mAdapter = JokesAdapter()
        mRecyclerView = recycler_view
        mRecyclerView.adapter = mAdapter
    }


    private fun setupObservers() {
        observe(viewModel.currencyList, ::handleCurrency)
    }

    private fun handleCurrency(list: List<JokesResponse.Joke>?) {
        mAdapter.setList(list)
    }

    private fun setupClickListeners(){
        reloadButton.setOnClickListener {
            loadJoke()
        }
    }

}