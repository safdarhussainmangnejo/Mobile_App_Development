package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText emailText, passwordText;
    Button loginButton, signupButton;
    String email, password;
    // Write a message to the database
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef;

    Users user;
    private Object Menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailText = (EditText) findViewById(R.id.editTextTextEmailAddress);
        passwordText = (EditText) findViewById(R.id.editTextTextPassword);
        loginButton = (Button) findViewById(R.id.button);
        signupButton = (Button) findViewById(R.id.button2);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        progressDialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        //user = new Users();
        myRef = database.getReference().child("Users");

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performLogin();

            }
        });


        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signupIntent = new Intent(getApplicationContext(), SignupForm.class);
                startActivity(signupIntent);

            }
        });


    }


    public void insertData(View view){

            user.setEmail(emailText.getText().toString());
            user.setPassword(passwordText.getText().toString());
            myRef.push().setValue(user);
            Toast.makeText(getApplicationContext(), "Data Inseerted", Toast.LENGTH_LONG).show();

        }

        public void performLogin(){

                email = emailText.getText().toString();
                password = passwordText.getText().toString();

                if(!email.matches((emailPattern))){
                    emailText.setError("Enter correct email");
                }else if(password.isEmpty() || password.length()<6){
                    passwordText.setError("Enter Proper Password");
                }else {
                    progressDialog.setMessage("Please wait while Login...");
                    progressDialog.setTitle("Login");
                    progressDialog.setCanceledOnTouchOutside(false);
                    progressDialog.show();

                    mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                progressDialog.dismiss();
                                sendUsertoNextActivity();
                                Toast.makeText(MainActivity.this, "Login Succesfull", Toast.LENGTH_LONG).show();

                            } else {
                                progressDialog.dismiss();
                                Toast.makeText(MainActivity.this, "" + "You don't have any account, please register now", Toast.LENGTH_LONG).show();

                            }

                        }
                    });
                }


        }
    private void sendUsertoNextActivity() {
        Intent intent = new Intent(MainActivity.this, WelcomeScreen.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("email",email);
        startActivity(intent);
    }


}