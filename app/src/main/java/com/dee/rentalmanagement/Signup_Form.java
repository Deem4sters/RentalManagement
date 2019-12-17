package com.dee.rentalmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signup_Form extends AppCompatActivity {

    EditText etEmail, etPhone, etAddress, etPassword, etConfirmPassword;
    RadioGroup rgGender;
    Button btnSignUp;

    private FirebaseAuth  firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup__form);
        getSupportActionBar().setTitle("Signup Form");

        etEmail = findViewById(R.id.etEmail);
        etPhone =findViewById(R.id.etPhone);
        etAddress = findViewById(R.id.etAddress);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        btnSignUp = findViewById(R.id.btnSignUp);

        firebaseAuth = firebaseAuth.getInstance();

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                String phone = etPhone.getText().toString().trim();
                String address = etAddress.getText().toString().trim();
                String confirmPassword = etConfirmPassword.getText().toString().trim();


                if (TextUtils.isEmpty(email)){
                    Toast.makeText(Signup_Form.this, "Please enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)){
                    Toast.makeText(Signup_Form.this, "Please enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }


                if (TextUtils.isEmpty(confirmPassword)){
                    Toast.makeText(Signup_Form.this, "Please enter Confirm Password", Toast.LENGTH_SHORT).show();
                    return;
                }


                if (TextUtils.isEmpty(phone)){
                    Toast.makeText(Signup_Form.this, "Please enter Phone number", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(address)){
                    Toast.makeText(Signup_Form.this, "Please enter Address", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length()<6){
                    Toast.makeText(Signup_Form.this, "Password too Short ", Toast.LENGTH_SHORT).show();
                }

                if (password.equals(confirmPassword))
                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(Signup_Form.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {

                                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                        Toast.makeText(Signup_Form.this, "Registration Completed", Toast.LENGTH_SHORT).show();

                                    } else {
                                        Toast.makeText(Signup_Form.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });


            }
        });


    }
}
