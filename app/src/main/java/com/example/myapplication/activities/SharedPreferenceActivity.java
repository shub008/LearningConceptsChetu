package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivitySharedPreferenceBinding;
import com.example.myapplication.utility.Constants;

public class SharedPreferenceActivity extends AppCompatActivity {
    private ActivitySharedPreferenceBinding binding;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySharedPreferenceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        preferences = getSharedPreferences("chetu_training", MODE_PRIVATE);
        editor = preferences.edit();

        String name = preferences.getString(Constants.FNAME, "");

        Log.d("DATA", name);

        binding.btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString(Constants.FNAME, binding.tieName.getEditableText().toString());
                editor.commit();


            }
        });


    }
}