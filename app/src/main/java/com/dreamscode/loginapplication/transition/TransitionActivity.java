package com.dreamscode.loginapplication.transition;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dreamscode.loginapplication.R;

public class TransitionActivity extends AppCompatActivity {

    Button btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);

        btn_next = findViewById(R.id.button);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TransitionActivity.this,TransitionSecondActivity.class);
                Bundle b = ActivityOptions.makeSceneTransitionAnimation(TransitionActivity.this).toBundle();
                startActivity(intent,b);
            }
        });
    }
}