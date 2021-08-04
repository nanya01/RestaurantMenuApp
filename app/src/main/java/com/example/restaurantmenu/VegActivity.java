package com.example.restaurantmenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class VegActivity extends AppCompatActivity implements View.OnClickListener {
    Button add, reduce, order, cancel;
    int price = 2000;
    int totalPrice = 0;
    TextView quantity, quantityText, priceText;
    // total quantity
    int actualQuantity;

    String menu_name = "veg_name";


    Locale nigeria = new Locale("en", "NG");
    NumberFormat nigeriaFormat = NumberFormat.getCurrencyInstance(nigeria);


    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veg);

        // initialize buttons
        add =  findViewById(R.id.add_quantity);
        reduce = findViewById(R.id.reduce_quantity);
        order = findViewById(R.id.order);
        cancel = findViewById(R.id.cancel);
        priceText = findViewById(R.id.price);

        // initialize text views
        quantity = findViewById(R.id.quantity);
        quantityText = findViewById(R.id.quantity_text);

        // set listeners
        add.setOnClickListener(this);
        reduce.setOnClickListener(this);
        order.setOnClickListener(this);
        cancel.setOnClickListener(this);

        // initialize model class

        Item item;

    }

    @Override
    public void onClick(View v) {
        // add quantity
        if(v == add){
            actualQuantity = Integer.valueOf(quantity.getText().toString());
            actualQuantity += 1;
            quantity.setText(String.valueOf(actualQuantity));
            quantityText.setText(String.valueOf(actualQuantity));

            totalPrice = price * actualQuantity;
            String priceCurrencyFormatter = nigeriaFormat.format(totalPrice);
            priceText.setText(priceCurrencyFormatter);

        }
        // reduce quantity
        if(v == reduce){
            if(actualQuantity == 0 ){
                quantity.setText(String.valueOf(actualQuantity));
                String priceCurrencyFormatter = nigeriaFormat.format(totalPrice);
                priceText.setText(priceCurrencyFormatter);
            }else{
                actualQuantity = Integer.valueOf(quantity.getText().toString());
                actualQuantity -= 1;
                quantity.setText(String.valueOf(actualQuantity));
                quantityText.setText(String.valueOf(actualQuantity));

                totalPrice = price * actualQuantity;
                String priceCurrencyFormatter = nigeriaFormat.format(totalPrice);
                priceText.setText(priceCurrencyFormatter);
            }
        }

        // add to cart
        if(v == order){
            intent = new Intent(VegActivity.this, CartActivity.class);
            intent.putExtra("EXTRA_NAME", menu_name);
            intent.putExtra("EXTRA_IMAGE", R.drawable.veg_salad);
            intent.putExtra("EXTRA_QUANTITY", quantityText.getText().toString());
            intent.putExtra("EXTRA_PRICE",priceText.getText().toString());


            startActivity(intent);
        }

        if(v == cancel){
            intent = new Intent(VegActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }

}