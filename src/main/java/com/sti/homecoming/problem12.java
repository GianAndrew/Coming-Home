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

public class problem12 extends AppCompatActivity {

    private TextView txtedit1;
    private Button submit, btn_12,btn_7,btn_6,btn_14;
    private SoundEffect soundEffect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_problem12);


        txtedit1 = findViewById(R.id.p12edit);
        submit = findViewById(R.id.p12submit);
        soundEffect = new SoundEffect(this);
        btn_12 = findViewById(R.id.btn_12);
        btn_7 = findViewById(R.id.btn_7);
        btn_6 = findViewById(R.id.btn_6);
        btn_14 = findViewById(R.id.btn_14);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checking();
            }
        });
        btn_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.SingleType();
                txtedit1.setText(txtedit1.getText().toString()+"12");
            }
        });
        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.SingleType();
                txtedit1.setText(txtedit1.getText().toString()+"7");
            }
        });
        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.SingleType();
                txtedit1.setText(txtedit1.getText().toString()+"6");
            }
        });
        btn_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.SingleType();
                txtedit1.setText(txtedit1.getText().toString()+"14");
            }
        });

    }

    public void checking() {
        Intent i = new Intent(problem12.this, SixteenthBG2.class);

        String ans1 = "7", ans;
        ans = txtedit1.getText().toString();

        if (ans.equalsIgnoreCase(ans1)) {
            soundEffect.CorrectAnswer();
            startActivity(i);
            finish();
        }
        else {
            soundEffect.WrongAnswer();
            txtedit1.setText("");
            Toast.makeText(problem12.this, "Wrong Answer, Please try again.", Toast.LENGTH_SHORT).show();
        }
    }
    }
