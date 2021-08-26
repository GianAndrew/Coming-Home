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

public class TenthBG extends AppCompatActivity {

    private Button btn_okay,btn_back,btn_yes,btn_no,btn_next,btn_next_next;
    private VideoView videoView;
    private TextView convo_mayari, txt_charac;
    private ImageButton btn_setting;
    private SoundEffect soundEffect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_tenth_b_g);

        // Declaration
        soundEffect = new SoundEffect(this);
        btn_setting = findViewById(R.id.tenth_bg_imagebtn);
        convo_mayari = findViewById(R.id.txt_convo_tenthbg);
        videoView = findViewById(R.id.tenthbg_video);
        btn_back = findViewById(R.id.btn_back_tenthbg);
        btn_okay = findViewById(R.id.btn_okay_tenthbg);
        btn_yes = findViewById(R.id.btn_yes_tenthbg);
        btn_no = findViewById(R.id.btn_no_tenthbg);
        btn_next = findViewById(R.id.btn_next_tenthbg);
        txt_charac = findViewById(R.id.txt_charac_tenthbg);
        btn_next_next = findViewById(R.id.btn_next_next_tenthbg);


        //Function

        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                convo_mayari.setText("Yehey! Let’s enjoy the festival! But let’s find a place to park the car first.");
                btn_yes.setVisibility(View.GONE);
                btn_no.setVisibility(View.GONE);
                btn_back.setVisibility(View.VISIBLE);
                btn_next.setVisibility(View.VISIBLE);
            }
        });
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                convo_mayari.setText("Mayari saw something nice, and she wanted to look at it. You didn’t have any choice but to stop the car, and enjoy the festival.");
                btn_next.setVisibility(View.GONE);
                btn_next_next.setVisibility(View.VISIBLE);
            }
        });
        btn_next_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                convo_mayari.setText("Look! Native Products and native puzzles! This looks interesting, can you solve it for me?");
                btn_next_next.setVisibility(View.GONE);
                btn_next.setVisibility(View.GONE);
                btn_okay.setVisibility(View.VISIBLE);
            }
        });

        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                convo_mayari.setText("Uhm. Ok, but it would be a waste if we don’t celebrate their festival. After all, this festival only happens once a year.");
                btn_yes.setVisibility(View.GONE);
                btn_no.setVisibility(View.GONE);
                btn_back.setVisibility(View.VISIBLE);
                btn_okay.setVisibility(View.VISIBLE);
            }
        });

        btn_okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                Intent in = new Intent(getApplicationContext(), problem9.class);
                startActivityForResult(in,0);
                overridePendingTransition(0,0);
                finish();
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                Intent in = new Intent(getApplicationContext(), NinthBG2.class);
                startActivityForResult(in,0);
                overridePendingTransition(0,0);
                finish();
            }
        });


        String path = "android.resource://"+getPackageName()+"/"+R.raw.tenth;
        Uri uri = Uri.parse(path);
        videoView.setVideoURI(uri);
        videoView.start();

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

        btn_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showdialog();
                soundEffect.NormalSound();
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