package com.example.restaurantmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener
   {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;
    NavigationView navigationView;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigation_view);

        toggle = new ActionBarDrawerToggle(this,drawerLayout, toolbar,
                R.string.open_drawer, R.string.close_drawer);

        drawerLayout.addDrawerListener(toggle);
        navigationView.setNavigationItemSelectedListener(this);
        toggle.setDrawerIndicatorEnabled(true);

        toggle.syncState();

        // Adding the food items onclicklisteners
        findViewById(R.id.veg).setOnClickListener(this);
        findViewById(R.id.spaghetti).setOnClickListener(this);
        findViewById(R.id.fries).setOnClickListener(this);
        findViewById(R.id.cupcake).setOnClickListener(this);

    }


       @Override
       public void onClick(View v) {
            // adding onclick events to the cardview(food items)

           switch (v.getId()){
               case R.id.veg:
                   intent = new Intent(MainActivity.this, VegActivity.class);
                   startActivity(intent);
                   break;

               case R.id.spaghetti:
                   intent = new Intent(MainActivity.this, SpaghettiActivity.class);
                   startActivity(intent);
                   break;

               case R.id.fries:
                   intent = new Intent(MainActivity.this, FriesActivity.class);
                   startActivity(intent);
                   break;

               case R.id.cupcake:
                   intent = new Intent(MainActivity.this, CupcakeActivity.class);
                   startActivity(intent);
                   break;

               default:
                   Toast.makeText(MainActivity.this, "Select food item", Toast.LENGTH_SHORT);
                   break;


           }
       }

       @Override
       public boolean onNavigationItemSelected(@NonNull  MenuItem item) {
           return false;
       }
   }