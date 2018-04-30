package com.hola.cesar.exa02_pdm_cpareja;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    private TextView tv;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        tv=findViewById(R.id.tapp);
        iv=findViewById(R.id.imv);
        Animation myAnim= AnimationUtils.loadAnimation(this,R.anim.mytransition);
        tv.startAnimation(myAnim);
        iv.startAnimation(myAnim);
    }
}
