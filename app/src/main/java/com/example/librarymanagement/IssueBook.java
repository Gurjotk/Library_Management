package com.example.librarymanagement;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class IssueBook extends AppCompatActivity {

    Button BB;
    TextView name,author,issue,due;
    EditText Bname,Aname,Idate,Ddate;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        BB.findViewById(R.id.BBB);
        name.findViewById(R.id.textView16);
        author.findViewById(R.id.textView17);
        issue.findViewById(R.id.textView18);
        due.findViewById(R.id.textView19);
        Bname.findViewById(R.id.editText5);
        Aname.findViewById(R.id.editText7);
        Idate.findViewById(R.id.editText10);
        Ddate.findViewById(R.id.editText11);


BB.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i= new Intent(IssueBook.this,MainActivity.class);
        startActivity(i);
    }
});


    }

}

