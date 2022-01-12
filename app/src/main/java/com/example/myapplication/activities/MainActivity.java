package com.example.myapplication.activities;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

import java.nio.file.WatchKey;

public class MainActivity extends BaseActivity implements View.OnClickListener, PopupMenu.OnMenuItemClickListener, RadioGroup.OnCheckedChangeListener {
    private Button btnSubmit, btn2;
    private Context context;
    private EditText etInput;
    private TextView tvResult;
    private CheckBox cbMale, cbFemale;
    private RadioGroup rbGroup;


    private ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        context =  MainActivity.this;


//        btnSubmit = findViewById(R.id.btnSubmit);
////        btn2 = findViewById(R.id.btn2);
//        etInput = findViewById(R.id.etInput);
//        context =  MainActivity.this;
////        tvResult = findViewById(R.id.tvResult);
//        cbMale = findViewById(R.id.cbMale);
//        cbFemale = findViewById(R.id.cbFeMale);
//        rbGroup = findViewById(R.id.radioGroup);
//
//
//        rbGroup.setOnCheckedChangeListener(this);
//
//
//        cbMale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                Toast.makeText(context, cbMale.getText().toString(), Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        cbFemale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                Toast.makeText(context, cbFemale.getText().toString(), Toast.LENGTH_SHORT).show();
//            }
//        });
//
//
//        btnSubmit.setOnClickListener(this);

//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(context,  btn2.getText().toString(), Toast.LENGTH_SHORT).show();
//            }
//        });

        binding.btnSubmit.setBackgroundColor(Color.RED);

        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(context, binding.etInput.getText().toString(), Toast.LENGTH_SHORT).show();
//                Utility.showToast(context, "Hello");
//                showCustomToast("Hello Custom");

                Snackbar.make(view, "Helo snackbar", Snackbar.LENGTH_SHORT).setAction("Ok", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // TODO : Do ur TAsk
                    }
                }).show();
            }
        });


//        registerForContextMenu(btnSubmit);

    }

    @Override
    public void onClick(View view) {
//        if (!TextUtils.isEmpty(etInput.getText().toString())){
//            tvResult.setVisibility(View.VISIBLE);
//            tvResult.setText(etInput.getText().toString());
//        }else {
//            Toast.makeText(context, "Please enter something", Toast.LENGTH_LONG).show();
//            tvResult.setVisibility(View.GONE);
//        }

        //Todo: Cration of popup menu

//        PopupMenu popupMenu = new PopupMenu(context, btnSubmit);
//        getMenuInflater().inflate(R.menu.options_menu_items, popupMenu.getMenu());
//        popupMenu.setOnMenuItemClickListener(this);
//        popupMenu.show();

        //TODO: onclick event throun xml
//        onSubmitButtonClick(view);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.options_menu_items, menu);
//        getMenuInflater().inflate(R.menu.options_menu_items, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(context, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.item2:

                break;

            case R.id.item3:

                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.options_menu_items, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(context, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.item2:

                break;

            case R.id.item3:

                break;
        }
        return super.onContextItemSelected(item);
    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(context, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.item2:

                break;

            case R.id.item3:

                break;
        }
        return false;
    }

    private void onSubmitButtonClick(View view){
        Toast.makeText(context, "item.getTitle()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
//       int id = radioGroup.getCheckedRadioButtonId();
//       RadioButton radioButton = (RadioButton) findViewById(id);
//
//       Toast.makeText(context, radioButton.getText().toString(), Toast.LENGTH_SHORT).show();

    }





}
