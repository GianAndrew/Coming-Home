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

public class problem20 extends AppCompatActivity {


    private TextView txtedit1;
    private Button submit, btn_d,btn_e,btn_a,btn_t,btn_h;
    private SoundEffect soundEffect;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_problem20);

        txtedit1 = findViewById(R.id.p20edit);
        submit = findViewById(R.id.p20submit);
        soundEffect = new SoundEffect(this);
        btn_d = findViewById(R.id.btn_d);
        btn_e = findViewById(R.id.btn_e);
        btn_a = findViewById(R.id.btn_a);
        btn_t = findViewById(R.id.btn_t);
        btn_h = findViewById(R.id.btn_h);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checking();
            }
        });
        btn_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.SingleType();
                txtedit1.setText(txtedit1.getText().toString()+"D");
            }
        });
        btn_e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.SingleType();
                txtedit1.setText(txtedit1.getText().toString()+"E");
            }
        });
        btn_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.SingleType();
                txtedit1.setText(txtedit1.getText().toString()+"A");
            }
        });
        btn_t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.SingleType();
                txtedit1.setText(txtedit1.getText().toString()+"T");
            }
        });
        btn_h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.SingleType();
                txtedit1.setText(txtedit1.getText().toString()+"H");
            }
        });

    }
    public void checking() {
        Intent i = new Intent(problem20.this, TwentyEighthBG4.class);

        String ans1 = "death", ans;
        ans = txtedit1.getText().toString();

        if (ans.equalsIgnoreCase(ans1)) {
            soundEffect.CorrectAnswer();
            startActivity(i);
            finish();
        }
        else {
            soundEffect.WrongAnswer();
            txtedit1.setText("");
            Toast.makeText(problem20.this, "Wrong Answer, Please try again.", Toast.LENGTH_SHORT).show();
        }
    }
}