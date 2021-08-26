package com.sti.homecoming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TriviaOne extends AppCompatActivity {


    ImageView imageO, imageI;
    TextView triv;
    Button btn_nxt, btn_conf;
    SoundEffect soundEffect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_trivia_one);

        soundEffect = new SoundEffect(this);

        btn_nxt = findViewById(R.id.btn_next);
        btn_conf = findViewById(R.id.btn_conf);
        imageO = findViewById(R.id.breadOne);
        imageI = findViewById(R.id.breadTwo);
        triv = findViewById(R.id.txtdefinition);

        //
        btn_nxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                btn_nxt.setVisibility(View.GONE);
                btn_conf.setVisibility(View.VISIBLE);
                triv.setText("Meanwhile, “Pandesal” is the most common bread roll in the Philippines that you can buy in almost every bakery.");
                imageO.setVisibility(View.VISIBLE);
                imageI.setVisibility(View.INVISIBLE);
            }
        });
        btn_conf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEffect.NormalSound();
                Intent in = new Intent(TriviaOne.this, ThirdBG.class);
                startActivityForResult(in,0);
                overridePendingTransition(0,0);
                finish();
            }
        });
    }
}