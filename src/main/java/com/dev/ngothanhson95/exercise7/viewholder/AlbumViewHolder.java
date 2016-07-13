package com.dev.ngothanhson95.exercise7.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.dev.ngothanhson95.exercise7.R;

/**
 * Created by ngothanhson95 on 7/12/16.
 */
public class AlbumViewHolder extends RecyclerView.ViewHolder{

    public ImageView imgAlbum;
    public TextView txtAlbum;
    public TextView txtAuthor;
    public Button btnMenuAlbum;
    public AlbumViewHolder(View itemView) {
        super(itemView);
        imgAlbum = (ImageView) itemView.findViewById(R.id.imgAlbum);
        txtAlbum = (TextView) itemView.findViewById(R.id.txtTilte);
        txtAuthor = (TextView) itemView.findViewById(R.id.txtAuthor);
        btnMenuAlbum = (Button) itemView.findViewById(R.id.btnMenuAlbum);
    }


}
