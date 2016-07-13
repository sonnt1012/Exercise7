package com.dev.ngothanhson95.exercise7.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dev.ngothanhson95.exercise7.R;
import com.dev.ngothanhson95.exercise7.listener.MyItemClickListener;
import com.dev.ngothanhson95.exercise7.model.Artist;
import com.dev.ngothanhson95.exercise7.viewholder.ArtistViewHolder;

import java.util.ArrayList;


/**
 * Created by ngothanhson95 on 7/12/16.
 */
public class ArtistAdapter extends RecyclerView.Adapter<ArtistViewHolder> {

    private ArrayList<Artist> artistArrayList = new ArrayList<Artist>();
    private MyItemClickListener listener;

    public ArtistAdapter(ArrayList<Artist> artistArrayList) {
        this.artistArrayList = artistArrayList;
    }

    @Override
    public ArtistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_artist, parent, false);
        ArtistViewHolder artistViewHolder = new ArtistViewHolder(view, listener);
        return artistViewHolder;
    }

    @Override
    public void onBindViewHolder(ArtistViewHolder holder, int position) {
        Artist artist = artistArrayList.get(position);
        holder.setupWith(artist);
    }

    @Override
    public int getItemCount() {
        return artistArrayList.size();
    }

    public void setOnItemClickListener(MyItemClickListener listener){
        this.listener = listener;
    }
}
