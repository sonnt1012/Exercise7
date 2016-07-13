package com.dev.ngothanhson95.exercise7.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.dev.ngothanhson95.exercise7.Constant;
import com.dev.ngothanhson95.exercise7.R;
import com.dev.ngothanhson95.exercise7.adapter.AlbumAdapter;
import com.dev.ngothanhson95.exercise7.model.JSONResponse;
import com.dev.ngothanhson95.exercise7.model.Release;
import com.dev.ngothanhson95.exercise7.network.RequestInterface;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AlbumActivity extends AppCompatActivity {
    @Bind(R.id.rvAlbum) RecyclerView recyclerView;
    private ArrayList<Release> albumArrayList;
    private AlbumAdapter adapter;
    String url;
    int imgRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        ButterKnife.bind(this);
        initData();
        initView();
        loadJSON();
    }

    private void initData(){
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra(Constant.bundleKey);
        imgRes = bundle.getInt(Constant.imgKey);
        url = bundle.getString(Constant.urlKey);
    }

    private void initView(){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
    }

    private void loadJSON() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.discogs.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterface requestInterface = retrofit.create(RequestInterface.class);
        Call<JSONResponse> call = requestInterface.getJSON(url);
        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
                JSONResponse jsonResponse = response.body();
                albumArrayList = new ArrayList<>(Arrays.asList(jsonResponse.getReleases()).size());
                albumArrayList.addAll(jsonResponse.getReleases());
                adapter = new AlbumAdapter(albumArrayList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });

    }
}
