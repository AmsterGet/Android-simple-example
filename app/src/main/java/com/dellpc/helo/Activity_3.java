package com.dellpc.helo;

/*import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.*;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;*/
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;


public class Activity_3 extends AppCompatActivity {
    private ImageView imageLeft;
    private ImageView imageRight;
    private SeekBar seekBar;
    private Button async;
    private Button sync;
    private Button lab5;
    private TextView progress;
    private Animation left_anim;
    private Animation right_anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.laba4_layout);

        imageLeft = (ImageView) findViewById(R.id.image_left);
        imageRight = (ImageView) findViewById(R.id.image_right);
        seekBar = (SeekBar) findViewById(R.id.seek_bar);
        async = (Button) findViewById(R.id.async_btn);
        sync = (Button) findViewById(R.id.sync_btn);
        progress = (TextView) findViewById(R.id.progrees_textview);

        lab5=(Button) findViewById(R.id.lab55);
        lab5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_3.this, Activity_4.class);//change activity
                startActivity(intent);
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {//берём текущее значение seekbar
                progress.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        async.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//асинхронная анимация
                left_anim = AnimationUtils.loadAnimation(getBaseContext(), android.R.anim.slide_in_left);
                left_anim.setDuration(seekBar.getProgress());
                imageLeft.startAnimation(left_anim);

                left_anim.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        right_anim = AnimationUtils.loadAnimation(getBaseContext(), android.R.anim.slide_out_right);
                        right_anim.setDuration(seekBar.getProgress());
                        imageRight.startAnimation(right_anim);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }

                });
            }
        });
        sync.setOnClickListener(new View.OnClickListener() {//синхронная анимация
            @Override
            public void onClick(View view) {
                left_anim = AnimationUtils.loadAnimation(getBaseContext(), android.R.anim.slide_in_left);
                left_anim.setDuration(seekBar.getProgress());
                imageLeft.startAnimation(left_anim);
                right_anim = AnimationUtils.loadAnimation(getBaseContext(), android.R.anim.slide_out_right);
                right_anim.setDuration(seekBar.getProgress());
                imageRight.startAnimation(right_anim);
            }
        });

    }

}