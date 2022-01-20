package com.example.myapplication.db;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.myapplication.databinding.CustomListItemsBinding;
import com.example.myapplication.model.PersonDetails;

import java.util.ArrayList;
import java.util.List;

public class MyCustomListAdapter extends BaseAdapter {
    private List<PersonDetails> personDetails = new ArrayList<>();
    private Context context;

    public MyCustomListAdapter(List<PersonDetails> personDetails, Context context) {
        this.personDetails = personDetails;
        this.context = context;
    }

    @Override
    public int getCount() {
        return personDetails.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        CustomListItemsBinding binding = CustomListItemsBinding.inflate(LayoutInflater.from(context), parent, false);
        view = binding.getRoot();

        byte[] decodedString = Base64.decode(personDetails.get(position).getPhoto(), Base64.DEFAULT);
        Bitmap bitMap = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        binding.itemImageView.setImageBitmap(bitMap);
        String name = personDetails.get(position).getfName()+" "+personDetails.get(position).getlName();
        binding.itemName.setText(name);
        binding.itemEmail.setText(personDetails.get(position).getEmail());
        binding.itemPhone.setText(personDetails.get(position).getPhoneNo());

        return view;
    }
}
