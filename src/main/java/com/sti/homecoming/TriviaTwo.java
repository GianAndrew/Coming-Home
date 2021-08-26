package com.sti.homecoming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class TriviaTwo extends AppCompatActivity {

    Button btn_nxt;
    SoundEffect soundEffect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_trivia_two);

        btn_nxt = findViewById(R.id.btn_next);
        soundEffect = new SoundEffect(this);

        //Function
        btn_nxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                Intent in = new Intent(TriviaTwo.this, ThirdBG3.class);
                startActivityForResult(in,0);
                overridePendingTransition(0,0);
                finish();
            }
        });
    }
}