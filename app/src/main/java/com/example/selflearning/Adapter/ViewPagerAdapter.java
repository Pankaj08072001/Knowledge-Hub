package com.example.selflearning.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.selflearning.Fragment.LearningFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fa) {
        super(fa);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0)
            return LearningFragment.newInstance("UIUX");
        else
            return LearningFragment.newInstance("BACKEND");
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}