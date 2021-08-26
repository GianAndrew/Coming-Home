package com.sti.homecoming;

import android.content.Context;
import android.media.MediaPlayer;

public class SoundEffect {

    private MediaPlayer mediaPlayer;
    private Context context;

    public SoundEffect(Context context){
        this.context = context;
    }
    public void NormalSound(){

        mediaPlayer = MediaPlayer.create(context, R.raw.slide_click);
        mediaPlayer.start();

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mediaPlayer.release();
            }
        });
    }
    public void WrongAnswer(){
        mediaPlayer = MediaPlayer.create(context, R.raw.wrong_answer);
        mediaPlayer.start();

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mediaPlayer.release();
            }
        });

    }
    public void CorrectAnswer(){
        mediaPlayer = MediaPlayer.create(context, R.raw.winning);
        mediaPlayer.start();

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mediaPlayer.release();
            }
        });

    }
    public void SingleType(){
        mediaPlayer = MediaPlayer.create(context,R.raw.single_key_type);
        mediaPlayer.start();


        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mediaPlayer.release();
            }
        });
    }
    public  void Slide(){
        mediaPlayer = MediaPlayer.create(context,R.raw.paper_slide);
        mediaPlayer.start();


        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mediaPlayer.release();
            }
        });
    }
    public  void restartSounds(){
        mediaPlayer = MediaPlayer.create(context,R.raw.restart_sounds);
        mediaPlayer.start();


        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mediaPlayer.release();
            }
        });
    }
}
