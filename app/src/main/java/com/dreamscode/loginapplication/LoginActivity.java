package com.dreamscode.loginapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    EditText et_email,et_password;
    RelativeLayout btn_login;
    TextView tv_sign_up;
    String EmailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"; // name@xyz.com
    String PasswordPattern = "[a-zA-Z0-9\\\\!\\\\@\\\\#\\\\$]{8,24}";
    FirebaseAuth mAuth;
    String Uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_email = findViewById(R.id.edt_email_address);
        et_password = findViewById(R.id.edt_password);
        btn_login = findViewById(R.id.btn_login);
        tv_sign_up = findViewById(R.id.tv_signup);

        mAuth = FirebaseAuth.getInstance();

        String sign_up_text = "<font>Dont’t have an account?</font> <font color =#E26912><b> SIGNUP</b></font>";
        tv_sign_up.setText(Html.fromHtml(sign_up_text));

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email,password;
                email = et_email.getText().toString().trim();
                password = et_password.getText().toString().trim();
                validateFileds(email,password);
//                Toast.makeText(LoginActivity.this, "Email is " + email + " " + "Password is "+ password, Toast.LENGTH_SHORT).show();

            }

        });

    }

    private void validateFileds(String email, String password) {
        //validate email and password fields
        if (!(email.isEmpty()) && !(password.isEmpty())){
            if (email.matches(EmailPattern)){
                if (password.matches(PasswordPattern)){
                    logUser(email,password);
                }else {
                    et_password.setError("Password should 8-24 characters");
                }
            }else {
                et_email.setError("Email is incorrect!!!");
            }
        }else {
            Toast.makeText(LoginActivity.this, "Please fill all fields!!!", Toast.LENGTH_SHORT).show();
        }
    }

    private void logUser(String email, String password) {
        //code firebase,Rest API
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(LoginActivity.this,"Logged In Successfully",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this,FragmentActivity.class));
                }else {
                    Toast.makeText(LoginActivity.this,"Error occurred!",Toast.LENGTH_SHORT).show();
                }

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(LoginActivity.this,"Error occurred!",Toast.LENGTH_SHORT).show();
            }
        });


    }

}
