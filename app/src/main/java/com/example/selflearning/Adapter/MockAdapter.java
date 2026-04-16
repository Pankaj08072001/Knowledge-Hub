package com.example.selflearning.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.selflearning.Model.MockTest;
import com.example.selflearning.R;

import java.util.List;
public class MockAdapter extends RecyclerView.Adapter<MockAdapter.ViewHolder> {

    List<MockTest> list;

    public MockAdapter(List<MockTest> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_mock, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        MockTest model = list.get(position);

        holder.tv.setText(model.getTest());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        ViewHolder(View v) {
            super(v);
            tv = v.findViewById(R.id.tvMock);
        }
    }
}
