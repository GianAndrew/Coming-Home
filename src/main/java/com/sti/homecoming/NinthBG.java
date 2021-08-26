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

public class NinthBG extends AppCompatActivity {

    private Button btn_next,btn_okay,btn_back, btn_yes,btn_no,okay_btn;
    private VideoView videoView;
    private TextView convo_mayari,txt_charac;
    private ImageButton btn_setting;
    private SoundEffect soundEffect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_ninth_b_g);

        soundEffect = new SoundEffect(this);
        btn_setting = findViewById(R.id.ninth_bg_imagebtn);
        convo_mayari = findViewById(R.id.txt_convo_ninthbg);
        txt_charac = findViewById(R.id.txt_charac_ninthbg);
        videoView = findViewById(R.id.ninthbg_video);
        btn_next = findViewById(R.id.btn_next_ninthbg);
        btn_okay = findViewById(R.id.btn_okay_ninthbg);
        btn_back = findViewById(R.id.btn_back_ninthbg);
        btn_yes = findViewById(R.id.btn_yes_ninthbg);
        btn_no = findViewById(R.id.btn_no_ninthbg);
        okay_btn = findViewById(R.id.btn_okay_okay_ninthbg);



        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                txt_charac.setText("Police: ");
                convo_mayari.setText("Mabuhay ma’am and sir! Can we inspect your vehicle for a moment?");
                btn_next.setVisibility(View.GONE);
                btn_okay.setVisibility(View.GONE);
                btn_back.setVisibility(View.GONE);
                btn_no.setVisibility(View.VISIBLE);
                btn_yes.setVisibility(View.VISIBLE);
            }
        });
        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                txt_charac.setText("Police: ");
                convo_mayari.setText("I’m so sorry ma’am and sir but we really need to inspect your car.");
                btn_no.setVisibility(View.GONE);
                btn_yes.setVisibility(View.GONE);
                btn_back.setVisibility(View.VISIBLE);
                btn_okay.setVisibility(View.VISIBLE);
            }
        });
        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                txt_charac.setText("Police: ");
                convo_mayari.setText("Very well then, it won’t take too long. ");
                btn_no.setVisibility(View.GONE);
                btn_yes.setVisibility(View.GONE);
                btn_back.setVisibility(View.VISIBLE);
                btn_okay.setVisibility(View.VISIBLE);
            }
        });

        btn_okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                txt_charac.setText("Police: ");
                convo_mayari.setText("We’re done! Thank you and enjoy our Festival!");
                btn_okay.setVisibility(View.GONE);
                okay_btn.setVisibility(View.VISIBLE);
            }
        });
        okay_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                    Intent in = new Intent(getApplicationContext(), NinthBG2.class);
                startActivityForResult(in,0);
                overridePendingTransition(0,0);
                finish();
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                Intent in = new Intent(getApplicationContext(), EightBG2.class);
                startActivityForResult(in,0);
                overridePendingTransition(0,0);
                finish();
            }
        });


        String path = "android.resource://"+getPackageName()+"/"+R.raw.ninth;
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