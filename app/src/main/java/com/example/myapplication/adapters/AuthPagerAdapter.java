package com.example.myapplication.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myapplication.views.fragments.LoginFragment;
import com.example.myapplication.views.fragments.SignUpFragment;

public class AuthPagerAdapter extends FragmentStateAdapter {
    public AuthPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new SignUpFragment();

        } else {
            return new LoginFragment();

        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
