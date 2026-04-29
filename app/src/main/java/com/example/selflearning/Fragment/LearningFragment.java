package com.example.selflearning.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.selflearning.Adapter.TechAdapter;
import com.example.selflearning.R;

import java.util.ArrayList;
import java.util.List;

public class LearningFragment extends Fragment {

    private static final String KEY_TYPE = "type";

    public static LearningFragment newInstance(String type) {
        LearningFragment fragment = new LearningFragment();
        Bundle b = new Bundle();
        b.putString(KEY_TYPE, type);
        fragment.setArguments(b);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_learning_list, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));

        String type = getArguments() != null ? getArguments().getString(KEY_TYPE) : "JAVA";

        List<String> list = getStrings(type);

        recyclerView.setAdapter(new TechAdapter(list));

        return view;
    }

    @NonNull
    private static List<String> getStrings(String type) {
        List<String> list = new ArrayList<>();

        switch (type) {

            case "BACKEND":
                list.add("Java Spring Boot");
                list.add("Node.js");
                list.add("Python Django");
                list.add("Database Design");
                list.add("RESTful APIs");
                list.add("Microservices");
                break;

            case "UIUX":
                list.add("Figma Basics");
                list.add("User Research");
                list.add("Wireframe");
                list.add("Prototyping");
                list.add("Color Theory");
                list.add("Typography");
                break;

            default:
                list.add("Coming Soon...");
                break;
        }

        return list;
    }
}