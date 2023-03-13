package com.example.movieview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AccountLogin extends AppCompatActivity {

    EditText mail;
    EditText password;
    Button signin;
    Button signup;


    FirebaseAuth auth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_login);

        mail = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPassword);
        signin = findViewById(R.id.buttonSignIn);
        signup = findViewById(R.id.buttonSignUp);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userMail = mail.getText().toString();
                String userPassword = password.getText().toString();


                signInFirebase(userMail, userPassword);

            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AccountLogin.this, SignUp.class);
                startActivity(i);

            }
        });
    }

    public void signInFirebase(String userMail, String userPassword){

        auth.signInWithEmailAndPassword(userMail, userPassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Intent i = new Intent(AccountLogin.this, MainActivity.class);
                            startActivity(i);
                            finish();


                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(AccountLogin.this,
                                    "Mail or password Incorrect", Toast.LENGTH_SHORT).show();

                        }
                    }
                });

    }

}