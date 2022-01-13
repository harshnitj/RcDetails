package com.vehicledetails.rcdetails.db;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.vehicledetails.rcdetails.R;
import com.vehicledetails.rcdetails.RecentDetailedActivity;

import java.util.ArrayList;

public class RecentDBAdapter extends RecyclerView.Adapter<RecentDBAdapter.RecentHolder> {

    ArrayList<DbModal> rcList;
    RecentDBHandler handler;

    public RecentDBAdapter(ArrayList<DbModal> rcList) {
        this.rcList = rcList;
    }

    @NonNull
    @Override
    public RecentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recent_rv_item, parent, false);
        return new RecentHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecentHolder holder, @SuppressLint("RecyclerView") int position) {
        DbModal modal = rcList.get(position);
        holder.regNum.setText(modal.getRegNo());
        holder.model.setText(modal.getModel());
        holder.delete.setOnClickListener(view -> {
            handler = new RecentDBHandler(view.getContext());
            handler.deleteRC(modal.getRegNo());
            rcList.remove(position);
            Toast.makeText(view.getContext(), "Deleted successfully", Toast.LENGTH_SHORT).show();
            notifyDataSetChanged();

        });
        holder.itemView.setOnClickListener(view -> {
            Intent intent=new Intent(view.getContext(), RecentDetailedActivity.class);
             intent.putExtra("DbModal",rcList.get(position));
             view.getContext().startActivity(intent);

        });

    }

    @Override
    public int getItemCount() {
        return rcList.size();
    }

    public class RecentHolder extends RecyclerView.ViewHolder {
        TextView regNum, model;
        ImageView delete;

        public RecentHolder(@NonNull View itemView) {
            super(itemView);
            regNum = itemView.findViewById(R.id.regNumber);
            model = itemView.findViewById(R.id.model);
            delete=itemView.findViewById(R.id.delete);

        }
    }
}
