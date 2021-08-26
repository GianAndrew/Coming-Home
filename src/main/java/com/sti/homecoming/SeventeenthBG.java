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

public class SeventeenthBG extends AppCompatActivity {

    private Button btn_okay, btn_back,btn_next,btn_next_2,btn_next_3,btn_next_4,btn_next_5,btn_next_6;
    private VideoView videoView;
    private TextView convo_mayari,txt_charac;
    private ImageButton btn_setting;
    private SoundEffect soundEffect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_seventeenth_b_g);


        soundEffect = new SoundEffect(this);
        btn_setting = findViewById(R.id.seventeenth_bg_imagebtn);
        btn_okay = findViewById(R.id.btn_okay_seventeenthbg);
        btn_back = findViewById(R.id.btn_back_seventeenthbg);
        btn_next = findViewById(R.id.btn_next_seventeenthbg);
        btn_next_2 = findViewById(R.id.btn_next_2_seventeenthbg);
        btn_next_3 = findViewById(R.id.btn_next_4_seventeenthbg);
        btn_next_4 = findViewById(R.id.btn_next_4_seventeenthbg);
        btn_next_5 = findViewById(R.id.btn_next_5_seventeenthbg);
        btn_next_6 = findViewById(R.id.btn_next_6_seventeenthbg);
        videoView = findViewById(R.id.seventeenthbg_video);
        convo_mayari = findViewById(R.id.txt_convo_seventeenthbg);
        txt_charac = findViewById(R.id.txt_charac_seventeenthbg);

      btn_next.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              soundEffect.NormalSound();
              txt_charac.setText("Mayari: ");
              convo_mayari.setText("You’re welcome! Does the child has already a name?");
              btn_next.setVisibility(View.GONE);
              btn_next_2.setVisibility(View.VISIBLE);
          }
      });
      btn_next_2.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              soundEffect.NormalSound();
              txt_charac.setText("Luna: ");
              convo_mayari.setText("Yes, her name is Tala. Just like the stars shimmering in the night sky.");
              btn_next_2.setVisibility(View.GONE);
              btn_next_3.setVisibility(View.VISIBLE);
          }
      });
        btn_next_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                txt_charac.setText("Mayari: ");
                convo_mayari.setText("Aw! What a lovely name! I really hope that this child will grow healthy. By the way, we need to take our leave now. Goodbye and rest well!");
                btn_next_3.setVisibility(View.GONE);
                btn_next_4.setVisibility(View.VISIBLE);
            }
        });
        btn_next_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                txt_charac.setText("Luna: ");
                convo_mayari.setText("Oh! Once again, thank you and have a nice trip.");
                btn_next_4.setVisibility(View.GONE);
                btn_next_5.setVisibility(View.VISIBLE);
            }
        });
        btn_next_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                txt_charac.setText("Mayari: ");
                convo_mayari.setText("Thank you!");
                btn_next_5.setVisibility(View.GONE);
                btn_okay.setVisibility(View.VISIBLE);
            }
        });
        btn_okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                Intent in = new Intent(getApplicationContext(), SeventeenthBG2.class);
                startActivityForResult(in,0);
                overridePendingTransition(0,0);
                finish();
            }
        });



        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                Intent in = new Intent(getApplicationContext(), SixteenthBG.class);
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

        String path = "android.resource://"+getPackageName()+"/"+R.raw.seventeenth;
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