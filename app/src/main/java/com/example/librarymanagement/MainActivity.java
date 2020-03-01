package com.example.librarymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b,s;
    Button edp;
String n,an;
Spinner s1,s2;
String language[]={"Language","English","Hindi","Punjabi","French"};
String subject[]={"Fiction","Non-fiction","Religious","science","Political","comedy"};

ArrayAdapter<String>arrayAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       b= findViewById(R.id.contact);
       edp=findViewById(R.id.profile);
       s=findViewById(R.id.search);
       s1=findViewById(R.id.spinner);
       s2=findViewById(R.id.spinner2);




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
        //add spinner

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.activity_list_item,language);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(adapter);
        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"You choose: "+language[position],Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        s2 = (Spinner)findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.activity_list_item,subject);

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter1);
        s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                Toast.makeText(getApplicationContext(),"You choose: "+subject[i],Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }



}



