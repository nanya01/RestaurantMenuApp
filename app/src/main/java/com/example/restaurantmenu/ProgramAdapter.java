package com.example.restaurantmenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ProgramAdapter extends ArrayAdapter<Items> {
    Context context;
    ArrayList<Items> list;
    public ProgramAdapter(@NonNull Context context, ArrayList<Items> list) {
        super(context, R.layout.activity_cart, list);

        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {

        View singleItem = convertView;
        ProgramViewHolder holder = null;

        if(singleItem == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            singleItem = layoutInflater.inflate(R.layout.activity_cart, parent, false);
            holder = new ProgramViewHolder(singleItem);
            singleItem.setTag(holder);
        }else{
            holder = (ProgramViewHolder) singleItem.getTag();
        }

        holder.itemImage.setImageResource(list.get(position).getImage());
        holder.itemName.setText(list.get(position).getName());
        holder.itemQuantity.setText(list.get(position).getQuantity());
        holder.itemPrice.setText(list.get(position).getPrice());
        return singleItem;
    }
}
