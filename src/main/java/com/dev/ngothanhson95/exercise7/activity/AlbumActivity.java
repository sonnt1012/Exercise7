package com.dev.ngothanhson95.exercise7.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.dev.ngothanhson95.exercise7.R;

public class AlbumActivity extends AppCompatActivity {
    TextView txtUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        String urlArtist = getIntent().getExtras().get("artistLink").toString();
        txtUrl = (TextView) findViewById(R.id.txtUrl);
        txtUrl.setText(urlArtist);

    }
}
