package com.vehicledetails.rcdetails.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vehicledetails.rcdetails.R;
import com.vehicledetails.rcdetails.db.DbModal;
import com.vehicledetails.rcdetails.db.RecentDBAdapter;
import com.vehicledetails.rcdetails.db.RecentDBHandler;

import java.util.ArrayList;

public class RecentFragment extends Fragment {

    RecyclerView recentRV;
    ArrayList<DbModal> rcList;

    public RecentFragment() {

    }

    public static RecentFragment newInstance() {
        RecentFragment fragment = new RecentFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recent, container, false);
        recentRV=v.findViewById(R.id.recentRV);
        return v;
    }
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            RecentDBHandler recentDBHandler = new RecentDBHandler(getActivity());
            rcList=recentDBHandler.getRC();
            Log.d("HSH", String.valueOf(recentDBHandler.getRC().size()));
            RecentDBAdapter adapter=new RecentDBAdapter(rcList);
            recentRV.setAdapter(adapter);
            recentRV.setLayoutManager(new LinearLayoutManager(getActivity()));
            adapter.notifyDataSetChanged();
        }
    }
}