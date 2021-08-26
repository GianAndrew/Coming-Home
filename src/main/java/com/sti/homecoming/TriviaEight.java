package com.sti.homecoming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class TriviaEight extends AppCompatActivity {

    private Button okay_btn;
    private SoundEffect soundEffect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_trivia_eight);

        soundEffect = new SoundEffect(this);

        okay_btn = findViewById(R.id.trivia_btn_eight);
        okay_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                Intent in = new Intent(getApplicationContext(), EighteenthBG.class);
                startActivityForResult(in,0);
                overridePendingTransition(0,0);
                finish();
            }
        });
    }
}