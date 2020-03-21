package com.example.flash;

import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

import javax.security.auth.callback.UnsupportedCallbackException;

public class Verify extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private String verificationId;
    private ProgressBar progressBar;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);
        mAuth=FirebaseAuth.getInstance();
        progressBar=findViewById(R.id.processbar);
        editText=findViewById(R.id.editcode);

        String phonenumber=getIntent().getStringExtra("phonenumber");
        sendVerificationCode(phonenumber);
        findViewById(R.id.signbttn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String code=editText.getText().toString().trim();

                if (code.isEmpty() || code.length()<6)
                {
                    editText.setError("Enter Code ......");
                    editText.requestFocus();
                    return;
                }
                verifyCode(code);
            }
        });

    }

    private void sendVerificationCode(String number) {

        progressBar.setVisibility(View.VISIBLE);
        PhoneAuthProvider.getInstance().verifyPhoneNumber(number, |60, TimeUnit.SECONDS, TaskExecutors.MAIN_THREAD );


    }
}
