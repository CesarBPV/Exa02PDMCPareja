package com.hola.cesar.exa02_pdm_cpareja;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.drawable.TransitionDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    private TextView tv;
    private ImageView iv;
    private ProgressBar mProgressView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme_NoActionBar);
        setContentView(R.layout.activity_splash);
        tv=findViewById(R.id.tapp);
        iv=findViewById(R.id.imv);
        mProgressView = findViewById(R.id.splash_progress);
        mProgressView.setIndeterminate(true);
        mProgressView.animate();
        Animation myAnim= AnimationUtils.loadAnimation(this,R.anim.mytransition);
        tv.startAnimation(myAnim);
        iv.startAnimation(myAnim);
        TransitionDrawable transitionb=(TransitionDrawable) findViewById(R.id.spc).getBackground();
        transitionb.startTransition(2000);
        Integer colorFrom = getResources().getColor(R.color.colorWhite);
        Integer colorTo = getResources().getColor(R.color.colorPrimary);
        ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
        colorAnimation.setDuration(2000);
        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                tv.setTextColor((Integer)animator.getAnimatedValue());
            }

        });
        colorAnimation.start();
        final Intent i=new Intent(this,LoginActivity.class);
        Thread timer =new Thread(){
            @Override
            public void run() {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    startActivity(i);
                }
            }
        };
        timer.start();
    }
}
