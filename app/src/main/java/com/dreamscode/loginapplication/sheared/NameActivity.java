package com.dreamscode.loginapplication.sheared;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.dreamscode.loginapplication.R;

public class NameActivity extends AppCompatActivity {
    EditText et_name;
    Button bt_next;
    SharedPreferences myfref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        et_name = findViewById(R.id.et_name);
        bt_next = findViewById(R.id.bt_next);

        myfref = getApplicationContext().getSharedPreferences("Mypref",MODE_PRIVATE);
        editor = myfref.edit();

        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = et_name.getText().toString();
                editor.putString("Name",name);
                editor.apply();
                Intent intent = new Intent(NameActivity.this,AdressActivity.class);
                startActivity(intent);

            }
        });
    }
}