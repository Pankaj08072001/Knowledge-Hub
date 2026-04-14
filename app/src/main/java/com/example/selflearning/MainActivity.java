package com.example.selflearning;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvDev, rvRoad, rvMock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolbar();

        rvDev = findViewById(R.id.rvDeveloper);
        rvRoad = findViewById(R.id.rvRoadmap);
        rvMock = findViewById(R.id.rvMock);

        // Developer Types
        rvDev.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvDev.setAdapter(new DeveloperAdapter(
                Arrays.asList("Android", "Java", "PHP", "ML")));

        // Roadmaps
        rvRoad.setLayoutManager(new LinearLayoutManager(this));
        List<String[]> roadList = new ArrayList<>();
        roadList.add(new String[]{"Android Roadmap", "3 Months"});
        roadList.add(new String[]{"Java Roadmap", "2 Months"});
        roadList.add(new String[]{"PHP Roadmap", "3 Months"});
        roadList.add(new String[]{"ML Roadmap", "2 Months"});
        rvRoad.setAdapter(new RoadmapAdapter(roadList));

        // Mock Tests
        rvMock.setLayoutManager(new GridLayoutManager(this, 2));
        rvMock.setAdapter(new MockAdapter(
                Arrays.asList("Android Mock", "Java Mock", "PHP Mock", "ML Mock")));
    }

    private void setUpToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Knowledge Hub");

            // ✅ Show hamburger (drawer) icon
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

            // Optional: replace default back icon with menu icon
            toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
            toolbar.setTitleTextColor(ContextCompat.getColor(this, android.R.color.white));
        }
    }
}