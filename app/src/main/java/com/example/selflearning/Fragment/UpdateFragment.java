package com.example.selflearning.Fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.selflearning.Adapter.RoadmapAdapter;
import com.example.selflearning.R;
import com.example.selflearning.Model.UpdateModel;

import java.util.ArrayList;

public class UpdateFragment extends Fragment {

    RecyclerView recyclerView;

    public UpdateFragment() {
        super(R.layout.fragment_update);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ArrayList<UpdateModel> list = new ArrayList<>();
        list.add(new UpdateModel("Android", "Learn Android Development"));
        list.add(new UpdateModel("Java", "Master Core Java"));
        list.add(new UpdateModel("DSA", "Practice Data Structures"));
        list.add(new UpdateModel("Android", "Learn Android Development"));
        list.add(new UpdateModel("Java", "Master Core Java"));
        list.add(new UpdateModel("DSA", "Practice Data Structures"));
        list.add(new UpdateModel("Android", "Learn Android Development"));
        list.add(new UpdateModel("Java", "Master Core Java"));
        list.add(new UpdateModel("DSA", "Practice Data Structures"));
        list.add(new UpdateModel("Android", "Learn Android Development"));
        list.add(new UpdateModel("Java", "Master Core Java"));
        list.add(new UpdateModel("DSA", "Practice Data Structures"));
        list.add(new UpdateModel("Android", "Learn Android Development"));
        list.add(new UpdateModel("Java", "Master Core Java"));
        list.add(new UpdateModel("DSA", "Practice Data Structures"));
        list.add(new UpdateModel("Android", "Learn Android Development"));
        list.add(new UpdateModel("Java", "Master Core Java"));
        list.add(new UpdateModel("DSA", "Practice Data Structures"));
        list.add(new UpdateModel("Android", "Learn Android Development"));
        list.add(new UpdateModel("Java", "Master Core Java"));
        list.add(new UpdateModel("DSA", "Practice Data Structures"));
        list.add(new UpdateModel("Android", "Learn Android Development"));
        list.add(new UpdateModel("Java", "Master Core Java"));
        list.add(new UpdateModel("DSA", "Practice Data Structures"));
        list.add(new UpdateModel("Android", "Learn Android Development"));
        list.add(new UpdateModel("Java", "Master Core Java"));
        list.add(new UpdateModel("DSA", "Practice Data Structures"));
        list.add(new UpdateModel("Android", "Learn Android Development"));
        list.add(new UpdateModel("Java", "Master Core Java"));
        list.add(new UpdateModel("DSA", "Practice Data Structures"));
        list.add(new UpdateModel("Android", "Learn Android Development"));
        list.add(new UpdateModel("Java", "Master Core Java"));
        list.add(new UpdateModel("DSA", "Practice Data Structures"));
        list.add(new UpdateModel("Android", "Learn Android Development"));
        list.add(new UpdateModel("Java", "Master Core Java"));
        list.add(new UpdateModel("DSA", "Practice Data Structures"));
        list.add(new UpdateModel("Android", "Learn Android Development"));
        list.add(new UpdateModel("Java", "Master Core Java"));
        list.add(new UpdateModel("DSA", "Practice Data Structures"));
        list.add(new UpdateModel("Android", "Learn Android Development"));
        list.add(new UpdateModel("Java", "Master Core Java"));
        list.add(new UpdateModel("DSA", "Practice Data Structures"));

        RoadmapAdapter.UpdateAdapter adapter = new RoadmapAdapter.UpdateAdapter(list);
        recyclerView.setAdapter(adapter);
    }
}
