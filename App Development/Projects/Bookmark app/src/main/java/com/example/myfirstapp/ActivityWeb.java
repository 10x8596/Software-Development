package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class ActivityWeb extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        WebView myWebView;

        Intent intent = getIntent();
        String url = intent.getStringExtra("URL");

        myWebView = (WebView) findViewById(R.id.my_web);
        myWebView.setWebViewClient(new WebViewClient());

        myWebView.loadUrl(url);
    }
}