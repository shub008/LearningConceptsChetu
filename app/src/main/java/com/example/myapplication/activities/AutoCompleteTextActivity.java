package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.MultiAutoCompleteTextView;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityAutoCompleteTextBinding;
import com.example.myapplication.utility.Utility;

public class AutoCompleteTextActivity extends BaseActivity {
    private ActivityAutoCompleteTextBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAutoCompleteTextBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, countries);
        binding.tvAutocomplteTxtview.setAdapter(adapter);

        binding.tvAutocomplteTxtview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String countryName = adapterView.getItemAtPosition(position).toString();
                Utility.showToast(AutoCompleteTextActivity.this, countryName +" is at position "+position);
            }
        });


        binding.multiAutoCompleteTxtview.setAdapter(adapter);
        binding.multiAutoCompleteTxtview.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}