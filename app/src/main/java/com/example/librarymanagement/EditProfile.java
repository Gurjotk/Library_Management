package com.example.librarymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EditProfile extends AppCompatActivity {
Button btn;
String n1,email,phone,dob;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        btn=findViewById(R.id.login);
        btn.setOnClickListener(new View.OnClickListener() {
            TextView ed1=findViewById(R.id.n1);
            TextView ed2=findViewById(R.id.e1);
            TextView ed3=findViewById(R.id.p1);
            TextView ed4=findViewById(R.id.dob1);
            @Override
            public void onClick(View v) {
                n1 = ed1.getText().toString();
                email = ed2.getText().toString();
                phone = ed3.getText().toString();
             dob = ed4.getText().toString();
                Intent i= new Intent(EditProfile.this,MainActivity.class);

                i.putExtra("key n1",n1);
                i.putExtra("key email",email );
                i.putExtra("key phone",email );
                i.putExtra("key dob",email );
                startActivity(i);
            }
        });
    }



}
