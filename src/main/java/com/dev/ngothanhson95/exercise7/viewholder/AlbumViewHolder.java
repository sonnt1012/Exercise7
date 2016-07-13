package com.dev.ngothanhson95.exercise7.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.dev.ngothanhson95.exercise7.R;
import com.dev.ngothanhson95.exercise7.model.Release;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by ngothanhson95 on 7/12/16.
 */
public class AlbumViewHolder extends RecyclerView.ViewHolder{

    @Bind(R.id.imgAlbum) public ImageView imgAlbum;
    @Bind(R.id.txtTilte) public TextView txtAlbum;
    @Bind(R.id.txtAuthor) public TextView txtAuthor;
    @Bind(R.id.btnMenuAlbum) public Button btnMenuAlbum;

    public AlbumViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setupWith(Release release){
        txtAlbum.setText(release.getTitle());
        txtAuthor.setText(release.getArtist());
    }

}
