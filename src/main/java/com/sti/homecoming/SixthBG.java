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

public class SixthBG extends AppCompatActivity {

    private Button btn_next,btn_okay,btn_back;
    private VideoView videoView;
    private TextView convo_mayari;
    private ImageButton btn_setting;
    private SoundEffect soundEffect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sixth_b_g);

        //Declartion
         soundEffect = new SoundEffect(this);
         btn_back = findViewById(R.id.btn_back_sixthbg);
         btn_next = findViewById(R.id.btn_next_sixthbg);
         btn_okay = findViewById(R.id.btn_okay_sixthbg);
         btn_setting = findViewById(R.id.sixth_bg_imagebtn);
         convo_mayari = findViewById(R.id.txt_convo_sixthbg);
         videoView = findViewById(R.id.sixthbg_video);

         // Function

        String path = "android.resource://"+getPackageName()+"/"+R.raw.seventh;
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
                convo_mayari.setText("I???ll go to my room now and rest. Goodnight! See you tomorrow");
                btn_next.setVisibility(View.GONE);
                btn_okay.setVisibility(View.VISIBLE);
            }
        });
        btn_okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                Intent in = new Intent(getApplicationContext(), SeventhBG.class);
                startActivityForResult(in,0);
                overridePendingTransition(0,0);
                finish();
            }
        });



         btn_back.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 soundEffect.NormalSound();
                 Intent in = new Intent(getApplicationContext(), FifthBG2.class);
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