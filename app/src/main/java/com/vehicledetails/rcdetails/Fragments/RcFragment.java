package com.vehicledetails.rcdetails.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.vehicledetails.rcdetails.InterFace.ApiInterface;
import com.vehicledetails.rcdetails.Models.VehicleModel;
import com.vehicledetails.rcdetails.R;
import com.vehicledetails.rcdetails.db.RecentDBHandler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RcFragment extends Fragment {

    static final String API_URL = "";
    TextView tv;
    EditText vehicleNum;
    Button rcBtn;
    ListView listView;
    ProgressBar progressBar;
    ArrayList<String> prop;
    RecentDBHandler recentDBHandler;
    public RcFragment() {
    }


    public static RcFragment newInstance(String param1, String param2) {
        RcFragment fragment = new RcFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_rc, container, false);
        vehicleNum = (EditText) view.findViewById(R.id.vehicle_number);
        rcBtn = (Button) view.findViewById(R.id.rcBtn);
        tv = (TextView) view.findViewById(R.id.tv);
        listView = (ListView) view.findViewById(R.id.listView);
        progressBar = (ProgressBar) view.findViewById(R.id.progress);
        rcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                getVehicle(vehicleNum.getText().toString());
                InputMethodManager imm = (InputMethodManager) requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(vehicleNum.getWindowToken(), 0);
                listView.setAdapter(null);
                listView.setVisibility(View.GONE);

            }
        });
        return view;
    }

    private void getVehicle(String vehicleNum) {

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(API_URL)
                .build();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        VehicleModel vehicleModel = new VehicleModel(vehicleNum);
        Call<String> call = apiInterface.getRC(vehicleModel);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                tv.setText("");
                htmlParse(response.body());

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e("Response===>>", "Hello", t);
                progressBar.setVisibility(View.GONE);
                listView.setVisibility(View.GONE);
                tv.setText("Please try again !!!");
            }
        });
    }

    private void htmlParse(String response) {
        String mimeType = "text/html";
        String encoding = "UTF-8";
        String text = "<!DOCTYPE html dir='rtl'><head></head>"
                + "<body><table>"
                + response
                + "</table></body></html>";
        prop = new ArrayList<>();
        Document document = Jsoup.parse(text);
        Elements elements = document.getElementsByTag("td");
        for (int i = 0; i < 51; i++) {
            if (!elements.get(i).text().contentEquals(":"))
                if (!elements.get(i).text().contentEquals(""))
                    prop.add(elements.get(i).text());
                else
                    prop.add("Not Availble");
        }
        progressBar.setVisibility(View.GONE);
        listView.setVisibility(View.VISIBLE);
       // vehicleNum.setText("");
        ArrayAdapter<String> arr;
        arr = new ArrayAdapter<String>(getActivity(),R.layout.list_item,R.id.item_tv, prop);

        listView.setAdapter(arr);
        new RecentDBHandler(getActivity())
                .addNewRC(prop.get(1),prop.get(3),prop.get(5),prop.get(7),prop.get(9),
                        prop.get(11),prop.get(13),prop.get(15),prop.get(17),prop.get(19)
                        ,prop.get(21),prop.get(25),prop.get(29),prop.get(31),prop.get(33));



    }
}














