package com.sti.homecoming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class Instructions extends AppCompatActivity {

    TextView title, text;
    Button next, con;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_instructions);


        // Declaration
        title = findViewById(R.id.instruct);
        text = findViewById(R.id.mechanics);
        next = findViewById(R.id.next);
        con = findViewById(R.id.con);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title.setText("Warning!");
                text.setText("Exiting the app means you will lost your progress in the story. \n\nIf you exit the app, you'll need to start over again. \n\nGoodluck and have fun!");
                next.setVisibility(View.GONE);
                con.setVisibility(View.VISIBLE);
            }
        });

        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Instructions.this, FirstBG.class);
                startActivityForResult(in,0);
                overridePendingTransition(0,0);
                finish();
            }
        });
    }
}