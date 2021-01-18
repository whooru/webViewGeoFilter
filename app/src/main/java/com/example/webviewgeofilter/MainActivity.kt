package com.example.webviewgeofilter

import android.os.Bundle
import android.util.Log
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //воспользовался Api сайта https://ipapi.co/, для определения страны пользователя
        //проверил через vpn, вроде все определяет правильно

        val service = Common().retrofitServices
        var country: String?

        // не выносил код из Main, потому что его мало

        service.getCountry().enqueue(object : Callback<Country> {
            override fun onResponse(call: Call<Country>, response: Response<Country>) {
                val countryName = response.body() as Country
                country = countryName.countryName
                Log.d("USER_IP", "User country: $country")
                val webSettings = webView.settings
                webSettings.javaScriptEnabled = true
                webSettings.builtInZoomControls = true
                webView.webViewClient = WebViewClient()
                webView.webChromeClient = WebChromeClient()
                if (country.equals("Russia")) {
                    webView.loadUrl("http://yandex.ru")
                } else {
                    webView.loadUrl("http://google.com")
                }
            }

            override fun onFailure(call: Call<Country>, t: Throwable) {
                Log.d("USER_IP", "$t")
            }
        })
    }

    //Кнопка назад работает в вебвью, как кнопка назад, а не выход из приложения
    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed()
        }
    }
}