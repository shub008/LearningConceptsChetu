package com.example.myapplication.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityListBinding;
import com.example.myapplication.databinding.DialogProfileBinding;
import com.example.myapplication.db.MyAdapter;
import com.example.myapplication.db.MyCustomListAdapter;
import com.example.myapplication.model.PersonDetails;
import com.example.myapplication.sqliteDb.ProfileActivity;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ListActivity extends BaseActivity implements AdapterView.OnItemClickListener{

    private MyAdapter myAdapter;
    private int CAMERA_REQUEST_CODE = 101;
    private DialogProfileBinding bindingProfile;
    private String base64Image;
    private Cursor cursor;
    private ActivityListBinding binding;
//    private MyCustomListAdapter myCustomListAdapter;
    private int clickedPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, countries);
//        binding.listView.setAdapter(adapter);

        binding.listView.setOnItemClickListener(this);

        myAdapter = new MyAdapter(context);
        myAdapter.openDatabase();

        cursor = myAdapter.getAllRecords();

//        List<PersonDetails> finalList = new ArrayList<>();
//        if (cursor.getCount() > 0){
//            cursor.moveToFirst();
//            do {
////                List<PersonDetails> tempList = new ArrayList<>();
//                String serNo = cursor.getString(0);// serialNo
//                String photo = cursor.getString(1);// photo
//                String fName = cursor.getString(2);// fname
//                String lName = cursor.getString(3);// lname
//                String email = cursor.getString(4);// email
//                String phonoNo = cursor.getString(5);// phoneNo
//                PersonDetails personDetails = new PersonDetails(photo, fName, lName, email, phonoNo);
//                finalList.add(personDetails);
//                Log.d("C_DATA", serNo+"\n"+photo+"\n"+fName+"\n"+lName+"\n"+email+"\n"+phonoNo+"\n");
//            }while (cursor.moveToNext());
//        }else {
//            showToast("No records found");
//        }
//        Log.d("Cursor", ""+cursor);

//        MyCustomListAdapter myCustomListAdapter = new MyCustomListAdapter(finalList, context);
//        binding.listView.setAdapter(myCustomListAdapter);

        loadDataInListView();
        registerForContextMenu(binding.listView);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.db_insertions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_insert_record:
                // TODO: Insertion task
                bindingProfile = DialogProfileBinding.inflate(getLayoutInflater());
                Dialog dialog = new Dialog(context);
                dialog.setContentView(bindingProfile.getRoot());
                dialog.setCancelable(false);

                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
                layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;

                bindingProfile.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ContextCompat.checkSelfPermission(ListActivity.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                            // TODO : Do ur work
                            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            startActivityForResult(intent, CAMERA_REQUEST_CODE);
                        }else {
                            ActivityCompat.requestPermissions(ListActivity.this, new String[]{Manifest.permission.CAMERA, Manifest.permission.CAMERA}, 1);
                        }
                    }
                });

                bindingProfile.btnSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myAdapter.insertRecord(context, base64Image, bindingProfile.tilFname.getEditText().getText().toString(), bindingProfile.tilLname.getEditText().getText().toString()
                                ,bindingProfile.tilEmail.getEditText().getText().toString(), bindingProfile.tilMobileNo.getEditText().getText().toString());
                        dialog.dismiss();

                        // TODO : Refresh the listview
                        cursor = myAdapter.getAllRecords();

                        loadDataInListView();
                    }
                });

                dialog.show();
                dialog.getWindow().setAttributes(layoutParams);
                break;
            case  R.id.item_delete_all_records:
                // TODO : Delete related task
                break;
        }
        return super.onOptionsItemSelected(item);
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
            bindingProfile.imageView.setImageBitmap(bitmap);


            // TODO : wsaving BITMAP to base64
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream .toByteArray();
            base64Image = Base64.encodeToString(byteArray, Base64.DEFAULT);
            Log.d("BASE64", base64Image);

            // TODO : DEcoding the base64 to bitmap
//            byte[] decodedString = Base64.decode(base64Image, Base64.DEFAULT);
//            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
//            Log.d("WAPIS_BITMAP", ""+decodedByte);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        clickedPosition = position;
//        String name = parent.getItemAtPosition(position).toString();
//        showToast(name);
    }

    private List<PersonDetails> getDatainList(){
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

    private void loadDataInListView(){
        if (getDatainList().size() > 0) {
            MyCustomListAdapter myCustomListAdapter = new MyCustomListAdapter(getDatainList(), context);
            binding.listView.setAdapter(myCustomListAdapter);
        }else {
            showToast("No Data found.");
        }
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu_option, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_delete:
                // TODO : DElete record
                cursor.moveToPosition(clickedPosition);
                String colRow = cursor.getString(0);
                myAdapter.deleteRecord(colRow, context);

                cursor = myAdapter.getAllRecords();
                loadDataInListView();
                break;
            case R.id.item_update:
                // TODO : Update record

                break;
        }
        return super.onContextItemSelected(item);
    }
}