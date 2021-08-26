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

public class TwentiethBG3 extends AppCompatActivity {

    private Button btn_okay, btn_back,btn_next,btn_next_2,btn_next_3,btn_no,btn_ok;
    private VideoView videoView;
    private TextView convo_mayari,txt_charac;
    private ImageButton btn_setting;
    private SoundEffect soundEffect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_twentieth_b_g3);


        soundEffect = new SoundEffect(this);
        btn_setting = findViewById(R.id.twenteith_bg3_imagebtn);
        btn_okay = findViewById(R.id.btn_okay_twenteithbg3);
        btn_back = findViewById(R.id.btn_back_twenteithbg3);
        btn_next = findViewById(R.id.btn_next_twenteithbg3);
        btn_next_2 = findViewById(R.id.btn_next_2_twenteithbg3);
        btn_next_3 = findViewById(R.id.btn_next_3_twenteithbg3);
        btn_no = findViewById(R.id.btn_no_twenteithbg3);
        btn_ok = findViewById(R.id.btn_ok_twenteithbg3);
        videoView = findViewById(R.id.twenteithbg3_video);
        convo_mayari = findViewById(R.id.txt_convo_twenteithbg3);
        txt_charac = findViewById(R.id.txt_charac_twenteithbg3);


        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                txt_charac.setText("");
                convo_mayari.setText("You informed Mayari that the remaining fuel of the car is not enough for longer rides.");
                btn_next.setVisibility(View.GONE);
                btn_next_2.setVisibility(View.VISIBLE);
            }
        });
        btn_next_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                txt_charac.setText("Mayari: ");
                convo_mayari.setText("Ow ok! Let’s go to the oil station first and refuel the car. How about that?");
                btn_next_2.setVisibility(View.GONE);
                btn_back.setVisibility(View.GONE);
                btn_no.setVisibility(View.VISIBLE);
                btn_ok.setVisibility(View.VISIBLE);
            }
        });
        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                txt_charac.setText("Mayari: ");
                convo_mayari.setText("How are we supposed to travel if the remaining fuel is not enough for longer rides? Don’t worry I’ll pay for the fuel.");
                btn_no.setVisibility(View.GONE);
                btn_ok.setVisibility(View.GONE);
                btn_back.setVisibility(View.VISIBLE);
                btn_okay.setVisibility(View.VISIBLE);
            }
        });
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                txt_charac.setText("Mayari: ");
                convo_mayari.setText("What are we waiting for? Let’s go and refuel the car.");
                btn_no.setVisibility(View.GONE);
                btn_ok.setVisibility(View.GONE);
                btn_back.setVisibility(View.VISIBLE);
                btn_okay.setVisibility(View.VISIBLE);
            }
        });
        btn_okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                Intent in = new Intent(getApplicationContext(), TwentyFirstBG.class);
                startActivityForResult(in,0);
                overridePendingTransition(0,0);
                finish();
            }
        });


        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                Intent in = new Intent(getApplicationContext(), TwentiethBG2.class);
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

        String path = "android.resource://"+getPackageName()+"/"+R.raw.eighteenth;
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