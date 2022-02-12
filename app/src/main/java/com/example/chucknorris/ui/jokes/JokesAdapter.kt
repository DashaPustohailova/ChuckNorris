package com.example.chucknorris.ui.jokes

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chucknorris.R
import com.example.chucknorris.model.server_model.JokesResponse

class JokesAdapter: RecyclerView.Adapter<JokesHolder>() {

    private var mListJokes = emptyList<JokesResponse.Joke>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokesHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.jokes_item, parent, false)
        Log.d("TEST", "onCreateViewHolder")
        return JokesHolder(view)
    }

    override fun onBindViewHolder(holder: JokesHolder, position: Int) {
        holder.itemJokes.text = mListJokes[position]?.joke
        Log.d("TEST", "viewModel ${mListJokes?.get(0).joke}")
    }

    override fun getItemCount() = mListJokes.size

    fun setList(list: List<JokesResponse.Joke>?) {
        mListJokes = list?: emptyList()
        notifyDataSetChanged()
    }
}