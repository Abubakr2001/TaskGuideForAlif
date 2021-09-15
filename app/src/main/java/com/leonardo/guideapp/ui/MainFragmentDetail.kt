package com.leonardo.guideapp.ui

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import com.leonardo.guideapp.R
import com.leonardo.guideapp.data.Guides


class MainFragmentDetail(private val url: String) : Fragment() {

    private lateinit var webView: WebView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_detail, container, false)
    }


    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        webView = view.findViewById<WebView>(R.id.webView)

        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://guidebook.com/$url")
        webView.settings.javaScriptEnabled = true
        webView.settings.safeBrowsingEnabled = true

    }


    companion object {
        fun newInstance(url : String) = MainFragmentDetail(url)
    }
}