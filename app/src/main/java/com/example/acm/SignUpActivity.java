package com.example.acm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{

    ProgressBar progressBar1;

    EditText editTextEmail1, editTextPassword1;

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        editTextEmail1= (EditText) findViewById(R.id.editEmail1);
        editTextPassword1= (EditText) findViewById(R.id.editPassword1);

        progressBar1 = (ProgressBar) findViewById(R.id.progressBar1);

        mAuth = FirebaseAuth.getInstance();
        findViewById(R.id.buttonLogin1).setOnClickListener(this);
        //findViewById(R.id.textViewLogin).setOnClickListener(this);

    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }

    private void registerUser()
    {
        String email = editTextEmail1.getText().toString().trim();
        String password = editTextPassword1.getText().toString().trim();

        if(email.isEmpty())
        {
            editTextEmail1.setError("Email is required");
            editTextEmail1.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            editTextEmail1.setError("Please enter a valid email");
            editTextEmail1.requestFocus();
            return;
        }

        if(password.isEmpty())
        {
            editTextPassword1.setError("Password is required");
            editTextPassword1.requestFocus();
            return;
        }

        if(password.length()<6)
        {
            editTextPassword1.setError("Minimum length of password should be 6");
            editTextPassword1.requestFocus();
            return;
        }

        progressBar1.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>()  {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar1.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "User Registered Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finishAffinity();
                } else {
                    if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                        Toast.makeText(getApplicationContext(),"User is Already Registered!",Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

        } );
    }

    @Override
    public void onClick(View view)
    {
        switch(view.getId())
        {
            case R.id.buttonLogin1:
                registerUser();
                break;

            /*case R.id.textViewLogin :
                startActivity(new Intent(this, LoginActivity.class));
                finish();
                break;*/
        }
    }
}

