package com.example.selflearning;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.selflearning.Activity.DeveloperDetailActivity;
import com.example.selflearning.Activity.MockTestActivity;
import com.example.selflearning.Activity.RoadmapDetailActivity;
import com.example.selflearning.Adapter.DeveloperAdapter;
import com.example.selflearning.Adapter.RoadmapAdapter;
import com.example.selflearning.Fragment.LogoutFragment;
import com.example.selflearning.Fragment.ProfileFragment;
import com.example.selflearning.Fragment.UpdateFragment;
import com.example.selflearning.Model.DeveloperModel;
import com.example.selflearning.Adapter.MockAdapter;
import com.example.selflearning.Model.MockTest;
import com.example.selflearning.Model.RoadmapModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "app_prefs";
    private static final String KEY_NIGHT_MODE = "night_mode";

    RecyclerView rvDev, rvRoad, rvMock;
    NavigationView navigationView;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        applySavedTheme();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolbar();

        developerTypeAdapter();
        RoadmapsTypeAdapter();
        MockTypeAdapter();

        onBottomNavigationHandle();
        setUpDrawer();
        drawerItemHandle();

    }

    private void drawerItemHandle() {
        navigationView.setNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.nav_home) {
                Toast.makeText(this, "Drawer Home", Toast.LENGTH_SHORT).show();
            } else if (item.getItemId() == R.id.nav_profile) {
                loadFragment(new ProfileFragment());
//                Toast.makeText(this, "Drawer Profile", Toast.LENGTH_SHORT).show();
            } else if (item.getItemId() == R.id.nav_roadmap) {
                Toast.makeText(this, "Drawer Roadmap", Toast.LENGTH_SHORT).show();
            } else if (item.getItemId() == R.id.nav_mock) {
                Toast.makeText(this, "Drawer Mock", Toast.LENGTH_SHORT).show();
            } else if (item.getItemId() == R.id.nav_logout) {
                loadFragment(new LogoutFragment());
            } else if (item.getItemId() == R.id.nav_day_night) {
                toggleDayNight();
                return false;
            }
            drawerLayout.closeDrawers();
            return true;
        });
    }

    private void setUpDrawer() {
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        Toolbar toolbar = findViewById(R.id.toolbar);


        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        syncDayNightSwitch();
    }

    private void syncDayNightSwitch() {
        MenuItem item = navigationView.getMenu().findItem(R.id.nav_day_night);
        if (item == null) return;

        boolean isNight = AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES;
        item.setTitle(isNight ? "Night Mode" : "Day Mode");

        View actionView = item.getActionView();
        if (actionView instanceof Switch) {
            Switch sw = (Switch) actionView;
            sw.setChecked(isNight);
            sw.setClickable(false);
            sw.setFocusable(false);
        }
    }

    private void onBottomNavigationHandle() {
        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);

        bottomNav.setOnItemSelectedListener(item ->

        {

            int id = item.getItemId();

            if (id == R.id.nav_home) {
                findViewById(R.id.fragment_container).setVisibility(View.GONE);
                return true;

            } else if (id == R.id.nav_update) {
                loadFragment(new UpdateFragment());
                return true;

            } else if (id == R.id.nav_profile) {
                loadFragment(new ProfileFragment());
                return true;

            }
            return false;
        });

    }

    private void applySavedTheme() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        int mode = prefs.getInt(KEY_NIGHT_MODE, AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
        AppCompatDelegate.setDefaultNightMode(mode);
    }

    private void toggleDayNight() {
        int current = AppCompatDelegate.getDefaultNightMode();
        int next = (current == AppCompatDelegate.MODE_NIGHT_YES)
                ? AppCompatDelegate.MODE_NIGHT_NO
                : AppCompatDelegate.MODE_NIGHT_YES;

        getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
                .edit()
                .putInt(KEY_NIGHT_MODE, next)
                .apply();

        Toast.makeText(this,
                next == AppCompatDelegate.MODE_NIGHT_YES ? "Night Mode" : "Day Mode",
                Toast.LENGTH_SHORT).show();

        AppCompatDelegate.setDefaultNightMode(next);
    }

    private void loadFragment(Fragment fragment) {

        // findViewById(R.id.scrollView).setVisibility(View.GONE);
        findViewById(R.id.fragment_container).setVisibility(View.VISIBLE);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
    }

    private void setUpToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Knowledge Hub");

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

            toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
            toolbar.setTitleTextColor(ContextCompat.getColor(this, android.R.color.white));
        }
    }

    private void developerTypeAdapter() {

        rvDev = findViewById(R.id.rvDeveloper);
        rvDev.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        List<DeveloperModel> list = new ArrayList<>();
        list.add(new DeveloperModel("", R.drawable.android));
        list.add(new DeveloperModel("", R.drawable.java));
        list.add(new DeveloperModel("", R.drawable.php));
        list.add(new DeveloperModel("", R.drawable.android));

        DeveloperAdapter adapter = new DeveloperAdapter(list, model -> {
            Intent intent = new Intent(MainActivity.this, DeveloperDetailActivity.class);
            intent.putExtra(DeveloperDetailActivity.EXTRA_DEV_NAME, model.getName());
            startActivity(intent);
        });

        rvDev.setAdapter(adapter);
    }

    private void RoadmapsTypeAdapter() {
        rvRoad = findViewById(R.id.rvRoadmap);

        rvRoad.setLayoutManager(new LinearLayoutManager(this));
        List<RoadmapModel> roadList = new ArrayList<>();
        roadList.add(new RoadmapModel("Android Roadmap", "3 Months"));
        roadList.add(new RoadmapModel("Java Roadmap", "2 Months"));
        roadList.add(new RoadmapModel("PHP Roadmap", "3 Months"));
        roadList.add(new RoadmapModel("ML Roadmap", "2 Months"));

        rvRoad.setAdapter(new RoadmapAdapter(roadList, (model, position) -> {
            Intent intent = new Intent(MainActivity.this, RoadmapDetailActivity.class);
            intent.putExtra(RoadmapDetailActivity.EXTRA_ROADMAP_TITLE, model.getTitle());
            intent.putExtra(RoadmapDetailActivity.EXTRA_ROADMAP_DURATION, model.getDuration());
            startActivity(intent);
        }));
    }

    public void onTextPop(View v) {
        playTapAnim(v, R.anim.text_tap_pop);
    }

    public void onTextWiggle(View v) {
        playTapAnim(v, R.anim.text_tap_wiggle);
    }

    public void onTextBounce(View v) {
        playTapAnim(v, R.anim.text_tap_bounce);
    }

    private void playTapAnim(View v, int animRes) {
        Animation anim = AnimationUtils.loadAnimation(this, animRes);
        v.startAnimation(anim);
    }

    private void MockTypeAdapter() {
        rvMock = findViewById(R.id.rvMock);

        rvMock.setLayoutManager(new LinearLayoutManager(this));

        List<MockTest> testList = new ArrayList<>();

        testList.add(new MockTest("Android Mock"));
        testList.add(new MockTest("Java Mock"));
        testList.add(new MockTest("PHP Mock"));
        testList.add(new MockTest("ML Learning"));
        testList.add(new MockTest("Kotlin Mock"));
        testList.add(new MockTest("Python Mock"));
        testList.add(new MockTest("DSA Mock"));
        testList.add(new MockTest("HTML Mock"));
        testList.add(new MockTest("CSS Mock"));
        testList.add(new MockTest("JAVASCRIPT Mock"));
        testList.add(new MockTest("AI Learning"));
        testList.add(new MockTest("REACT Mock"));
        testList.add(new MockTest("DJANGO Mock"));
        testList.add(new MockTest("FLUTTER" + " Mock"));

        MockAdapter adapter = new MockAdapter(testList, (model, position) -> {
            Intent intent = new Intent(MainActivity.this, MockTestActivity.class);
            intent.putExtra(MockTestActivity.EXTRA_TEST_NAME, model.getTest());
            startActivity(intent);
        });

        rvMock.setAdapter(adapter);

    }


}