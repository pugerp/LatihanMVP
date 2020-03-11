package com.example.latihanmvp.network;

import com.example.latihanmvp.AppConstant;
import com.example.latihanmvp.BuildConfig;
import com.example.latihanmvp.network.model.PagingResponse;
import com.example.latihanmvp.network.model.employee.EmployeeResp;

import retrofit2.Response;
import retrofit2.http.GET;
import rx.Observable;

public interface NetworkInterface {
    @GET("")
    Observable<String> getSomething();

    @GET(AppConstant.API_VERS + "employees")
    Observable<Response<PagingResponse<EmployeeResp>>> getAllEmployess();

}
