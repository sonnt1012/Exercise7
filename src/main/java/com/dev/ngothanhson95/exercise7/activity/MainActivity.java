package com.dev.ngothanhson95.exercise7.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.dev.ngothanhson95.exercise7.listener.MyItemClickListener;
import com.dev.ngothanhson95.exercise7.model.Artist;
import com.dev.ngothanhson95.exercise7.R;
import com.dev.ngothanhson95.exercise7.adapter.ArtistAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyItemClickListener{
    RecyclerView recyclerView;
    ArtistAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    String[] artistNames;
    String[] artistLink;
    int[] imgRes = {R.drawable.taylor, R.drawable.avril, R.drawable.ade, R.drawable.se};
    ArrayList<Artist> arrayList = new ArrayList<Artist>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.rvArtist);
        artistNames = getResources().getStringArray(R.array.artist_name);
        artistLink = getResources().getStringArray(R.array.artist_link);

        int i =0;
        for(String name : artistNames){
            Artist artist = new Artist(imgRes[i], name, artistLink[i]);
            arrayList.add(artist);
            i++;
        }

        adapter = new ArtistAdapter(arrayList);
        recyclerView.setHasFixedSize(true);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        this.adapter.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(View view, int positon) {
        Artist artist = arrayList.get(positon);
        if(artist!=null){
           Intent intent = new Intent(MainActivity.this, AlbumActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("imgRes", artist.getImgRes());
            bundle.putString("url", artist.getUrl());

            intent.putExtra("Artist", bundle);
            startActivity(intent);
        }
    }
}
