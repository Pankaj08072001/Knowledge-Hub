package com.example.selflearning.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.selflearning.Model.MockTest;
import com.example.selflearning.R;

import java.util.List;
public class MockAdapter extends RecyclerView.Adapter<MockAdapter.ViewHolder> {

    List<MockTest> list;

    public interface OnStartClickListener {
        void onStartClick(MockTest model, int position);
    }

    private OnStartClickListener listener;

    public MockAdapter(List<MockTest> list) {
        this.list = list;
    }

    public MockAdapter(List<MockTest> list, OnStartClickListener listener) {
        this.list = list;
        this.listener = listener;
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

        holder.btnStart.setOnClickListener(v -> {
            if (listener != null) {
                listener.onStartClick(model, holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        Button btnStart;
        ViewHolder(View v) {
            super(v);
            tv = v.findViewById(R.id.tvMock);
            btnStart = v.findViewById(R.id.btnStart);
        }
    }
}