package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityWebviewBinding;

public class WebviewActivity extends AppCompatActivity {
    private ActivityWebviewBinding binding;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWebviewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle(getString(R.string.app_name));
        progressDialog.setMessage("Please wait, while loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        binding.webView.loadUrl("https://www.youtube.com/");
        binding.webView.setWebViewClient(new MyWebViewClient());
    }

    public class MyWebViewClient extends WebViewClient{

//        @Override
//        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
////            if ("https://developer.android.com".equals(request.getUrl().getHost())){
////                return false;
////            }else {
////                Intent intent = new Intent(Intent.ACTION_VIEW, request.getUrl());
////                startActivity(intent);
////            }
//            return true;
//        }


        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
//            if (binding.progressBar.isShown()) binding.progressBar.setVisibility(View.GONE);
            if (progressDialog.isShowing()) progressDialog.hide();
        }
    }
}