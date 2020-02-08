package com.example.librarymanagement;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;

public class contact extends AppCompatActivity {
    Button b;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact);
        b= findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(contact.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}
