package com.example.latihanmvp.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PagingResponse<T> {

    @Expose
    @SerializedName("status")
    private String status;

    @Expose
    @SerializedName("data")
    private List<T> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PagingResponse{" +
                "status='" + status + '\'' +
                ", data=" + data +
                '}';
    }
}
