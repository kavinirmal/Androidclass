package com.dreamscode.loginapplication.sheared;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.dreamscode.loginapplication.R;

public class PhoneNumberActivity extends AppCompatActivity {
    EditText et_phone;
    Button bt_next;
    SharedPreferences myfref;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_number);

        et_phone = findViewById(R.id.et_no);
        bt_next = findViewById(R.id.bt_next);

        myfref = getApplicationContext().getSharedPreferences("Mypref",MODE_PRIVATE);
        editor = myfref.edit();

        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int phone = Integer.parseInt(et_phone.getText().toString());
                editor.putInt("Phone",phone);
                editor.apply();
                Intent intent = new Intent(PhoneNumberActivity.this,ShowDataActivity.class);
                startActivity(intent);
            }
        });
    }
}