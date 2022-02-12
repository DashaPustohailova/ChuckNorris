package com.example.chucknorris.ui.jokes

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.jokes_item.view.*

class JokesHolder(view: View): RecyclerView.ViewHolder(view) {
    val itemJokes: TextView = view.text_jokes
}