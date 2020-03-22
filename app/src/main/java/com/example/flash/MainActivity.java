package com.example.flash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
 private   EditText mobile;
   private Button button;
   private String no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mobile = (EditText) findViewById(R.id.mobile);

        button = (Button) findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                no = mobile.getText().toString();
                validNo(no);
                Intent intent = new Intent(MainActivity.this,Verify.class);
                intent.putExtra("mobile",no);
                startActivity(intent);
                Toast.makeText(MainActivity.this,no,Toast.LENGTH_LONG).show();
            }
        });


    }

    private void validNo(String no){
        if(no.isEmpty() || no.length() < 10){
            mobile.setError("Enter a valid mobile");
            mobile.requestFocus();
            return;
        }
    }
}

 /*   This is the whole code of the main activity. I will break it down into various sections and I will give explanation of each section. Let’s start with the first section of code in the app.






        EditText mobile;
        Button button;
        String no;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mobile = (EditText) findViewById(R.id.mobile);

        button = (Button) findViewById(R.id.button);

  /*      This is the first section of code in the main activity java file. In this section we are just initializing some instance variables which we have declared in the xml file. There is one edittext field in which we will be entering the mobile number to verify and a button to continue the process of verification. So very simple method is used i.e. findviewbyid.






        button.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {

        no = mobile.getText().toString();
        validNo(no);
        Intent intent = new Intent(MainActivity.this,VerifyMobile.class);
        intent.putExtra("mobile",no);
        startActivity(intent);
        Toast.makeText(MainActivity.this,no,Toast.LENGTH_LONG).show();
        }
        });


        }

private void validNo(String no){
        if(no.isEmpty() || no.length() < 10){
        mobile.setError("Enter a valid mobile");
        mobile.requestFocus();
        return;
        }
        }
    }

      protected void onstart()
      {
          super.onStart();
          if (FirebaseAuth.getInstance().getCurrentUser() !=null)
          {
              Intent intent =new Intent(this,Profile.class);
              intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
              startActivity(intent);
          }
      }*/
