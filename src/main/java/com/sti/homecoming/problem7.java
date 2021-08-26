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

public class problem7 extends AppCompatActivity {

    private TextView txtedit1;
    private Button submit, btn_l,btn_o,btn_v,btn_e;
    private SoundEffect soundEffect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_problem7);

        txtedit1 = findViewById(R.id.p7edit);
        submit = findViewById(R.id.p7submit);
        soundEffect = new SoundEffect(this);
        btn_l = findViewById(R.id.btn_l);
        btn_o = findViewById(R.id.btn_o);
        btn_v = findViewById(R.id.btn_v);
        btn_e = findViewById(R.id.btn_e);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checking();
            }
        });
        btn_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.SingleType();
                txtedit1.setText(txtedit1.getText().toString()+"L");
            }
        });
        btn_o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.SingleType();
                txtedit1.setText(txtedit1.getText().toString()+"O");
            }
        });
        btn_v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.SingleType();
                txtedit1.setText(txtedit1.getText().toString()+"V");
            }
        });
        btn_e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.SingleType();
                txtedit1.setText(txtedit1.getText().toString()+"E");
            }
        });

    }

    public void checking() {
        Intent i = new Intent(problem7.this, EightBG2.class);

        String ans1 = "Love", ans;
        ans = txtedit1.getText().toString();

        if (ans.equalsIgnoreCase(ans1)) {
            soundEffect.CorrectAnswer();
            startActivity(i);
            finish();
        }
        else {
            soundEffect.WrongAnswer();
            txtedit1.setText("");
            Toast.makeText(problem7.this, "Wrong Answer, Please try again.", Toast.LENGTH_SHORT).show();
        }
    }
}