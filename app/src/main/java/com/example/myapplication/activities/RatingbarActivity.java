package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityRatingbarBinding;
import com.example.myapplication.databinding.DialogRatingbarBinding;

public class RatingbarActivity extends BaseActivity {
    ActivityRatingbarBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRatingbarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogRatingbarBinding binding = DialogRatingbarBinding.inflate(getLayoutInflater());
                Dialog dialog = new Dialog(context);
                dialog.setContentView(binding.getRoot());
                dialog.setCancelable(false);
                binding.ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                        showToast(String.valueOf(rating));
                    }
                });
                dialog.show();

            }
        });

    }
}