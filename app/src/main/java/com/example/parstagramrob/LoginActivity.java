package com.example.parstagramrob;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    public static String TAG = "LoginActivity";
    private EditText edUsername;
    private EditText edPassword;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (ParseUser.getCurrentUser() != null){
            goMainActtivity();
        }

        edUsername = findViewById(R.id.edUsername);
        edPassword = findViewById(R.id.edPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Log.i(TAG, "On Login Activity Success");
               String username = edUsername.getText().toString();
               String password = edPassword.getText().toString();
               loginUser(username, password);
            }
        });

    }
    private void loginUser(String username, String password)  {
        Log.i(TAG, "Attempting to login user "+ username);
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e != null){
                    Log.e(TAG, "Issue with login", e);
                    return;
                }
                goMainActtivity();
                Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT);
            }
        });
    }

    private void goMainActtivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}