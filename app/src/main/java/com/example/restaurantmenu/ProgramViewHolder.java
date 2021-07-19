package com.example.restaurantmenu;

import android.view.View;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProgramViewHolder {
    CircleImageView itemImage;
    TextView itemName;
    TextView itemQuantity;
    TextView itemPrice;

    ProgramViewHolder(View v){
        itemImage = v.findViewById(R.id.item_image);
        itemName = v.findViewById(R.id.item_name);
        itemQuantity = v.findViewById(R.id.item_quantity);
        itemPrice = v.findViewById(R.id.item_price);
    }
}
