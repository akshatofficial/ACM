package com.example.acm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.SignInMethodQueryResult;

public class ForgotPassword extends AppCompatActivity {

    EditText recoveryEmail;
    FirebaseAuth mAuth;
    ProgressBar progressbar;
    Button send;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password);

        progressbar = (ProgressBar) findViewById(R.id.progressBar);
        recoveryEmail = (EditText) findViewById(R.id.editTextRecovery);
        send = findViewById(R.id.buttonSend);
        mAuth = FirebaseAuth.getInstance();

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetPassword();
            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }

    public void resetPassword() {
        String email = recoveryEmail.getText().toString().trim();
        if (email.isEmpty()) {
            recoveryEmail.setError("Email is required");
            recoveryEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            recoveryEmail.setError("Please enter a valid email");
            recoveryEmail.requestFocus();
            return;
        }


        progressbar.setVisibility(View.VISIBLE);
        mAuth.fetchSignInMethodsForEmail(recoveryEmail.getText().toString()).addOnCompleteListener(new OnCompleteListener<SignInMethodQueryResult>() {
            @Override
            public void onComplete(@NonNull Task<SignInMethodQueryResult> task) {

                boolean check = !task.getResult().getSignInMethods().isEmpty();
                progressbar.setVisibility(View.GONE);
                if (!check) {
                    Toast.makeText(getApplicationContext(), "Email not registered", Toast.LENGTH_SHORT).show();
                } else {
                    mAuth.sendPasswordResetEmail(recoveryEmail.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if (task.isSuccessful()) {
                                Toast.makeText(ForgotPassword.this, "Email to reset password sent", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(ForgotPassword.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }

            }
        });
    }
}