package com.example.restaurantmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class CupcakeActivity extends AppCompatActivity implements View.OnClickListener {

    Button add, reduce, order, cancel;
    int price = 3000;
    int totalPrice = 0;
    TextView quantity, quantityText, priceText;
    // total quantity
    Integer actualQuantity = 0;

    Locale nigeria = new Locale("en", "NG");
    NumberFormat nigeriaFormat = NumberFormat.getCurrencyInstance(nigeria);

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cupcake);

        // initialize buttons
        add =  findViewById(R.id.add_cupcake_quantity);
        reduce = findViewById(R.id.reduce_quantity_cupcake);
        order = findViewById(R.id.order_cupcake);
        cancel = findViewById(R.id.cancel_cupcake);
        priceText = findViewById(R.id.price_cupcake);

        // initialize textviews
        quantity = findViewById(R.id.quantity_cupcake);
        quantityText = findViewById(R.id.quantity_text_cupcake);

        // set listeners
        add.setOnClickListener(this);
        reduce.setOnClickListener(this);
        order.setOnClickListener(this);
        cancel.setOnClickListener(this);
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
            intent = new Intent(CupcakeActivity.this, CartActivity.class);
            startActivity(intent);
        }

        if(v == cancel){
            intent = new Intent(CupcakeActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
}