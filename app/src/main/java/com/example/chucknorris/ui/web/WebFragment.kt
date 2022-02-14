package com.example.chucknorris.ui.web

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.example.chucknorris.R
import kotlinx.android.synthetic.main.web_fragment.*


class WebFragment : Fragment(R.layout.web_fragment) {
    lateinit var lastUrl: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(savedInstanceState != null) {
            lastUrl = savedInstanceState?.getString("URL", "https://www.icndb.com/api/")
        }
        else
            lastUrl = "https://www.icndb.com/api/"
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupWeb()
    }

    private fun setupWeb() {
        web.apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
            loadUrl(lastUrl)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val callback: OnBackPressedCallback = object : OnBackPressedCallback(
            true
        ) {
            override fun handleOnBackPressed() {
                if(web.canGoBack())
                    web.goBack()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            this,
            callback
        )
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("URL", web.url)
    }

}