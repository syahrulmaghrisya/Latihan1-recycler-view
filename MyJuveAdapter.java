package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyJuveAdapter extends RecyclerView.Adapter implements MyJuveAdapter1 {
    private ArrayList<Players> dataList;
    public MyJuveAdapter(ArrayList<Players> dataList) {
        this.dataList = dataList;
    }
    @NonNull
    @Override
    public MyJuveAdapter.PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.card_players, viewGroup, false );
        return new PlayerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public void onBindViewHolder(@NonNull MyJuveAdapter.PlayerViewHolder playerViewHolder, int i) {
        playerViewHolder.tvName.setText(dataList.get(i).getName());
        playerViewHolder.tvPosition.setText(dataList.get(i).getPosition());
        playerViewHolder.tvNumber.setText(String.valueOf(dataList.get(i).getNumber()));
    }
    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }
    public class PlayerViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName, tvPosition, tvNumber;
        public PlayerViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_player);
            tvPosition = (TextView) itemView.findViewById(R.id.tv_pos);
            tvNumber = (TextView) itemView.findViewById(R.id.tv_number);
        }
    }
}
