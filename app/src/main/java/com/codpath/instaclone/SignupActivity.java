package com.codpath.instaclone;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignupActivity extends AppCompatActivity {

    public static final String TAG = "SignupActivity";
    private EditText etname;
    private EditText etpasswordup;
    private EditText etpasswordupcon;
    private Button btnSignup;
    ParseUser user =new ParseUser();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etname = findViewById(R.id.etname);
        etpasswordup = findViewById(R.id.etpasswordup);
        etpasswordupcon = findViewById(R.id.etpasswordupcon);
        btnSignup = findViewById(R.id.btnSignup);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etname.getText().toString();
                String password = etpasswordup.getText().toString();
                String confirm = etpasswordupcon.getText().toString();
                if (password == confirm) {
                    Toast.makeText(SignupActivity.this, "Sucess", Toast.LENGTH_SHORT).show();
                }
                submit(username, password);
            }
        });
    }
        private void submit(String username, String etpasswordup){
            user.setUsername(username);
            user.setPassword(etpasswordup);
            user.signUpInBackground(new SignUpCallback(){
                @Override
                public void done(ParseException e) {
                    if (e == null) {
                        goMainActivity();
                    }
                    else {
                        Log.e(TAG,"Issue Signing Up",e);
                        return;
                }
            }
        });

        }

    private void goMainActivity(){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

}
