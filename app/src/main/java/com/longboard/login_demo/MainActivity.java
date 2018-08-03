package com.longboard.login_demo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private EditText unesiEmail;
    private EditText unesiPassword;
    private Button btnLoginButton;

    private FirebaseAuth firebaseAuth;
    private Activity mActivity;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();

        unesiEmail = (EditText) findViewById(R.id.etEnterMail);
        unesiPassword = (EditText) findViewById(R.id.etEnterPassword);
        btnLoginButton = (Button) findViewById(R.id.btnLogin);

        btnLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Login()){
                    Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Could not register, please try later", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private boolean Login() {
        String email = unesiEmail.getText().toString().trim();
        String password = unesiPassword.getText().toString().trim();

        if (email.isEmpty()) {
            unesiEmail.setError("Email is requier");
            unesiEmail.requestFocus();

            return false;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            unesiEmail.setError("Please enter valid e-mail");

            return false;
        }

        if (password.isEmpty()) {
            unesiPassword.setError("Password is requier");
            unesiPassword.requestFocus();

            return false;
        }

        if (password.length() < 6) {
            unesiPassword.setError("Minimum lenght of password should be 6");
            unesiPassword.requestFocus();

            return false;
        }

        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Already registered", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return true;
    }
}
