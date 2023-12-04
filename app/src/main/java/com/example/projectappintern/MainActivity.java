package com.example.projectappintern;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.projectappintern.Fragment.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNav;
    private FrameLayout frameLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav = findViewById(R.id.bottom_navigatin_view);
        frameLayout = findViewById(R.id.fragmentmain);
        bottomNav.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if(itemId == R.id.home){
//                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
//                        overridePendingTransition(0,0);
//                        return true;

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.add(R.id.fragmentmain, new HomeFragment());
                    fragmentTransaction.commit();
                }
                else if (itemId == R.id.map) {
                    startActivity(new Intent(getApplicationContext(), buyActivity.class));
                    overridePendingTransition(0,0);
                    return true;
                }
                else if (itemId == R.id.shop) {
//                    startActivity(new Intent(getApplicationContext(), page3.class ));
//                    overridePendingTransition(0,0);
//                    return true;
                }
                else if (itemId == R.id.setting) {
//                        startActivity(new Intent(getApplicationContext(), .class));
//                        overridePendingTransition(0,0);
//                        return true;
                }
                else {
                    Toast.makeText(getApplicationContext()," Error",Toast.LENGTH_LONG).show();

                }



                return false;
            }
        });
        bottomNav.setSelectedItemId(R.id.home);



    }

    public void onImageViewClick(View view) {
        // Your code to handle the click event
        // For example, show a toast or start a new activity
         Toast.makeText(this, "Image clicked!", Toast.LENGTH_SHORT).show();
         Intent intent = new Intent(this, buyActivity.class);
         startActivity(intent);
    }



}