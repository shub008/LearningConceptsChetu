package com.example.myapplication.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.databinding.ActivityDialogConceptsBinding;
import com.example.myapplication.databinding.CustomDialogBinding;
import com.example.myapplication.utility.Utility;


public class DialogConceptsActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityDialogConceptsBinding binding;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDialogConceptsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        context = this;

        binding.btnShowDialog.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        // TODO : 1. Alert dialog

//        AlertDialog.Builder builder = new AlertDialog.Builder(context);
//        builder.setTitle(R.string.app_name);
//        builder.setMessage("This is AlertDialog concept.");
//        builder.setCancelable(false);
//        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                Utility.showToast(context, "positive button clicked");
//            }
//        });
//
//        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                Utility.showToast(context, "Negative button clicked");
//                dialogInterface.dismiss();
//            }
//        });

//        builder.setNeutralButton("Nothing", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                Utility.showToast(context, "Neutral button is clicked");
//            }
//        });

//        builder.show();

//        AlertDialog alertDialog = builder.create();
//        alertDialog.show();
//        alertDialog.getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.text_red));
//        alertDialog.getButton(DialogInterface.BUTTON_POSITIVE).setAllCaps(false);

        //TODO : 2. Custom Dialog

        CustomDialogBinding bindingDialog = CustomDialogBinding.inflate(getLayoutInflater());

        Dialog dialog = new Dialog(context);
        dialog.setContentView(bindingDialog.getRoot());
        dialog.setCancelable(false);

        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;

        bindingDialog.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utility.showToast(context, "Hi "+bindingDialog.etName.getText().toString());
                dialog.dismiss();
            }
        });

        bindingDialog.btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
        dialog.getWindow().setAttributes(layoutParams);

    }
}