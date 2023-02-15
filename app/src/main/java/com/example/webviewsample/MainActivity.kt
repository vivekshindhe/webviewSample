package com.example.webviewsample

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.Group

class MainActivity : AppCompatActivity() {

    lateinit var btnWebview: Button
    lateinit var btnWebChromClient : Button
    lateinit var btnBoth: Button
    lateinit var etUrl: EditText
    lateinit var webview: WebView
    lateinit var groupNative: Group
    lateinit var btnReset: Button

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnBoth = findViewById(R.id.btn_both)
        btnWebview = findViewById(R.id.btn_webviewClient)
        btnWebChromClient = findViewById(R.id.btn_webChromeClient)
        etUrl = findViewById(R.id.et_url)
        webview = findViewById(R.id.ele_webview)
        groupNative = findViewById(R.id.group_native)
        btnReset = findViewById(R.id.btn_reset)
        val myWebViewClient = MyWebViewClient(this)
        webview.settings.javaScriptEnabled = true;
        btnWebview.setOnClickListener {
            webview.webViewClient = myWebViewClient
            webview.loadUrl(etUrl.text.toString())
            flipVisibility()

        }

        btnWebChromClient.setOnClickListener {
            webview.webChromeClient = WebChromeClient()
            webview.loadUrl(etUrl.text.toString())
            flipVisibility()

        }

        btnBoth.setOnClickListener {
            webview.webViewClient = myWebViewClient
            webview.webChromeClient = WebChromeClient()
            webview.loadUrl(etUrl.text.toString())
            flipVisibility()

        }

        btnReset.setOnClickListener {
            webview.destroy()
        }

    }

    override fun onBackPressed() {
        flipVisibility()
    }

    private fun flipVisibility(){
        if (groupNative.visibility == View.VISIBLE){
            groupNative.visibility = View.GONE
            webview.visibility = View.VISIBLE
        }else{
            groupNative.visibility = View.VISIBLE
            webview.visibility = View.GONE
        }
    }


}