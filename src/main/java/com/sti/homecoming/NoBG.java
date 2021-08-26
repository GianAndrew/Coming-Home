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

public class NoBG extends AppCompatActivity {

    ImageButton btn_setting;
    Button btn_next, btn_main;
    TextView convo;
    SoundEffect soundEffect;
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_no_b_g);

        soundEffect = new SoundEffect(this);
        btn_main = findViewById(R.id.btn_Mainmenu);
        btn_next = findViewById(R.id.nobtn_next);
        btn_setting = findViewById(R.id.btn_menu_nobg);
        convo = findViewById(R.id.txt_convo);
        videoView = findViewById(R.id.no_bg_video);

        String path = "android.resource://"+getPackageName()+"/"+R.raw.first_two;
        Uri uri = Uri.parse(path);
        videoView.setVideoURI(uri);
        videoView.start();

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                btn_next.setVisibility(View.GONE);
                btn_main.setVisibility(View.VISIBLE);
            }
        });
        btn_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                Intent in = new Intent(NoBG.this, MainActivity.class);
                startActivity(in);
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
                Intent in = new Intent(NoBG.this, FirstBG.class);
                startActivity(in);
                finish();
            }
        });
        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.restartSounds();
                Intent in = new Intent(NoBG.this, HomeActivity.class);
                startActivity(in);
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