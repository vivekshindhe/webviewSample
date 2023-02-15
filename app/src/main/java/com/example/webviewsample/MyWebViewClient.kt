package com.example.webviewsample

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient


class MyWebViewClient(private val activity: Activity): WebViewClient() {

    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)

    }



    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        val url = request!!.url.toString()
        if (!url.startsWith("https")){
            try {
                val i = Intent(Intent.ACTION_VIEW)
                i.setData(Uri.parse(request.url.toString()))
                activity.startActivityForResult(i, 2001)
            } catch (e: ActivityNotFoundException) {

            }
        }
        return true

    }

    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {

    }

}