package com.sti.homecoming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

public class HomeActivity extends AppCompatActivity {

    private Button start,exit;
    private TextView title;
    Animation topanimation;
    SoundEffect soundEffect;
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_home);

        soundEffect = new SoundEffect(this);
        startService(new Intent(this,BackgroundSoundService.class));

        topanimation = AnimationUtils.loadAnimation(this,R.anim.top_animation);


        //Declarations to Activity
        start = findViewById(R.id.btn_start);
        exit = findViewById(R.id.btn_exit);
        title = findViewById(R.id.txt_Title);
        videoView = findViewById(R.id.video_home);
        

        start.setAnimation(topanimation);
        exit.setAnimation(topanimation);
        title.setAnimation(topanimation);


        // Background Video
        String path = "android.resource://"+getPackageName()+"/"+R.raw.home_background;
        Uri uri = Uri.parse(path);
        videoView.setVideoURI(uri);
        videoView.start();

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });


        // Start Button
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                Intent in = new Intent(HomeActivity.this, Instructions.class);
                in.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivityForResult(in, 0);
                overridePendingTransition(0,0);
                finish();
            }
        });

        //Exit Button
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(HomeActivity.this,BackgroundSoundService.class));
             soundEffect.NormalSound();

             finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        videoView.resume();
        videoView.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        videoView.pause();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        videoView.stopPlayback();
    }

}