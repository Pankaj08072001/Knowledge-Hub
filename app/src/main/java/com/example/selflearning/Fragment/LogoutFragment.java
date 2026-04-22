package com.example.selflearning.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.selflearning.R;

public class LogoutFragment extends Fragment {

    public LogoutFragment() {
        super(R.layout.fragment_logout);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        TextView tvLogoutMessage = view.findViewById(R.id.tvLogoutMessage);
        tvLogoutMessage.setText("You are successfully logged out");
    }
}