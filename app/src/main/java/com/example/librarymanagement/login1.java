package com.example.librarymanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class login1 extends AppCompatActivity {
    Button l;
    TextView sign;
    EditText email, pass;
    FirebaseAuth myFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);
        myFirebaseAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.editText);
        pass = findViewById(R.id.editText6);
        sign =findViewById(R.id.textView30);
        l = findViewById(R.id.login);
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String em = email.getText().toString();
                String pa = pass.getText().toString();
                switch(v.getId()){
                    case R.id.login:
                        addDataFirestore();
                        break;
                    case R.id.textView30:
                        Intent i1 = new Intent(login1.this, EditProfile.class);

                        startActivity(i1);
                        break;
                }
            }
        public void addDataFirestore() {
            String em = email.getText().toString();
            String pa = pass.getText().toString();

            HashMap<String, String> order = new HashMap<>();
            order.put("email", em);
            order.put("password", pa);

            FirebaseFirestore db = FirebaseFirestore.getInstance();
            db.collection("Orders").add(order)
                    .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentReference> task) {
                            Toast.makeText(login1.this, "Done", Toast.LENGTH_LONG).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(login1.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    e.printStackTrace();

                }
            });
            sign.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i1 = new Intent(login1.this, EditProfile.class);

                    startActivity(i1);
                }
            });
        }
    });
    }
}
