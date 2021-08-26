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

public class NineteenthBG2 extends AppCompatActivity {

    private Button btn_okay, btn_back, btn_next, btn_next_1, btn_next_1_1, btn_next_2, btn_next_2_1, btn_next_3, btn_next_4, btn_next_5, btn_next_6, btn_next_7, btn_next_8, btn_next_9, btn_next_10, btn_next_11;
    private VideoView videoView;
    private TextView convo_mayari, txt_charac;
    private ImageButton btn_setting;
    private SoundEffect soundEffect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_nineteenth_b_g2);

        soundEffect = new SoundEffect(this);
        btn_setting = findViewById(R.id.nineteenth_bg2_imagebtn);
        btn_okay = findViewById(R.id.btn_okay_nineteenthbg2);
        btn_back = findViewById(R.id.btn_back_nineteenthbg2);
        videoView = findViewById(R.id.nineteenthbg2_video);
        convo_mayari = findViewById(R.id.txt_convo_nineteenthbg2);
        txt_charac = findViewById(R.id.txt_charac_nineteenthbg2);

        btn_next = findViewById(R.id.btn_next_nineteenthbg2);
        btn_next_1 = findViewById(R.id.btn_next_1_nineteenthbg2);
        btn_next_1_1 = findViewById(R.id.btn_next_1_1_nineteenthbg2);
        btn_next_2 = findViewById(R.id.btn_next_2_nineteenthbg2);
        btn_next_2_1 = findViewById(R.id.btn_next_2_1_nineteenthbg2);
        btn_next_3 = findViewById(R.id.btn_next_3_nineteenthbg2);
        btn_next_4 = findViewById(R.id.btn_next_4_nineteenthbg2);
        btn_next_5 = findViewById(R.id.btn_next_5_nineteenthbg2);
        btn_next_6 = findViewById(R.id.btn_next_6_nineteenthbg2);
        btn_next_7 = findViewById(R.id.btn_next_7_nineteenthbg2);
        btn_next_8 = findViewById(R.id.btn_next_8_nineteenthbg2);
        btn_next_9 = findViewById(R.id.btn_next_9_nineteenthbg2);
        btn_next_10 = findViewById(R.id.btn_next_10_nineteenthbg2);
        btn_next_11 = findViewById(R.id.btn_next_11_nineteenthbg2);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                convo_mayari.setText("I’ve already told you that I was once a university student, and there I met my ex.");
                btn_next.setVisibility(View.GONE);
                btn_next_1.setVisibility(View.VISIBLE);

            }
        });
        btn_next_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                convo_mayari.setText("I also said that, I was once pregnant right? But unfortunately my baby died before he was born due to some accident.");
                btn_next_1.setVisibility(View.GONE);
                btn_next_1_1.setVisibility(View.VISIBLE);

            }
        });
        btn_next_1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                convo_mayari.setText("Actually, it was our ex’s first baby and we were happy to know that I’m pregnant, but it’s not the case with my parents.");
                btn_next_1_1.setVisibility(View.GONE);
                btn_next_2.setVisibility(View.VISIBLE);

            }
        });
        btn_next_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                convo_mayari.setText("After knowing that I’m pregnant, my parents forbid me to meet my ex and forced me to undergone abortion because I’m very young at that time and they can’t trust my ex.");
                btn_next_2.setVisibility(View.GONE);
                btn_next_2_1.setVisibility(View.VISIBLE);
            }
        });
        btn_next_2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                convo_mayari.setText("At first, I disobeyed but then one day, I suddenly woke up at a hospital knowing that my baby is already gone.");
                btn_next_2_1.setVisibility(View.GONE);
                btn_next_3.setVisibility(View.VISIBLE);
            }
        });
        btn_next_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                convo_mayari.setText("I was really frustrated and sad at that time. And in the same day, my ex knew the situation, he rushed over to the hospital and both of us asked my parents why? They said that we are still young, and we can’t even raise the kid.");
                btn_next_3.setVisibility(View.GONE);
                btn_next_4.setVisibility(View.VISIBLE);
            }
        });
        btn_next_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                convo_mayari.setText("I was just crying heavily back then, and my ex is furious to the point he picked up a gun, gone wild and almost killed my parents.");
                btn_next_4.setVisibility(View.GONE);
                btn_next_5.setVisibility(View.VISIBLE);
            }
        });

        btn_next_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                convo_mayari.setText("And due to his uncontrollable actions, the security guard has no choice but to shoot him. With my very own eyes, I saw an awful situation that caused me to have traumas with guns.");
                btn_next_5.setVisibility(View.GONE);
                btn_next_6.setVisibility(View.VISIBLE);

            }
        });
        btn_next_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                convo_mayari.setText("Tragic right? I lost 2 of my precious persons at the same day. The perfect future life with my new family I’ve dreamt had vanished in an instant.");
                btn_next_6.setVisibility(View.GONE);
                btn_next_7.setVisibility(View.VISIBLE);
            }
        });
        btn_next_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                convo_mayari.setText("By that time, I almost committed suicide not only because I lost the 2 of them, but also because of the unbearable pain and trauma I experienced. ");
                btn_next_7.setVisibility(View.GONE);
                btn_next_8.setVisibility(View.VISIBLE);
            }
        });
        btn_next_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                convo_mayari.setText("Instead of committing suicide, I just left home and went to a far place to collect my thoughts. Little did I know that after I left my home, I lost my courage to come back home. ");
                btn_next_8.setVisibility(View.GONE);
                btn_next_9.setVisibility(View.VISIBLE);
            }
        });
        btn_next_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                convo_mayari.setText("But now thanks to you, I think I can now face my fears and live a better life.");
                btn_next_9.setVisibility(View.GONE);
                btn_next_10.setVisibility(View.VISIBLE);
            }
        });
        btn_next_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                convo_mayari.setText("Thank you for listening to my story, I feel better now, but let me go to my room first to calm down first. See you later.");
                btn_next_10.setVisibility(View.GONE);
                btn_next_11.setVisibility(View.VISIBLE);
            }
        });

        btn_next_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                txt_charac.setText("");
                convo_mayari.setText("Mayari walks away and went to her room");
                btn_next_11.setVisibility(View.GONE);
                btn_okay.setVisibility(View.VISIBLE);
            }
        });

        btn_okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                Intent in = new Intent(getApplicationContext(), TwentiethBG.class);
                startActivityForResult(in, 0);
                overridePendingTransition(0, 0);
                finish();
            }
        });


        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                Intent in = new Intent(getApplicationContext(), NineteenthBG.class);
                startActivityForResult(in, 0);
                overridePendingTransition(0, 0);
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

        String path = "android.resource://" + getPackageName() + "/" + R.raw.ninteenth;
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