package com.example.restaurantmenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {
    ListView lvProgram;
    private ArrayList<Items> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_items);

        lvProgram = findViewById(R.id.lvProgram);


        Bundle bundle = getIntent().getExtras();

        if(bundle != null){
            String name_veg  = bundle.getString("EXTRA_NAME_VEG");
            String quantity_veg  = bundle.getString("EXTRA_QUANTITY_VEG");
            String price_veg  = bundle.getString("EXTRA_PRICE_VEG");
            int image_veg  = bundle.getInt("EXTRA_IMAGE_VEG");

            String name_spaghetti  = bundle.getString("EXTRA_NAME_SPAGHETTI");
            String quantity_spaghetti  = bundle.getString("EXTRA_QUANTITY_SPAGHETTI");
            String price_spaghetti  = bundle.getString("EXTRA_PRICE_SPAGHETTI");
            int image_spaghetti  = bundle.getInt("EXTRA_IMAGE_SPAGHETTI");
            list = new ArrayList<>();
            list.add(new Items(name_veg,quantity_veg,price_veg,image_veg));
            list.add(new Items(name_spaghetti,quantity_spaghetti,price_spaghetti,image_spaghetti));

            ProgramAdapter programAdapter = new ProgramAdapter(this,  list);
            lvProgram.setAdapter(programAdapter);

        }

    }


}