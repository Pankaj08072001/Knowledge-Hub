package com.example.selflearning;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.selflearning.Adapter.DeveloperAdapter;
import com.example.selflearning.Adapter.RoadmapAdapter;
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
    RecyclerView rvDev, rvRoad, rvMock;
    NavigationView navigationView;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
                Toast.makeText(this, "Drawer Profile", Toast.LENGTH_SHORT).show();
            } else if (item.getItemId() == R.id.nav_roadmap) {
                Toast.makeText(this, "Drawer Roadmap", Toast.LENGTH_SHORT).show();
            } else if (item.getItemId() == R.id.nav_mock) {
                Toast.makeText(this, "Drawer Mock", Toast.LENGTH_SHORT).show();
            } else if (item.getItemId() == R.id.nav_logout) {
                Toast.makeText(this, "Drawer Logout", Toast.LENGTH_SHORT).show();
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

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar,
                R.string.open_drawer, R.string.close_drawer);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

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

    private void loadFragment(Fragment fragment) {

        // findViewById(R.id.scrollView).setVisibility(View.GONE);
        findViewById(R.id.fragment_container).setVisibility(View.VISIBLE);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
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
        list.add(new DeveloperModel("Android", R.drawable.android));
        list.add(new DeveloperModel("Java", R.drawable.java));
        list.add(new DeveloperModel("PHP", R.drawable.php));
        list.add(new DeveloperModel("ML", R.drawable.android));

        rvDev.setAdapter(new DeveloperAdapter(list));
    }

    private void RoadmapsTypeAdapter() {
        rvRoad = findViewById(R.id.rvRoadmap);

        rvRoad.setLayoutManager(new LinearLayoutManager(this));
        List<RoadmapModel> roadList = new ArrayList<>();
        roadList.add(new RoadmapModel("Android Roadmap", "3 Months"));
        roadList.add(new RoadmapModel("Java Roadmap", "2 Months"));
        roadList.add(new RoadmapModel("PHP Roadmap", "3 Months"));
        roadList.add(new RoadmapModel("ML Roadmap", "2 Months"));
        rvRoad.setAdapter(new RoadmapAdapter(roadList));
    }

    private void MockTypeAdapter() {
        rvMock = findViewById(R.id.rvMock);

        rvMock.setLayoutManager(new LinearLayoutManager(this));

        List<MockTest> testList = new ArrayList<>();

        testList.add(new MockTest("Android Mock"));
        testList.add(new MockTest("Java Mock"));
        testList.add(new MockTest("PHP Mock"));
        testList.add(new MockTest("ML Learning"));

        rvMock.setAdapter(new MockAdapter(testList));

    }
}