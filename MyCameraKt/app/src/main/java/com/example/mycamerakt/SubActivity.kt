package com.example.mycamerakt

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.webkit.WebView
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.mycamerakt.databinding.ActivitySubBinding
import java.net.URLEncoder

class SubActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySubBinding

    //private val webView: WebView by lazy { findViewById<WebView>(R.id.webview) }
    private val localhost ="192.168.x.xxx:8000" //ifconfig
    private val http ="http://"
    private val path ="/index.html"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.returnButton.setOnClickListener{
            finish()
        }

        webViewing()
    }

    private fun webViewing() {
        // when browse server by wifi (localhost=192.168.x.xxx:xxxx)
        // php -S http://localhost:xxxx/index.html

        val stringUrl = StringBuilder()
        stringUrl.append(http).append(localhost).append(path)

        val webView: WebView = findViewById(R.id.webview)
        webView.settings.javaScriptEnabled=true

        //browse server by wifi
        //webView.loadUrl(stringUrl.toString())
        //browse ~/assets/HTML
        webView.loadUrl("file:///android_asset/index.html")
    }
}