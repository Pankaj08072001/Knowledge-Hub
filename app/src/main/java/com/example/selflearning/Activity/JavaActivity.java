package com.example.selflearning.Activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.example.selflearning.Adapter.ViewPagerAdapter;
import com.example.selflearning.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Objects;

public class JavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);

        setupToolbar();

        ViewPager2 viewPager = findViewById(R.id.viewPager);
        TabLayout tabLayout = findViewById(R.id.tabLayout);

        viewPager.setAdapter(new ViewPagerAdapter(this));
        viewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    if (position == 0)
                        tab.setText("Frontend");
                    else
                        tab.setText("Backend");
                }).attach();
    }

    private void setupToolbar() {
        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

            setToolbarTitleColor(toolbar);
            setBackArrowColor(toolbar, android.R.color.white); // change color here
            handleBackClick(toolbar);
        }
    }

    private void setToolbarTitleColor(MaterialToolbar toolbar) {
        toolbar.setTitleTextColor(
                ContextCompat.getColor(this, android.R.color.white)
        );
    }

    private void setBackArrowColor(MaterialToolbar toolbar, int color) {

        Drawable upArrow = ContextCompat.getDrawable(
                this,
                androidx.appcompat.R.drawable.abc_ic_ab_back_material
        );

        if (upArrow != null) {
            upArrow.setTint(ContextCompat.getColor(this, color));
            toolbar.setNavigationIcon(upArrow);
        }
    }

    private void handleBackClick(MaterialToolbar toolbar) {
        toolbar.setNavigationOnClickListener(v -> onBackPressed());
    }
}
