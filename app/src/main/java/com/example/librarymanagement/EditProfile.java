package com.example.librarymanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;


import java.util.HashMap;

import javax.sql.RowSet;

public class EditProfile extends AppCompatActivity implements View.OnClickListener {
    Button btn;
    TextView ed1,ed2,ed3,ed4;
    String n1,email,phone,dob;
    FirebaseAuth myFirebaseAuth;
    private RowSet model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        myFirebaseAuth  = FirebaseAuth.getInstance();
        ed1 = findViewById(R.id.n1);
        ed2 = findViewById(R.id.e1);
        ed3 = findViewById(R.id.p1);
        ed4 = findViewById(R.id.dob1);
        btn = findViewById(R.id.signup);
      btn.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signup:
                addDataFirestore();
                Intent i1 = new Intent(EditProfile.this, MainActivity.class);

                startActivity(i1);
                break;
        }

        Intent i= new Intent(EditProfile.this,MainActivity.class);

        i.putExtra("key n1",n1);
        i.putExtra("key email",email );
        i.putExtra("key phone",email );
        i.putExtra("key dob",email );
        startActivity(i);
    }



    private void addDataFirestore() {
        n1 = ed1.getText().toString();
        email = ed2.getText().toString();
        phone = ed3.getText().toString();
        dob = ed4.getText().toString();
        HashMap<String, String> signup = new HashMap<>();
        signup.put("name",n1);
        signup.put("email",email);
        signup.put("phone",phone);
        signup.put("DOB",dob);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Signup").add(signup).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                Toast.makeText(EditProfile.this,"Done",Toast.LENGTH_LONG).show();
            }

        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(EditProfile.this, e.getMessage(), Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }
        });
    }

}