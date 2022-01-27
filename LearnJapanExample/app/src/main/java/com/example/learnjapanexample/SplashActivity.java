package com.example.learnjapanexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.learnjapanexample.fragments.LoginFragment;

public class SplashActivity extends AppCompatActivity {
    public static final int DELAY_SPLASH_SCREEN= 3500;

    private Animation topAnimation;
    private ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        topAnimation= AnimationUtils.loadAnimation(SplashActivity.this,R.anim.top_animation);
        logo = findViewById(R.id.logo);

        logo.setAnimation(topAnimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashActivity.this,LoginActivity.class);

                Pair[] pairs=new Pair[1];
                pairs[0] = new Pair<View,String>(logo,"logo");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SplashActivity.this,pairs);

                startActivity(intent,options.toBundle());
            }
        }, DELAY_SPLASH_SCREEN);
    }
}