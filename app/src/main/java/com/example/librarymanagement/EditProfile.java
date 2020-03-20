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
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;

public class EditProfile extends AppCompatActivity {
    Button btn;
    TextView ed1,ed2,ed3,ed4;
    String n1,email,phone,dob;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        ed1 = findViewById(R.id.n1);
        ed2 = findViewById(R.id.e1);
        ed3 = findViewById(R.id.p1);
        ed4 = findViewById(R.id.dob1);
        btn = findViewById(R.id.login);
        btn.setOnClickListener((View.OnClickListener) this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                addDataFirestore();
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
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Signup").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {

                    for (QueryDocumentSnapshot documentSnapshot : task.getResult()) {
                        Toast.makeText(EditProfile.this, "HELLOOOO", Toast.LENGTH_SHORT).show();
                        System.out.println(documentSnapshot.getData().toString());
                    }
                }
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