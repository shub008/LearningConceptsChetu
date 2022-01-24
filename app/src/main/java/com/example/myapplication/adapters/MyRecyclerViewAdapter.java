package com.example.myapplication.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.databinding.CustomListItemsBinding;
import com.example.myapplication.model.PersonDetails;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>{
    Context context;
    List<PersonDetails> personDetails;

    public MyRecyclerViewAdapter(Context context, List<PersonDetails> personDetails) {
        this.context = context;
        this.personDetails = personDetails;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // TODO : implementing through findViewById
//        View view = LayoutInflater.from(context).inflate(R.layout.custom_list_items, parent, false);
//        MyViewHolder myViewHolder = new MyViewHolder(view);

        // TODO : implementation using binding
        CustomListItemsBinding binding = CustomListItemsBinding.inflate(LayoutInflater.from(context), parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(binding);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String fname = personDetails.get(position).getfName();
        String lname = personDetails.get(position).getlName();

        String base64Image = personDetails.get(position).getPhoto();

        byte[] decodedString = Base64.decode(base64Image, Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

//        holder.tvName.setText(fname+" "+lname);
//        holder.tvEmail.setText(personDetails.get(position).getEmail());
//        holder.tvPhone.setText(personDetails.get(position).getPhoneNo());
//        holder.imageView.setImageBitmap(bitmap);
        holder.binding.itemName.setText(fname+" "+lname);
        holder.binding.itemEmail.setText(personDetails.get(position).getEmail());
        holder.binding.itemPhone.setText(personDetails.get(position).getPhoneNo());
        holder.binding.itemImageView.setImageBitmap(bitmap);

    }

    @Override
    public int getItemCount() {
        return personDetails.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView tvName, tvEmail, tvPhone;
        CustomListItemsBinding binding;

//        public MyViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            imageView = itemView.findViewById(R.id.item_image_view);
//            tvName = itemView.findViewById(R.id.item_name);
//            tvEmail = itemView.findViewById(R.id.item_email);
//            tvPhone = itemView.findViewById(R.id.item_phone);
//
//        }
        public MyViewHolder(CustomListItemsBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
