package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.databinding.ActivityParcebleDataShowingBinding;
import com.example.myapplication.model.UserDataParceble;
import com.example.myapplication.utility.Constants;

public class ParcebleDataShowingActivity extends AppCompatActivity {
    private ActivityParcebleDataShowingBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityParcebleDataShowingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        UserDataParceble dataParceble = getIntent().getParcelableExtra(Constants.PARCEBLEDATAKEY);
////        binding.tvName.setText(dataParceble.getfName()+" "+dataParceble.getlName());
////        binding.tvPhooneNo.setText(dataParceble.getPhoneNo());
//        Intent intent = new Intent(ParcebleDataShowingActivity.this,
//                ThirdPageActivity.class);
//        intent.putExtra(Constants.PARCEBLEDATAKEY, dataParceble);
//        startActivity(intent);

        binding.btnThirdPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserDataParceble dataParceble = getIntent().getParcelableExtra(Constants.PARCEBLEDATAKEY);
                Intent intent = new Intent(ParcebleDataShowingActivity.this,
                        ThirdPageActivity.class);
                intent.putExtra(Constants.PARCEBLEDATAKEY, dataParceble);
                startActivity(intent);
            }
        });
    }
}