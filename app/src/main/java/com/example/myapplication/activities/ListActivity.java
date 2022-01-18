package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.db.MyAdapter;

public class ListActivity extends BaseActivity {

    private MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        myAdapter = new MyAdapter(context);
        myAdapter.openDatabase();
    }
}