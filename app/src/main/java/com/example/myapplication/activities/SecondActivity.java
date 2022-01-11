package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.databinding.ActivitySecondBinding;
import com.example.myapplication.utility.Constants;
import com.google.gson.Gson;

public class SecondActivity extends BaseActivity {
    private String _tag = "TAG";
    private ActivitySecondBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Log.d(_tag, "onCreate() in Second class");

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String fname = bundle.getString(Constants.FNAME);

        // TODO (1) getting data from intent
//        String fname = intent.getStringExtra(Constants.FNAME);
//        String lname = intent.getStringExtra(Constants.LNAME);
//        String phoneno = intent.getStringExtra(Constants.PHONENO);



        //TODO (2) getting data from bundle
//        Bundle bundle = intent.getExtras();
//        String fname = bundle.getString(Constants.FNAME);
//        String lname = bundle.getString(Constants.LNAME);
//        String phoneno = bundle.getString(Constants.PHONENO);

        //TODO (3) getting data from Serialized object
//        UserData userData = (UserData) intent.getSerializableExtra(Constants.SERIALIZEDDATA);

        //TODO (3) getting data from JSON object
//        String jsonData = intent.getStringExtra(Constants.JSONDATA);
//        UserData userData = new Gson().fromJson(jsonData, UserData.class);

//        binding.tvName.setText(userData.getFname()+ " "+ userData.getLname());
//        binding.tvPhooneNo.setText(userData.getPhoneno());




    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(_tag, "onStart() in Second class");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(_tag, "onResume() in Second class");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(_tag, "onPause() in Second class");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(_tag, "onStop() in Second class");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(_tag, "onRestart() in Second class");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(_tag, "onDestroy() in Second class");
    }
}