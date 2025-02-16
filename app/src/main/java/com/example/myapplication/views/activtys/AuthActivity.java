package com.example.myapplication.views.activtys;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.myapplication.adapters.ViewPagerAdapter;
import com.example.myapplication.views.fragments.LoginFragment;
import com.example.myapplication.views.fragments.SignUpFragment;
import com.google.android.material.tabs.TabLayoutMediator;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.example.myapplication.R;
import com.example.myapplication.adapters.AuthPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class AuthActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_auth);
        setFullScreen(R.id.main);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
//        tabLayout.addTab(tabLayout.newTab().setText("login"));
//        tabLayout.addTab(tabLayout.newTab().setText("Sign Up"));




//        viewPager.setAdapter(viewPagerAdapter);
//        tabLayout.setupWithViewPager(viewPager);


        AuthPagerAdapter adapter = new AuthPagerAdapter(this);
        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    if (position == 0) {
                        tab.setText("Sign Up");
                    } else {
                        tab.setText("Login");

                    }
                }).attach();
    }

    private void setFullScreen(int idd){
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(idd), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}


