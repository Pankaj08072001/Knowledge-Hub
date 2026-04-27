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

            case "JAVA":
                list.add("OOP Concepts");
                list.add("Collections Framework");
                list.add("Exception Handling");
                list.add("Multithreading");
                list.add("JDBC");
                list.add("Servlets & JSP");
                break;

            case "PHP":
                list.add("PHP Basics");
                list.add("Laravel Framework");
                list.add("Sessions & Cookies");
                list.add("Form Handling");
                list.add("MySQL with PHP");
                list.add("REST API in PHP");
                break;

            case "ANDROID":
                list.add("XML Layouts");
                list.add("RecyclerView");
                list.add("ConstraintLayout");
                list.add("Navigation Component");
                list.add("Animations");
                list.add("Material Design");
                break;

            default:
                list.add("Coming Soon...");
        }

        return list;
    }
}