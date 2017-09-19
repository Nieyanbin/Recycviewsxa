package com.bwie.test;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.nostra13.universalimageloader.core.ImageLoader;

public class Main2Activity extends AppCompatActivity {

    private String img;
    private ImageView imga;
    private static final int RED = 0xffFF8080;
    private static final int BLUE = 0xff8080FF;
    private static final int CYAN = 0xff80ffff;
    private static final int GREEN = 0xff80ff80;
    private LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        //控件
        img = intent.getStringExtra("img");
        imga = (ImageView) findViewById(R.id.img);
        ll = (LinearLayout) findViewById(R.id.ll);
        ImageLoader.getInstance().displayImage(img, imga);
        Button btn= (Button) findViewById(R.id.btnxz);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              
                Animation circle_anim = AnimationUtils.loadAnimation(Main2Activity.this, R.anim.aa);
                LinearInterpolator interpolator = new LinearInterpolator();  //设置匀速旋转，在xml文件中设置会出现卡顿
                circle_anim.setInterpolator(interpolator);
                if (circle_anim != null) {

                    imga.startAnimation(circle_anim);  //开始动画
                    ValueAnimator colorAnim = ObjectAnimator.ofInt(ll,"backgroundColor", RED, BLUE);
                    colorAnim.setDuration(3000);
                    colorAnim.setEvaluator(new ArgbEvaluator()); colorAnim.setRepeatCount(ValueAnimator.INFINITE);
                    colorAnim.setRepeatMode(ValueAnimator.REVERSE);
                    colorAnim.start();
                }
            }
        });




    }
}
