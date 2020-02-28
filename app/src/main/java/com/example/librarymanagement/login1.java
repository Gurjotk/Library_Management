package com.example.librarymanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login1 extends AppCompatActivity {
    Button l;
    TextView sign;
    EditText email,pass;
    FirebaseAuth myFirebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);
        myFirebaseAuth= FirebaseAuth.getInstance();
        email=findViewById(R.id.editText);
        pass=findViewById(R.id.editText6);
        l=findViewById(R.id.login);
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String em= email.getText().toString();
                String pa= pass.getText().toString();
                if(em.isEmpty()){
                    email.setError("Please check email again!");
                    email.requestFocus();
                }
                else if(pa.isEmpty()){
                    pass.setError("Please check email again!");
                    pass.requestFocus();
                }
                else if (!(em.isEmpty() && pa.isEmpty() )){
                    myFirebaseAuth.createUserWithEmailAndPassword(em, pa).addOnCompleteListener(login1.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(! task.isSuccessful()){
                                Toast.makeText(login1.this,"Signup unScuessful",Toast.LENGTH_LONG).show();
                            }
                            else{
                                Intent i= new Intent(login1.this,MainActivity.class);

                                  startActivity(i);
                            }
                        }
                    });
                }
                else
                {
                    Toast.makeText(login1.this,"oops! There is something wrong.",Toast.LENGTH_LONG).show();
                }



            }
        });
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1= new Intent(login1.this,EditProfile.class);

                startActivity(i1);
            }
        });
    }
}
