package com.dev.ngothanhson95.exercise7.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dev.ngothanhson95.exercise7.R;
import com.dev.ngothanhson95.exercise7.model.Release;
import com.dev.ngothanhson95.exercise7.viewholder.AlbumViewHolder;

import java.util.ArrayList;

/**
 * Created by ngothanhson95 on 7/12/16.
 */
public class AlbumAdapter extends RecyclerView.Adapter <AlbumViewHolder>{
    private ArrayList<Release> albumArrayList = new ArrayList<Release>();

    public AlbumAdapter(ArrayList<Release> albumArrayList) {
        this.albumArrayList = albumArrayList;
    }

    @Override
    public AlbumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_album, parent, false);
        return new AlbumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AlbumViewHolder holder, int position) {
        holder.setupWith(albumArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return albumArrayList.size();
    }
}
