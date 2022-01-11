package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.databinding.ActivityIntentParcebleBinding;
import com.example.myapplication.model.UserDataParceble;
import com.example.myapplication.utility.Constants;

public class IntentParcebleActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityIntentParcebleBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityIntentParcebleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnClick.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(IntentParcebleActivity.this,
                ParcebleDataShowingActivity.class);

        UserDataParceble userDataParceble = new UserDataParceble(binding.etFname.getText().toString(),
                binding.etLname.getText().toString(), binding.etPhoneno.getText().toString());
        intent.putExtra(Constants.PARCEBLEDATAKEY, userDataParceble);

        startActivity(intent);
    }
}