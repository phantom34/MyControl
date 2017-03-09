package com.example.administrator.mycontrol.webview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.administrator.mycontrol.R;

/**
 * Created by phantom on 2017/3/1.
 */

public class OpenWebActivity extends AppCompatActivity {

    WebView mWebView;
    private String url="https://docs.google.com/gview?embedded=true&url=YOUR_DOC_URL_HERE";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.open_webview);
        init();
    }

    private void init() {
        mWebView = (WebView) findViewById(R.id.wv_open);
        mWebView.setWebViewClient(new AppWebViewClients());
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setUseWideViewPort(true);
        mWebView.loadUrl("http://docs.google.com/gview?embedded=true&url="+url);
    }

    public class AppWebViewClients extends WebViewClient {


        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            super.onPageFinished(view, url);

        }
    }
}
