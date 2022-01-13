package com.vehicledetails.rcdetails.InterFace;

import com.vehicledetails.rcdetails.Models.VehicleModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("api/vehicle-details/")
    Call<String> getRC(@Body VehicleModel vehicleModel);
}
