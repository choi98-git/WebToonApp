package com.example.webtoonapp

import android.graphics.Bitmap
import android.view.View
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar

class WebtoonWebViewClient(
    private val progressBar: ProgressBar,
    private val saveData: (String) -> Unit,
): WebViewClient() {

    // url이 로드될 때 실행 return 값이 false 면 url을 로드 true 로드 x
    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        //
        if (request != null && request.url.toString().contains("comic.naver.com/webtoon/detail")) {
            saveData(request.url.toString())
        }
        //
        return super.shouldOverrideUrlLoading(view, request)
    }

    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)

        progressBar.visibility = View.GONE
    }

    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        super.onPageStarted(view, url, favicon)

        progressBar.visibility = View.VISIBLE
    }

}