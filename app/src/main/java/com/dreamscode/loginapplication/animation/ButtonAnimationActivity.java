package com.dreamscode.loginapplication.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.dreamscode.loginapplication.R;

public class ButtonAnimationActivity extends AppCompatActivity {
    Button btn_anim;
    TextView tv_anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_animation);

        btn_anim = findViewById(R.id.btn_anim);
        tv_anim = findViewById(R.id.tv_anim);

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.lefttoright);
        tv_anim.startAnimation(animation);

        btn_anim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim = AnimationUtils.loadAnimation(ButtonAnimationActivity.this,R.anim.bounce);
                btn_anim.startAnimation(anim);
            }
        });
    }
}