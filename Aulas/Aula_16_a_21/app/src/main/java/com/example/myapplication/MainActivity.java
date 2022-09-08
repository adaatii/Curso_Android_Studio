package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView wv1;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        url="https://github.com/adaatii";
        wv1=findViewById(R.id.wv);
        wv1.loadUrl(url);
        wv1.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon){
                super.onPageStarted(view,url,favicon);
                //Código a ser executado no inicio do carregamento da pagina
            }
            public void onPageFinished(WebView view, String url, Bitmap favicon){
                super.onPageFinished(view,url);
                //Código a ser executado no final do carregamento da pagina
            }
        });
    }
}