package com.example.latihanmvp.network;

import com.example.latihanmvp.BuildConfig;
import com.example.latihanmvp.root.AppConstant;
import com.example.latihanmvp.data.model.PagingResponse;
import com.example.latihanmvp.data.model.employee.EmployeeResp;

import retrofit2.Response;
import retrofit2.http.GET;
import rx.Observable;

public interface NetworkInterface {

    @GET(BuildConfig.BASE_PATH + "employees")
    Observable<Response<PagingResponse<EmployeeResp>>> getAllEmployess();

}
