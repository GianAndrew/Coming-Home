package com.sti.homecoming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class problem4 extends AppCompatActivity {

    private Button b1, b2, b3;
    SoundEffect soundEffect;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_problem4);

        soundEffect = new SoundEffect(this);

        b1 = findViewById(R.id.p4b1);
        b2 = findViewById(R.id.p4b2);
        b3 = findViewById(R.id.p4b3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.WrongAnswer();
                b1.setBackgroundResource(R.drawable.red_btn);
                Toast.makeText(problem4.this, "Wrong Answer, Please try again.", Toast.LENGTH_SHORT).show();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.WrongAnswer();
                b2.setBackgroundResource(R.drawable.red_btn);
                Toast.makeText(problem4.this, "Wrong Answer, Please try again.", Toast.LENGTH_SHORT).show();

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.CorrectAnswer();
                b3.setBackgroundResource(R.drawable.green_btn);
                Intent in = new Intent(problem4.this, ThirdBG2.class);
                startActivityForResult(in,0);
                overridePendingTransition(0,0);
                finish();
            }
        });
    }


}