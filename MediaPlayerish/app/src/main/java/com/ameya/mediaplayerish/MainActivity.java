package com.ameya.mediaplayerish;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Video = (Button) findViewById(R.id.videobtn);
        VideoView Player = (VideoView) findViewById(R.id.videoPlayer);

        mp = MediaPlayer.create(this,R.raw.first_layer);

        Video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String path = "android.resource://"+getPackageName()+"/"+R.raw.seasonal;
                Uri uri = Uri.parse(path);
                Player.setVideoURI(uri);
                Player.start();
            }
        });

    }
    public void playm(View view)
    {
        mp.start();
    }
    public void pausem(View view)
    {
        mp.stop();
        mp = MediaPlayer.create(this,R.raw.first_layer);

    }
}