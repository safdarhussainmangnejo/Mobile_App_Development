package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignupForm extends AppCompatActivity {

    EditText emailText, passwordText;
    Button registerButton, signInButton;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_form);
        emailText = (EditText) findViewById(R.id.editTextTextEmailAddress2);
        passwordText = (EditText) findViewById(R.id.editTextTextPassword2);
        registerButton = (Button) findViewById(R.id.button3);
        signInButton = (Button) findViewById(R.id.loginButton);

        progressDialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PerformAuth();

            }
        });

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendUsertoNextActivity();
            }
        });
    }

    private void PerformAuth() {
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

        if (!email.matches((emailPattern))) {
            emailText.setError("Enter correct email");
        } else if (password.isEmpty() || password.length() < 6) {
            passwordText.setError("Enter Proper Password");
        } else {
            progressDialog.setMessage("Wait while Registration...");
            progressDialog.setTitle("Regisration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();


            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        progressDialog.dismiss();
                        sendUsertoNextActivity();
                        Toast.makeText(SignupForm.this, "Registration Successfull", Toast.LENGTH_LONG).show();

                    } else {
                        progressDialog.dismiss();
                        Toast.makeText(SignupForm.this, "" + "Registration Not Completed, Try Again", Toast.LENGTH_LONG).show();

                    }
                }

            });
        }
    }
    private void sendUsertoNextActivity() {
        Intent intent = new Intent(SignupForm.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}