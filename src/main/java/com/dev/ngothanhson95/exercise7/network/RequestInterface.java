package com.dev.ngothanhson95.exercise7.network;

import com.dev.ngothanhson95.exercise7.model.JSONResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by ngothanhson95 on 7/12/16.
 */
public interface RequestInterface {
    @GET("artists/{artistId}")
    Call<JSONResponse> getJSON(@Path("artistId") String artistId);
}
