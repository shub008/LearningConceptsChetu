package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityCardViewBinding;

import java.util.Calendar;

public class CardViewActivity extends BaseActivity {
    ActivityCardViewBinding binding;
    Calendar calendar;
    int DAY_OF_MONTH, MONTH, YEAR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCardViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        calendar = Calendar.getInstance();
        DAY_OF_MONTH = calendar.get(Calendar.DAY_OF_MONTH);
        MONTH = calendar.get(Calendar.MONTH);
        YEAR = calendar.get(Calendar.YEAR);

        Log.d("DATE", DAY_OF_MONTH+"-"+(MONTH + 1)+"-"+YEAR);

      binding.btnShow.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
                  @Override
                  public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                      String date = dayOfMonth+(month + 1)+"-"+year;
                      showToast(date);
                  }
              }, YEAR, MONTH, DAY_OF_MONTH);

              datePickerDialog.show();

          }
      });
    }
}