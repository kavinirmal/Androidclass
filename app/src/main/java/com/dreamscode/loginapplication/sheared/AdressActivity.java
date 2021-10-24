package com.dreamscode.loginapplication.sheared;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.dreamscode.loginapplication.R;

public class AdressActivity extends AppCompatActivity {
    EditText et_address;
    Button bt_next;
    SharedPreferences myfref;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adress);

        et_address = findViewById(R.id.et_address);
        bt_next = findViewById(R.id.bt_next);

        myfref = getApplicationContext().getSharedPreferences("Mypref",MODE_PRIVATE);
        editor = myfref.edit();

        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String address = et_address.getText().toString();
                editor.putString("Address",address);
                editor.apply();
                Intent intent = new Intent(AdressActivity.this,PhoneNumberActivity.class);
                startActivity(intent);
            }
        });
    }
}