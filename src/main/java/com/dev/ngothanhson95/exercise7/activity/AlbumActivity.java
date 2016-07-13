package com.dev.ngothanhson95.exercise7.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import com.dev.ngothanhson95.exercise7.R;
import com.dev.ngothanhson95.exercise7.adapter.AlbumAdapter;
import com.dev.ngothanhson95.exercise7.model.JSONResponse;
import com.dev.ngothanhson95.exercise7.model.Release;
import com.dev.ngothanhson95.exercise7.network.RequestInterface;
import java.util.ArrayList;
import java.util.Arrays;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AlbumActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private ArrayList<Release> albumArrayList;
    private AlbumAdapter adapter;
    String url;
    int imgRes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("Artist");
        imgRes = bundle.getInt("imgRes");
        url = bundle.getString("url");
        recyclerView = (RecyclerView) findViewById(R.id.rvAlbum);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        loadJSON();
    }

    private void loadJSON(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.discogs.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterface requestInterface = retrofit.create(RequestInterface.class);
        Call<JSONResponse> call = requestInterface.getJSON(url);
        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
                    int status = response.code();
                    JSONResponse jsonResponse = response.body();
                    albumArrayList = new ArrayList<>(Arrays.asList(jsonResponse.getReleases()).size());
                    albumArrayList.addAll(jsonResponse.getReleases());
                    adapter = new AlbumAdapter(albumArrayList);
                    recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });

    }
}
