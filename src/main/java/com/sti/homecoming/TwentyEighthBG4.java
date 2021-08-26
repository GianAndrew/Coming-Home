package com.sti.homecoming;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.VideoView;

public class TwentyEighthBG4 extends AppCompatActivity {


    private Button btn_okay, btn_back, btn_next,btn_next_2,btn_next_3;
    private VideoView videoView;
    private TextView convo_mayari,txt_charac;
    private ImageButton btn_setting;
    private SoundEffect soundEffect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_twenty_eighth_b_g4);


        soundEffect = new SoundEffect(this);
        btn_setting = findViewById(R.id.twentyeighth_bg4_imagebtn);
        btn_okay = findViewById(R.id.btn_okay_twentyeighthbg4);
        btn_back = findViewById(R.id.btn_back_twentyeighthbg4);
        btn_next = findViewById(R.id.btn_next_twentyeighthbg4);
        btn_next_2 = findViewById(R.id.btn_next_2_twentyeighthbg4);
        btn_next_3 = findViewById(R.id.btn_next_3_twentyeighthbg4);
        videoView = findViewById(R.id.twentyeighthbg4_video);
        convo_mayari = findViewById(R.id.txt_convo_twentyeighthbg4);
        txt_charac = findViewById(R.id.txt_charac_twentyeighthbg4);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                convo_mayari.setText("By the way, thank you for helping me to come back home. ");
                btn_next.setVisibility(View.GONE);
                btn_next_2.setVisibility(View.VISIBLE);
            }
        });
        btn_next_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                convo_mayari.setText("I know I should’ve booked a plane ticket to come back here but I still insisted to travel through car because I want to slowly cope up with my past. Thank you.");
                btn_next_2.setVisibility(View.GONE);
                btn_okay.setVisibility(View.VISIBLE);
            }
        });

        btn_okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                Intent in = new Intent(getApplicationContext(), TwentyNinethBG.class);
                startActivityForResult(in,0);
                overridePendingTransition(0,0);
                finish();
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                Intent in = new Intent(getApplicationContext(), TwentyEighthBG3.class);
                startActivityForResult(in,0);
                overridePendingTransition(0,0);
                finish();
            }
        });
        btn_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                showdialog();
            }
        });

        String path = "android.resource://"+getPackageName()+"/"+R.raw.twenty_eighth_two;
        Uri uri = Uri.parse(path);
        videoView.setVideoURI(uri);
        videoView.start();

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
    }
    public void showdialog(){

        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_setting);


        Button resumebtn = dialog.findViewById(R.id.resume_button);
        Button restartbtn = dialog.findViewById(R.id.restart_button);
        Button homebtn = dialog.findViewById(R.id.home_button);

        resumebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                dialog.dismiss();
            }
        });
        restartbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.restartSounds();
                Intent in = new Intent(getApplicationContext(), FirstBG.class);
                startActivityForResult(in,0);
                overridePendingTransition(0,0);
                finish();
            }
        });
        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.restartSounds();
                Intent in = new Intent(getApplicationContext(), HomeActivity.class);
                startActivityForResult(in,0);
                overridePendingTransition(0,0);
                finish();
            }
        });

        dialog.show();

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