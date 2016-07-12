package com.dev.ngothanhson95.exercise7.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dev.ngothanhson95.exercise7.R;
import com.dev.ngothanhson95.exercise7.listener.MyItemClickListener;

/**
 * Created by ngothanhson95 on 7/12/16.
 */
public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public ImageView imgArtist;
    public TextView txtArtist;
    private MyItemClickListener itemClickListener;

    public RecyclerViewHolder(View itemView, MyItemClickListener itemClickListener) {
        super(itemView);
        imgArtist = (ImageView) itemView.findViewById(R.id.imgArtist);
        txtArtist = (TextView) itemView.findViewById(R.id.txtArtist);
        this.itemClickListener = itemClickListener;
        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(itemClickListener != null){
            itemClickListener.onItemClick(view, getPosition());
        }
    }
}
