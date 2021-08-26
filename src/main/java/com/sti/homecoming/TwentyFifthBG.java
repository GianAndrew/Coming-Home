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

public class TwentyFifthBG extends AppCompatActivity {


    private Button btn_okay, btn_back, btn_next,btn_next_2,btn_next_3,btn_next_4,btn_next_5;
    private VideoView videoView;
    private TextView convo_mayari,txt_charac;
    private ImageButton btn_setting;
    private SoundEffect soundEffect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_twenty_fifth_b_g);


        soundEffect = new SoundEffect(this);
        btn_setting = findViewById(R.id.twentyfifth_bg_imagebtn);
        btn_okay = findViewById(R.id.btn_okay_twentyfifthbg);
        btn_back = findViewById(R.id.btn_back_twentyfifthbg);
        btn_next = findViewById(R.id.btn_next_twentyfifthbg);
        btn_next_2 = findViewById(R.id.btn_next_2_twentyfifthbg);
        btn_next_3 = findViewById(R.id.btn_next_3_twentyfifthbg);
        btn_next_4 = findViewById(R.id.btn_next_4_twentyfifthbg);
        btn_next_5 = findViewById(R.id.btn_next_5_twentyfifthbg);
        videoView = findViewById(R.id.twentyfifthbg_video);
        convo_mayari = findViewById(R.id.txt_convo_twentyfifthbg);
        txt_charac = findViewById(R.id.txt_charac_twentyfifthbg);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                txt_charac.setText("Mayari: ");
                convo_mayari.setText("Hanan! Yes it’s been a while! How are you?");
                btn_next.setVisibility(View.GONE);
                btn_next_2.setVisibility(View.VISIBLE);
            }
        });
        btn_next_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                txt_charac.setText("Hanan: ");
                convo_mayari.setText("Well, I’m living a good life. How about you? I thought you won’t come back after all the things happened in the past.");
                btn_next_2.setVisibility(View.GONE);
                btn_next_3.setVisibility(View.VISIBLE);
            }
        });
        btn_next_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                txt_charac.setText("Mayari: ");
                convo_mayari.setText("Actually I’m here to face my past. By the way, this is Hanan, my younger sister. this person help me to travel back here.");
                btn_next_3.setVisibility(View.GONE);
                btn_next_4.setVisibility(View.VISIBLE);
            }
        });
        btn_next_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                txt_charac.setText("Hanan: ");
                convo_mayari.setText("Nice to meet you! I’m Hanan, Mayari’s younger sister. Thank you for accompanying my sister to come back home and help her face her fears and trauma.");
                btn_next_4.setVisibility(View.GONE);
                btn_next_5.setVisibility(View.VISIBLE);
            }
        });
        btn_next_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                txt_charac.setText("Mayari: ");
                convo_mayari.setText("I told you last night that my name came from the Philippine Deity of Moon. Can you guess the meaning of my sister’s name?");
                btn_next_5.setVisibility(View.GONE);
                btn_okay.setVisibility(View.VISIBLE);
            }
        });


        btn_okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                Intent in = new Intent(getApplicationContext(), problem17.class);
                startActivityForResult(in,0);
                overridePendingTransition(0,0);
                finish();
            }
        });


        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                Intent in = new Intent(getApplicationContext(), TwentyFourBG.class);
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

        String path = "android.resource://"+getPackageName()+"/"+R.raw.twenty_fifth;
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