package com.pjw.tugas.nusantara;


import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.IOException;
import java.util.StringTokenizer;

public class LoginActivity extends AppCompatActivity implements
        GoogleApiClient.OnConnectionFailedListener{

    Button loginButton;
    private EditText username;
    private EditText password;
    TextInputLayout un_container;
    TextInputLayout pw_container;
    View decorView;
    ImageView logo;

    private static final String TAG = "SignInActivity";
    private static final int RC_SIGN_IN = 9001;

    private GoogleApiClient mGoogleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        decorView = getWindow().getDecorView();

        reqPermission();


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
               /* if (logIn()) {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }*/

                signIn();
            }
        });

        configGoogleSignIn();
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

    /**
     * GOOGLE SIGN IG -----------------------------------------------------
     */

    private void reqPermission() {
        // Here, thisActivity is the current activity

        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(
                        this,
                        new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        0);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }
    }

    private void configGoogleSignIn(){

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestProfile()
                .requestEmail()
                .build();
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
    }

    private void signIn() {
        showProgressDialog();
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    private void handleSignInResult(GoogleSignInResult result) {
        Log.d(TAG, "handleSignInResult:" + result.isSuccess());
        if (result.isSuccess()) {
            // Signed in successfully, show authenticated UI.
            GoogleSignInAccount acct = result.getSignInAccount();
            if (acct != null) {
                //Set MyAccount
                //new LoadProfileImage().execute(getURLPhoto(acct.zzmI()));
                if (acct.getId()!=null) {

                    User.akunIni=new User(
                            acct.getId(),
                            acct.getDisplayName(),
                            getURLPhoto(acct.zzmI()),
                            acct.getEmail()
                    );

                    Log.d("FOTO URL",User.akunIni.getUrlFoto());
                    Log.d("MY ACCOUNT","SUCCESS");

                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }else {
                    Log.d("MY ACCOUNT","GAGAL");
                }
            }
        }
    }

    private String getURLPhoto(String zzmI) {
        //Getting URL PHOTO
        StringTokenizer token= new StringTokenizer(zzmI, ",");
        token.nextToken();//ID
        token.nextToken();//EMAIL
        token.nextToken();//NAMA
        String urlPhoto=token.nextToken();
        urlPhoto=urlPhoto.replaceAll("\"photoUrl\":","");
        urlPhoto=urlPhoto.replaceAll("\"","");
        urlPhoto=urlPhoto.replaceAll("/", "");
        urlPhoto=urlPhoto.replace((char) 92, (char) 47);
        Log.d("URL PHOTO",urlPhoto+"?sz=100");
        return urlPhoto+"?sz=100";
    }

    private boolean isRegistered() {
        //Check with loadFromAPI loginPelapor, if 1 return true, else 0;
        return true;
    }

    private void showProgressDialog() {
        loginButton.setVisibility(View.GONE);
        //loading.setVisibility(View.VISIBLE);
    }

    private void hideProgressDialog() {
        //loading.setVisibility(View.GONE);
        loginButton.setVisibility(View.VISIBLE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        // An unresolvable error has occurred and Google APIs (including Sign-In) will not
        // be available.
        Log.d(TAG, "onConnectionFailed:" + connectionResult);
    }

    /**
     * --------------------------------------------------------------------
     */

}

