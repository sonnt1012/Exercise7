package com.dev.ngothanhson95.exercise7;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by ngothanhson95 on 7/12/16.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    private ArrayList<Artist> artistArrayList = new ArrayList<Artist>();

    public RecyclerAdapter(ArrayList<Artist> artistArrayList) {
        this.artistArrayList = artistArrayList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);

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

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder{

        ImageView imgArtist;
        TextView txtArtist;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            imgArtist = (ImageView) itemView.findViewById(R.id.imgArtist);
            txtArtist = (TextView) itemView.findViewById(R.id.txtArtist);
        }
    }
}
