package com.example.selflearning.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
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
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        String type = getArguments().getString(KEY_TYPE);

        List<String> list = getStrings(type);

        recyclerView.setAdapter(new TechAdapter(list));
//
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
//        recyclerView.setAdapter(new TechAdapter(list));
//
        return view;
    }

    @NonNull
    private static List<String> getStrings(String type) {
        List<String> list = new ArrayList<>();

        if (type.equals("UIUX")) {
            list.add("XML Layouts");
            list.add("Material Design");
            list.add("ConstraintLayout");
            list.add("RecyclerView");
            list.add("Navigation Component");
            list.add("Animations");
        } else {
            list.add("Room Database");
            list.add("SQLite");
            list.add("Retrofit API");
            list.add("MVVM Architecture");
            list.add("Firebase");
            list.add("Dependency Injection (Hilt)");
        }
        return list;
    }
}
