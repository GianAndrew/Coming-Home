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

public class problem3 extends AppCompatActivity {

    private TextView ans;
    private Button one, two, three, four, five, six, seven, eight, nine, zero, next;
    SoundEffect soundEffect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_problem3);

        soundEffect = new SoundEffect(this);
        assign();

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
                checking();
            }
        });
    }
    private void assign() {
        one = findViewById(R.id.p3b1);
        two = findViewById(R.id.p3b2);
        three = findViewById(R.id.p3b3);
        four = findViewById(R.id.p3b4);
        five = findViewById(R.id.p3b5);
        six = findViewById(R.id.p3b6);
        seven = findViewById(R.id.p3b7);
        eight = findViewById(R.id.p3b8);
        nine = findViewById(R.id.p3b9);
        zero = findViewById(R.id.p3b0);

        next = findViewById(R.id.p3confirm);

        ans = findViewById(R.id.p3answer);
    }
    private void checking() {
        int correct = 350, ans2;
        ans2 = Integer.parseInt(ans.getText().toString());

        Intent in = new Intent(problem3.this, SecondBG4.class);

        if(ans2 == correct) {
            soundEffect.CorrectAnswer();
            startActivityForResult(in,0);
            overridePendingTransition(0,0);
            finish();
        } else {
            soundEffect.WrongAnswer();
            ans.setText("");
            Toast.makeText(problem3.this, "Wrong Answer, Please try again.", Toast.LENGTH_SHORT).show();
        }
    }
}