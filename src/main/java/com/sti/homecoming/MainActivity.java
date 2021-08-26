package com.sti.homecoming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private static int SPLASH_SCREEN = 4000;
    Animation top_anim;
    TextView logo;
    ImageView mayari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        top_anim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        logo = findViewById(R.id.txt_Title);
        mayari = findViewById(R.id.mayarito);
        logo.setAnimation(top_anim);
        mayari.setAnimation(top_anim);

      new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent in = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(in);
                finish();
            }
        },SPLASH_SCREEN);

    }
}