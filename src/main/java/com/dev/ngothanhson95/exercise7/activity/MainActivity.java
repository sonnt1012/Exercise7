package com.dev.ngothanhson95.exercise7.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.dev.ngothanhson95.exercise7.Constant;
import com.dev.ngothanhson95.exercise7.R;
import com.dev.ngothanhson95.exercise7.adapter.ArtistAdapter;
import com.dev.ngothanhson95.exercise7.listener.MyItemClickListener;
import com.dev.ngothanhson95.exercise7.model.Artist;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MyItemClickListener{
    @Bind(R.id.rvArtist) RecyclerView recyclerView;

    ArtistAdapter adapter;
    String[] artistNames;
    String[] artistLink;
    int[] imgRes;
    ArrayList<Artist> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    private void initData(){
        artistNames = getResources().getStringArray(R.array.artist_name);
        artistLink = getResources().getStringArray(R.array.artist_link);
        imgRes = new int[] {R.drawable.taylor, R.drawable.avril, R.drawable.ade, R.drawable.se};
        int i =0;
        for(String name : artistNames){
            Artist artist = new Artist(imgRes[i], name, artistLink[i]);
            arrayList.add(artist);
            i++;
        }
    }

    private void initView(){
        adapter = new ArtistAdapter(arrayList);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(adapter);
        this.adapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(View view, int positon) {
        Artist artist = arrayList.get(positon);
        if(artist!=null){
           Intent intent = new Intent(MainActivity.this, AlbumActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt(Constant.imgKey, artist.getImgRes());
            bundle.putString(Constant.urlKey, artist.getUrl());
            intent.putExtra(Constant.bundleKey, bundle);
            startActivity(intent);
        }
    }
}
