package com.example.healthandsocial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class healthtips extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthtips);
        WebView wb=findViewById(R.id.wb);
        wb.loadUrl("https://www.who.int/philippines/news/feature-stories/detail/20-health-tips-for-2020");
        WebSettings wda=wb.getSettings();
        wda.setJavaScriptEnabled(true);
        wb.setWebViewClient(new Callback());
        wb.loadUrl("https://www.who.int/philippines/news/feature-stories/detail/20-health-tips-for-2020");
    }
    private class Callback extends WebViewClient {
        @Override
        public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
            return false;
        }
    }
}