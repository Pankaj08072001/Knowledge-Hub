package com.example.selflearning;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.selflearning.Adapter.DeveloperAdapter;
import com.example.selflearning.Adapter.RoadmapAdapter;
import com.example.selflearning.Model.DeveloperModel;
import com.example.selflearning.Adapter.MockAdapter;
import com.example.selflearning.Model.MockTest;
import com.example.selflearning.Model.RoadmapModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvDev, rvRoad, rvMock;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolbar();

        developerTypeAdapter();
        RoadmapsTypeAdapter();
        MockTypeAdapter();

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

    private void developerTypeAdapter() {
        rvDev = findViewById(R.id.rvDeveloper);
        rvDev.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
//        rvDev.setAdapter(new DeveloperAdapter(Arrays.asList("Android", "Java", "PHP", "ML")));
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

        rvMock.setLayoutManager(new GridLayoutManager(this, 2));
//        rvMock.setAdapter(new MockAdapter(Arrays.asList("Android Mock", "Java Mock", "PHP Mock", "ML Mock")));

        List<MockTest> testList = new ArrayList<>();

        testList.add(new MockTest("Android Mock"));
        testList.add(new MockTest("Java Mock"));
        testList.add(new MockTest("PHP Mock"));
        testList.add(new MockTest("ML Learning"));

        rvMock.setAdapter(new MockAdapter(testList));

    }
}