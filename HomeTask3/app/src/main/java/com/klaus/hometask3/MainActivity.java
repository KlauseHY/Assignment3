package com.klaus.hometask3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.klaus.hometask3.fragment.FavouriteFragment;
import com.klaus.hometask3.fragment.HomeFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private HomeFragment homeFragment;
    private FavouriteFragment favouriteFragment;
    private BottomNavigationView bnv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        homeFragment = HomeFragment.newInstance();
        favouriteFragment = FavouriteFragment.newInstance();
        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
        trans.replace(R.id.fl_contain,homeFragment);
        trans.commit();

        bnv = findViewById(R.id.bnv);
        bnv.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.home:
                FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
                trans.replace(R.id.fl_contain,homeFragment);
                trans.commit();
                return true;
            case R.id.fav:
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fl_contain,favouriteFragment);
                fragmentTransaction.commit();
                return true;
        }
        return false;
    }


}
