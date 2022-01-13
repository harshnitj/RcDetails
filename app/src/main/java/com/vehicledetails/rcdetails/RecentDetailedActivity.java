package com.vehicledetails.rcdetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.vehicledetails.rcdetails.db.DbModal;

public class RecentDetailedActivity extends AppCompatActivity {
    DbModal modal;
    ListView lv;
    private Toolbar toolbar;
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recent_detailed);
        lv=(ListView)findViewById(R.id.recentDetailLV);
        toolbar=(Toolbar)findViewById(R.id.recenttoolbar);
        modal=(DbModal) getIntent().getSerializableExtra("DbModal");
        toolbar.setTitle(modal.getRegNo());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            toolbar.getNavigationIcon().mutate().setColorFilter(getColor(R.color.white), PorterDuff.Mode.SRC_IN);
        }
        toolbar.setNavigationOnClickListener(v -> finish());
        Log.d("TAGG",modal.getOwner());
        String[] arr=new String[]{
                "Registration Number",modal.getRegNo(),"Registration Authority",modal.getRegAuth(),"Registration Date",modal.getRegDate(),
                "Chasis Number",modal.getChasis(),"Engine Number",modal.getEngine(),"Fuel Type",modal.getFuel(),
                "Model/Model Name",modal.getModel(),"Manufacturer",modal.getManufact(),"OWNER Name",modal.getOwner(),
                "Financer",modal.getFinacer(),"Fitness/Reg. Upto",modal.getFitness(),"Insurance Expiry",modal.getInsuranceExp(),
                "Vehicle Class",modal.getVehicleClass(),"Vehicle Permit Type",modal.getVehiclePermit(),"Vehicle Permit Upto",modal.getVehiclePermitDate()
        };
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.list_item,R.id.item_tv,arr);
        lv.setAdapter(adapter);


    }
}