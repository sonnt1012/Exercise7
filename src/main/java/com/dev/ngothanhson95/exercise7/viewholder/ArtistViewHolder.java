package com.dev.ngothanhson95.exercise7.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dev.ngothanhson95.exercise7.R;
import com.dev.ngothanhson95.exercise7.listener.MyItemClickListener;
import com.dev.ngothanhson95.exercise7.model.Artist;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by ngothanhson95 on 7/12/16.
 */
public class ArtistViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    @Bind(R.id.imgArtist) public ImageView imgArtist;
    @Bind(R.id.txtArtist) public TextView txtArtist;
    private MyItemClickListener itemClickListener;

    public ArtistViewHolder(View itemView, MyItemClickListener itemClickListener) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.itemClickListener = itemClickListener;
        itemView.setOnClickListener(this);
    }

    public void setupWith(Artist artist){
        txtArtist.setText(artist.getName());
        imgArtist.setImageResource(artist.getImgRes());
    }

    @Override
    public void onClick(View view) {
        if(itemClickListener != null){
            itemClickListener.onItemClick(view, getPosition());
        }
    }
}
