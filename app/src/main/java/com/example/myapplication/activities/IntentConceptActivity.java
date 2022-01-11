package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.example.myapplication.databinding.ActivityIntentConceptBinding;
import com.example.myapplication.utility.Constants;
import com.example.myapplication.utility.Utility;
import com.google.gson.Gson;

public class IntentConceptActivity extends BaseActivity implements View.OnClickListener {
    private String _tag = "TAG";
    private ActivityIntentConceptBinding binding;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityIntentConceptBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        context = this;
        Log.d(_tag, "onCreate() in fist class");

        getSupportActionBar().setTitle("App Titile");

        binding.btnClick.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(_tag, "onStart() in fist class");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(_tag, "onResume() in fist class");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(_tag, "onPause() in fist class");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(_tag, "onStop() in fist class");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(_tag, "onRestart() in fist class");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(_tag, "onDestroy() in fist class");
    }

    @Override
    public void onClick(View view) {
        if (!TextUtils.isEmpty(binding.etFname.getText().toString()) && !TextUtils.isEmpty(binding.etLname.getText().toString())
        && !TextUtils.isEmpty(binding.etPhoneno.getText().toString())){
            if (binding.etPhoneno.getText().toString().length() == 10) {
                // TODO : (1) Passing data to intent
//            Intent intent = new Intent(context, SecondActivity.class);
//            intent.putExtra(Constants.FNAME, binding.etFname.getText().toString());
//            intent.putExtra(Constants.LNAME, binding.etLname.getText().toString());
//            intent.putExtra(Constants.PHONENO, binding.etPhoneno.getText().toString());
//            startActivity(intent);

                // TODO : (2) Passing data through Bundle

                Intent intent = new Intent(context, SecondActivity.class);
                intent.putExtra(Constants.FNAME, binding.etFname.getText().toString());
//                Bundle bundle = new Bundle();
//                bundle.putString(Constants.FNAME, binding.etFname.getText().toString());
//                bundle.putString(Constants.LNAME, binding.etLname.getText().toString());
//                bundle.putString(Constants.PHONENO, binding.etPhoneno.getText().toString());
//                intent.putExtras(bundle);
                startActivity(intent);

                // TODO : (3) Passing data through Custom class object to intent
                /*UserData userData = new UserData();
                userData.setFname(binding.etFname.getText().toString());
                userData.setLname(binding.etLname.getText().toString());
                userData.setPhoneno(binding.etPhoneno.getText().toString());

                Intent intent = new Intent(context, SecondActivity.class);
                intent.putExtra(Constants.SERIALIZEDDATA, userData);
                startActivity(intent);*/

                // TODO : (4) Passing data through  JSON object to intent
                /*UserData userData = new UserData();
                userData.setFname(binding.etFname.getText().toString());
                userData.setLname(binding.etLname.getText().toString());
                userData.setPhoneno(binding.etPhoneno.getText().toString());*/

                /*Intent intent = new Intent(context, SecondActivity.class);
                intent.putExtra(Constants.JSONDATA, new Gson().toJson(userData));
                startActivity(intent);*/



            }else {
                Utility.showToast(context, "Please enter valid phone no.");
            }


        }else {
            if (TextUtils.isEmpty(binding.etFname.getText().toString())){
                binding.etFname.setError("Enter first name");
            }else if (TextUtils.isEmpty(binding.etLname.getText().toString())){
                binding.etLname.setError("Enter last name");
            }else if (TextUtils.isEmpty(binding.etPhoneno.getText().toString())){
                binding.etPhoneno.setError("Enter phone number");
            }
        }
    }
}