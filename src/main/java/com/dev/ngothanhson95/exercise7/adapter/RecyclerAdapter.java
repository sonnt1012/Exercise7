package com.dev.ngothanhson95.exercise7.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dev.ngothanhson95.exercise7.R;
import com.dev.ngothanhson95.exercise7.listener.MyItemClickListener;
import com.dev.ngothanhson95.exercise7.model.Artist;
import com.dev.ngothanhson95.exercise7.viewholder.RecyclerViewHolder;

import java.util.ArrayList;


/**
 * Created by ngothanhson95 on 7/12/16.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private ArrayList<Artist> artistArrayList = new ArrayList<Artist>();
    private MyItemClickListener listener;

    public RecyclerAdapter(ArrayList<Artist> artistArrayList) {
        this.artistArrayList = artistArrayList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view, listener);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        Artist artist = artistArrayList.get(position);
        holder.imgArtist.setImageResource(artist.getImgRes());
        holder.txtArtist.setText(artist.getName());
    }

    @Override
    public int getItemCount() {
        return artistArrayList.size();
    }

    public void setOnItemClickListener(MyItemClickListener listener){
        this.listener = listener;
    }
}
