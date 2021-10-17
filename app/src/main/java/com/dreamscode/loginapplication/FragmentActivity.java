package com.dreamscode.loginapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class FragmentActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        bottomNavigationView = findViewById(R.id.bottom_nav_view);
        getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment,new HomeFragment()).commit();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment =null;
            switch (item.getItemId()){
                case R.id.home:
                    fragment = new HomeFragment();
                    break;
                case R.id.orders:
                    fragment = new OrderFragment();
                    break;
                case R.id.profile:
                    fragment = new ProfileFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment,fragment).commit();
            return  true;
//
            }
        });
    }

//    private BottomNavigationView.OnNavigationItemSelectedListener bottomNavMethod = new BottomNavigationView.OnNavigationItemSelectedListener() {
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            Fragment fragment =null;
//            switch (item.getItemId()){
//                case R.id.home:
//                    fragment = new HomeFragment();
//                    break;
//                case R.id.orders:
//                    fragment = new OrderFragment();
//                    break;
//                case R.id.profile:
//                    fragment = new ProfileFragment();
//                    break;
//            }
//            getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment,fragment).commit();
//            return  true;
//        }
//    };
}