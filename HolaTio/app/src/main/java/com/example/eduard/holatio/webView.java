package com.example.eduard.holatio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class webView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        WebView navegador = (WebView) findViewById(R.id.webView);

        navegador.loadUrl("http://google.es");
    }
}
