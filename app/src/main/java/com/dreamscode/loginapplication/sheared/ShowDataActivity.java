package com.dreamscode.loginapplication.sheared;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dreamscode.loginapplication.R;

public class ShowDataActivity extends AppCompatActivity {
    TextView tv_name,tv_address,tv_phone;
    Button btn_show;
    SharedPreferences myfref;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        tv_name = findViewById(R.id.tv_name);
        tv_address = findViewById(R.id.tv_address);
        tv_phone = findViewById(R.id.tv_phone);
        btn_show = findViewById(R.id.btn_show);

        myfref = getApplicationContext().getSharedPreferences("Mypref",MODE_PRIVATE);
        editor = myfref.edit();

        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = myfref.getString("Name","No name");
                String address = myfref.getString("Address","No address");
                int phone = myfref.getInt("Phone",00000000);
                setValue(name,address,phone);

            }
        });
    }

    private void setValue(String name, String address, int phone) {
        tv_name.setText(name);
        tv_address.setText(address);
        tv_phone.setText(String.valueOf(phone));

        //one delete
        editor.remove("Name");
        editor.commit();
        //all delete
        editor.clear();
        editor.commit();
    }
}