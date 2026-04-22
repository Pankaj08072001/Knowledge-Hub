package com.example.selflearning.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.selflearning.R;

public class ProfileFragment extends Fragment {

    EditText etName, etEmail, etPhone, etCity, etAddress;
    Button btnSave;

    public ProfileFragment() {
        super(R.layout.fragment_profile);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

        etName = view.findViewById(R.id.etName);
        etEmail = view.findViewById(R.id.etEmail);
        etPhone = view.findViewById(R.id.etPhone);
        etCity = view.findViewById(R.id.etCity);
        etAddress = view.findViewById(R.id.etAddress);
        btnSave = view.findViewById(R.id.btnSave);

        btnSave.setOnClickListener(v -> {
            String name = etName.getText().toString();
            String email = etEmail.getText().toString();

            Toast.makeText(getContext(), "Saved: " + name,  Toast.LENGTH_SHORT).show();
        });
    }
}