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

public class FourteenthBG2 extends AppCompatActivity {

    private Button btn_okay,btn_back,btn_next, btn_next_2,btn_next_3,btn_next_4,btn_next_5,btn_next_6,btn_next_7,btn_next_8;
    private VideoView videoView;
    private TextView convo_mayari,txt_charac;
    private ImageButton btn_setting;
    private SoundEffect soundEffect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_fourteenth_b_g2);


        soundEffect = new SoundEffect(this);
        btn_setting = findViewById(R.id.fourteenth_bg2_imagebtn);
        convo_mayari = findViewById(R.id.txt_convo_fourteenthbg2);
        btn_next = findViewById(R.id.btn_next_fourteenthbg2);
        btn_next_2 = findViewById(R.id.btn_next_2_fourteenthbg2);
        btn_next_3 = findViewById(R.id.btn_next_3_fourteenthbg2);
        btn_next_4 = findViewById(R.id.btn_next_4_fourteenthbg2);
        btn_next_5 = findViewById(R.id.btn_next_5_fourteenthbg2);
        btn_next_6 = findViewById(R.id.btn_next_6_fourteenthbg2);
        btn_next_7 = findViewById(R.id.btn_next_7_fourteenthbg2);
        btn_next_8 = findViewById(R.id.btn_next_8_fourteenthbg2);
        btn_okay = findViewById(R.id.btn_okay_fourteenthbg2);
        btn_back = findViewById(R.id.btn_back_fourteenthbg2);
        txt_charac = findViewById(R.id.txt_charac_fourteenthbg2);
        videoView = findViewById(R.id.fourteenthbg2_video);


        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                convo_mayari.setText("*noticed something* Uhm, excuse me? How many months you’re pregnant?");
                btn_next.setVisibility(View.GONE);
                btn_next_2.setVisibility(View.VISIBLE);
            }
        });
        btn_next_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                txt_charac.setText("???: ");
                convo_mayari.setText("Ah, I’m 9 months pregnant with this child. Actually, anytime this month this baby will be born.");
                btn_next_2.setVisibility(View.GONE);
                btn_next_3.setVisibility(View.VISIBLE);
            }
        });
        btn_next_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                txt_charac.setText("Mayari: ");
                convo_mayari.setText("Oh that’s great! Hi I am Mayari! I hope that you and your baby is healthy!");
                btn_next_3.setVisibility(View.GONE);
                btn_next_4.setVisibility(View.VISIBLE);
            }
        });
        btn_next_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                txt_charac.setText("???: ");
                convo_mayari.setText("Oh thank you! Hi, I am Luna!");
                btn_next_4.setVisibility(View.GONE);
                btn_next_5.setVisibility(View.VISIBLE);
            }
        });
        btn_next_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                txt_charac.setText("Mayari: ");
                convo_mayari.setText("Nice to meet you! I am really envious, long ago I was once pregnant too. But for some reasons, I lost my baby midway.");
                btn_next_5.setVisibility(View.GONE);
                btn_next_6.setVisibility(View.VISIBLE);
            }
        });

        btn_next_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                txt_charac.setText("Luna: ");
                convo_mayari.setText("Oh I’m so sorry for your lost.");
                btn_next_6.setVisibility(View.GONE);
                btn_next_7.setVisibility(View.VISIBLE);
            }
        });
        btn_next_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                txt_charac.setText("Mayari: ");
                convo_mayari.setText("That’s okay, it’s already been a long time.");
                btn_next_7.setVisibility(View.GONE);
                btn_next_8.setVisibility(View.VISIBLE);
            }
        });
        btn_next_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                txt_charac.setText("");
                convo_mayari.setText("Mayari and Luna are having a long conversation, until…");
                btn_next_8.setVisibility(View.GONE);
                btn_okay.setVisibility(View.VISIBLE);
            }
        });
        btn_okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                Intent in = new Intent(getApplicationContext(), FourteenthBG3.class);
                startActivityForResult(in,0);
                overridePendingTransition(0,0);
                finish();
            }
        });



        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                Intent in = new Intent(getApplicationContext(), Fourteenth.class);
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

        String path = "android.resource://"+getPackageName()+"/"+R.raw.fourteenth_one;
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