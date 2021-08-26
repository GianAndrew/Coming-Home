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

public class FourthBG4 extends AppCompatActivity {

    Button Yes_btn, No_btn;
    ImageButton btn_settings;
    TextView convo_mayari;
    SoundEffect soundEffect;
    VideoView videoView;
    Button okay_btn, back_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_fourth_b_g4);

        //Declaration
        soundEffect = new SoundEffect(this);
        Yes_btn = findViewById(R.id.btn_Yes_fourthbg3);
        No_btn = findViewById(R.id.btn_No_fourthbg3);
        btn_settings = findViewById(R.id.btn_menu);
        convo_mayari = findViewById(R.id.txt_convo_fourthbg3);
        okay_btn = findViewById(R.id.btn_okay_fourthbg3);
        back_btn = findViewById(R.id.btn_back_fourthbg3);
        videoView = findViewById(R.id.fourth_bg3_video);

        String path = "android.resource://" + getPackageName() + "/" + R.raw.fifth;
        Uri uri = Uri.parse(path);
        videoView.setVideoURI(uri);
        videoView.start();

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });


        //Functions
        btn_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                showdialog();
            }
        });

        //if yes
        okay_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                Intent in = new Intent(FourthBG4.this, FifthBG.class);
                startActivityForResult(in, 0);
                overridePendingTransition(0, 0);
                finish();
            }
        });
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                Intent in = new Intent(FourthBG4.this, FourthBG3.class);
                startActivityForResult(in, 0);
                overridePendingTransition(0, 0);
                finish();
            }
        });


    }

    public void showdialog() {

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
                startActivityForResult(in, 0);
                overridePendingTransition(0, 0);
                finish();
            }
        });
        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.restartSounds();
                Intent in = new Intent(getApplicationContext(), HomeActivity.class);
                startActivityForResult(in, 0);
                overridePendingTransition(0, 0);
                finish();
            }
        });

        dialog.show();

    }

    @Override
    protected void onResume() {
        videoView.resume();
        videoView.start();
        super.onResume();
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
