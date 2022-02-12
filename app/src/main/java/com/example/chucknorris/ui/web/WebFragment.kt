package com.example.chucknorris.ui.web

import android.content.Context
import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.example.chucknorris.R
import kotlinx.android.synthetic.main.fragment_jokes.*
import kotlinx.android.synthetic.main.web_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class WebFragment : Fragment(R.layout.web_fragment) {
    private val viewModel by viewModel<WebViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupWeb()
        setupCliclListener()
    }

    private fun setupCliclListener() {
    }

    private fun setupWeb() {
        web.apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
            loadUrl("https://www.icndb.com/api/")
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
}