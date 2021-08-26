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

public class ThirteenthBG extends AppCompatActivity {


    private Button btn_okay,btn_back,btn_next,btn_next_2,btn_next_3,btn_next_4,btn_next_5,btn_next_6;
    private VideoView videoView;
    private TextView convo_mayari;
    private ImageButton btn_setting;
    private SoundEffect soundEffect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_thirteenth_b_g);


        soundEffect = new SoundEffect(this);
        btn_setting = findViewById(R.id.thirteen_bg_imagebtn);
        convo_mayari = findViewById(R.id.txt_convo_thirteenbg);
        btn_next = findViewById(R.id.btn_next_thirteenbg);
        btn_next_2 = findViewById(R.id.btn_next_2_thirteenbg);
        btn_next_3 = findViewById(R.id.btn_next_3_thirteenbg);
        btn_next_4 = findViewById(R.id.btn_next_4_thirteenbg);
        btn_next_5 = findViewById(R.id.btn_next_5_thirteenbg);
        btn_next_6 = findViewById(R.id.btn_next_6_thirteenbg);
        btn_okay = findViewById(R.id.btn_okay_thirteenbg);
        btn_back = findViewById(R.id.btn_back_thirteenbg);
        videoView = findViewById(R.id.thirteenbg_video);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                convo_mayari.setText("Yes, I’m tired but after seeing the culture and native products in that festival a while ago, I suddenly reminisced the memories of my younger self.");
                btn_next.setVisibility(View.GONE);
                btn_next_2.setVisibility(View.VISIBLE);
            }
        });
        btn_next_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                convo_mayari.setText("When I was a kid, my family is not that rich but I can say that they gave me a perfect life, just like that perfect cone shaped volcano (Mount Mayon). ");
                btn_next_2.setVisibility(View.GONE);
                btn_next_3.setVisibility(View.VISIBLE);
            }
        });
        btn_next_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                convo_mayari.setText("But everything changed when I became a university student. I met many people that brought me lots of problems and trauma. ");
                btn_next_3.setVisibility(View.GONE);
                btn_next_4.setVisibility(View.VISIBLE);
            }
        });
        btn_next_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                convo_mayari.setText("During that time, I lost a lot of people close to me.");
                btn_next_4.setVisibility(View.GONE);
                btn_next_5.setVisibility(View.VISIBLE);
            }
        });
        btn_next_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                convo_mayari.setText("That’s why I travelled far, away from my home. Also, that is the reason why I don’t have any courage to go back home, but thanks to you, I can now come back home.");
                btn_next_5.setVisibility(View.GONE);
                btn_next_6.setVisibility(View.VISIBLE);
            }
        });

        btn_next_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                convo_mayari.setText("*sighs* I really wish my life is as perfect as Mt. Mayon. Enough with the drama, I’m going to rest now. Goodnight and see you tomorrow!");
                btn_next_6.setVisibility(View.GONE);
                btn_okay.setVisibility(View.VISIBLE);
            }
        });
        btn_okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                Intent in = new Intent(getApplicationContext(), TriviaSix.class);
                startActivityForResult(in,0);
                overridePendingTransition(0,0);
                finish();
            }
        });



        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                Intent in = new Intent(getApplicationContext(), TwelveBG.class);
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



        String path = "android.resource://"+getPackageName()+"/"+R.raw.thirteenth;
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