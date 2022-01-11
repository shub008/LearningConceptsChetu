package com.example.myapplication.utility;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.Toast;

public class Utility {
    public static void showToast(Context context, String msg){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }


}
