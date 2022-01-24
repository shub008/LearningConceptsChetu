package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.myapplication.R;
import com.example.myapplication.adapters.MyRecyclerViewAdapter;
import com.example.myapplication.databinding.ActivityRecyclerViewActvityBinding;
import com.example.myapplication.db.MyAdapter;
import com.example.myapplication.model.PersonDetails;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActvity extends BaseActivity {
    private ActivityRecyclerViewActvityBinding binding;
    private Cursor cursor;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRecyclerViewActvityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        myAdapter = new MyAdapter(context);
        myAdapter.openDatabase();

        LinearLayoutManager manager = new LinearLayoutManager(context);
//        GridLayoutManager manager = new GridLayoutManager(context, 2);
//        StaggeredGridLayoutManager manager  = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL);
        binding.recyclerView.setLayoutManager(manager);

        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(context, getPersonList());
        binding.recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    private List<PersonDetails> getPersonList(){
        cursor = myAdapter.getAllRecords();
        List<PersonDetails> finalList = new ArrayList<>();
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                String serNo = cursor.getString(0);// serialNo
                String photo = cursor.getString(1);// photo
                String fName = cursor.getString(2);// fname
                String lName = cursor.getString(3);// lname
                String email = cursor.getString(4);// email
                String phonoNo = cursor.getString(5);// phoneNo
                PersonDetails personDetails = new PersonDetails(photo, fName, lName, email, phonoNo);
                finalList.add(personDetails);
            } while (cursor.moveToNext());
        }
        return finalList;
    }


}