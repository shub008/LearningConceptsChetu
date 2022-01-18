package com.example.myapplication.sqliteDb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.activities.BaseActivity;
import com.example.myapplication.activities.ImpliciteIntentActivity;
import com.example.myapplication.databinding.ActivityProfileBinding;

import java.io.ByteArrayOutputStream;

public class ProfileActivity extends BaseActivity implements View.OnClickListener {
    private ActivityProfileBinding binding;
    private static final int CAMERA_REQUEST_CODE = 101;
    String base64Image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.imageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (ContextCompat.checkSelfPermission(ProfileActivity.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
            // TODO : Do ur work
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, CAMERA_REQUEST_CODE);
        }else {
            ActivityCompat.requestPermissions(ProfileActivity.this, new String[]{Manifest.permission.CAMERA, Manifest.permission.CAMERA}, 1);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, CAMERA_REQUEST_CODE);
        }else {
            showToast("User has denied the permission.");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST_CODE && resultCode == RESULT_OK){
            // TODO : BITMAP getting from activity
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            binding.imageView.setImageBitmap(bitmap);


            // TODO : wsaving BITMAP to base64
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream .toByteArray();
            base64Image = Base64.encodeToString(byteArray, Base64.DEFAULT);
            Log.d("BASE64", base64Image);

            // TODO : DEcoding the base64 to bitmap
            byte[] decodedString = Base64.decode(base64Image, Base64.DEFAULT);
            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
            Log.d("WAPIS_BITMAP", ""+decodedByte);
        }
    }
}