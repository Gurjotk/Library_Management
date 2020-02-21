package com.example.librarymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button b,s;
    Button edp;
String n,an;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       b= findViewById(R.id.contact);
       edp=findViewById(R.id.profile);
       s=findViewById(R.id.search);


       edp.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i= new Intent(MainActivity.this,EditProfile.class);
               startActivity(i);
           }
       });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this,contactus.class);
                startActivity(i);
            }
        });
        s.setOnClickListener(new View.OnClickListener() {
            TextView editText=findViewById(R.id.bname);
            TextView editText2=findViewById(R.id.aname);
            @Override
            public void onClick(View v) {
                n = editText.getText().toString();
                an = editText2.getText().toString();
                Intent i= new Intent(MainActivity.this,BookCategories.class);

                i.putExtra("key3",n);
                i.putExtra("key4",an  );

                startActivity(i);
            }
        });
    }
}
