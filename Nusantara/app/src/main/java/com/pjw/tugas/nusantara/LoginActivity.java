package com.pjw.tugas.nusantara;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class LoginActivity extends AppCompatActivity {

    Button loginButton;
    private EditText username;
    private EditText password;
    TextInputLayout un_container;
    TextInputLayout pw_container;
    View decorView;
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        decorView = getWindow().getDecorView();

        username    = (EditText) findViewById(R.id.input_username);
        password    = (EditText) findViewById(R.id.input_password);
        loginButton = (Button)findViewById(R.id.login_button);

        logo        = (ImageView) findViewById(R.id.logo);
        un_container= (TextInputLayout) findViewById(R.id.layout_input_username);
        pw_container= (TextInputLayout) findViewById(R.id.layout_input_password);

        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logo.setScaleY((float) 0.8);
                logo.setScaleX((float) 0.8);

                un_container.setVisibility(View.VISIBLE);
                pw_container.setVisibility(View.VISIBLE);
                loginButton.setVisibility(View.VISIBLE);
                logo.setClickable(false);
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (logIn()) {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }
            }
        });
    }

    private boolean logIn() {
        String un="A";
        String pw="a";
        if(username.getText().toString().isEmpty()){
            username.setError(getString(R.string.error_field_required));
            username.requestFocus();
            return false;
        }
        else if(password.getText().toString().isEmpty()){
            password.setError(getString(R.string.error_field_required));
            password.requestFocus();
            return false;
        }else if(username.getText().toString().equals(un)&&password.getText().toString().equals(pw)){
            return true;
        }else{
            username.setError("Username atau Password Salah");
            username.requestFocus();
            return false;
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);}
    }
}

