package com.sti.homecoming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class problem13 extends AppCompatActivity {

    private Button b1, b2, b3, b4;
    private SoundEffect soundEffect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_problem13);


        // Declaration
        b1 = findViewById(R.id.floranteandlaura);
        b2 = findViewById(R.id.romeoandjuliet);
        b3 = findViewById(R.id.roseandjack);
        b4 = findViewById(R.id.aldenandmaine);
        soundEffect = new SoundEffect(this);

        // Function
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(problem13.this, "Wrong Answer, Please try again.", Toast.LENGTH_SHORT).show();
                b1.setBackgroundResource(R.drawable.red_btn);
                soundEffect.WrongAnswer();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(problem13.this, "Wrong Answer, Please try again.", Toast.LENGTH_SHORT).show();
                b2.setBackgroundResource(R.drawable.red_btn);
                soundEffect.WrongAnswer();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b3.setBackgroundResource(R.drawable.green_btn);
                soundEffect.CorrectAnswer();
                Intent in = new Intent(getApplicationContext(), TriviaNine.class);
                startActivityForResult(in,0);
                overridePendingTransition(0,0);
                finish();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(problem13.this, "Wrong Answer, Please try again.", Toast.LENGTH_SHORT).show();
                b4.setBackgroundResource(R.drawable.red_btn);
                soundEffect.WrongAnswer();
            }
        });
    }
    }
