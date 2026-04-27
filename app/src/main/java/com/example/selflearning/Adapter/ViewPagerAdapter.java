package com.example.selflearning.Adapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.selflearning.Fragment.LearningFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {

    private final String baseType;

    public ViewPagerAdapter(@NonNull AppCompatActivity activity, String baseType) {
        super(activity);
        this.baseType = baseType;
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