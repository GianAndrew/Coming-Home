package com.sti.homecoming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class problem10 extends AppCompatActivity {

    private TextView ans;
    private Button one, two, three, four, five, six, seven, eight, nine, zero, next;
    private SoundEffect soundEffect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_problem10);

        one = findViewById(R.id.p10b1);
        two = findViewById(R.id.p10b2);
        three = findViewById(R.id.p10b3);
        four = findViewById(R.id.p10b4);
        five = findViewById(R.id.p10b5);
        six = findViewById(R.id.p10b6);
        seven = findViewById(R.id.p10b7);
        eight = findViewById(R.id.p10b8);
        nine = findViewById(R.id.p10b9);
        zero = findViewById(R.id.p10b0);

        next = findViewById(R.id.p10confirm);
        soundEffect = new SoundEffect(this);
        ans = findViewById(R.id.p10answer);


        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.SingleType();
                ans.setText(ans.getText().toString() + "1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.SingleType();
                ans.setText(ans.getText().toString() + "2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.SingleType();
                ans.setText(ans.getText().toString() + "3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.SingleType();
                ans.setText(ans.getText().toString() + "4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.SingleType();
                ans.setText(ans.getText().toString() + "5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.SingleType();
                ans.setText(ans.getText().toString() + "6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.SingleType();
                ans.setText(ans.getText().toString() + "7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.SingleType();
                ans.setText(ans.getText().toString() + "8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.SingleType();
                ans.setText(ans.getText().toString() + "9");
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.SingleType();
                ans.setText(ans.getText().toString() + "0");
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                checking();
            }
        });
    }

    private void checking() {
        int correct = 224, ans2;
        ans2 = Integer.parseInt(ans.getText().toString());

        Intent i = new Intent(problem10.this, TenthBG3.class);

        if (ans2 == correct) {
            soundEffect.CorrectAnswer();
            startActivity(i);
            finish();
        } else {
            soundEffect.WrongAnswer();
            ans.setText("");
            Toast.makeText(problem10.this, "Wrong Answer, Please try again.", Toast.LENGTH_SHORT).show();
        }
    }
}