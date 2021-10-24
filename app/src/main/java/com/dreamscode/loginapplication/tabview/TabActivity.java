package com.dreamscode.loginapplication.tabview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.dreamscode.loginapplication.R;
import com.dreamscode.loginapplication.adapters.PagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class TabActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager2 = findViewById(R.id.view_pager);
        ChatFragment chatFragment = new ChatFragment();
        StatusFragment statusFragment = new StatusFragment();
        CallFragment callFragment = new CallFragment();
        tabLayout.setupWithViewPager(viewPager2);
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(),0);
        pagerAdapter.addFragment(chatFragment,"Chat");
        pagerAdapter.addFragment(statusFragment,"Status");
        pagerAdapter.addFragment(callFragment,"Call");
        viewPager2.setAdapter(pagerAdapter);
    }
}