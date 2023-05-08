package com.example.cvinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView fname,Desc,con,email,gender,current,last,skill,exp;
    ImageView img;
    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent i=getIntent();
        fname=(TextView) findViewById(R.id.textView9);
        Desc=(TextView) findViewById(R.id.textView12);
        con=(TextView) findViewById(R.id.textView14);
        email=(TextView) findViewById(R.id.textView15);
        gender=(TextView)findViewById(R.id.textView16);
        current=(TextView)findViewById(R.id.textView18);
        last=(TextView)findViewById(R.id.textView19);
        skill=(TextView)findViewById(R.id.textView20);
        exp=(TextView)findViewById(R.id.textView22);

        fname.setText(i.getStringExtra("Fname")+" "+i.getStringExtra("Lname"));
        Desc.setText(i.getStringExtra("Desc"));
        con.setText("Contact Number "+i.getStringExtra("Phone"));
        email.setText("Email "+i.getStringExtra("Email"));
        gender.setText("Gender "+i.getStringExtra("Gender"));
        current.setText("Currently "+i.getStringExtra("Current"));
        last.setText(i.getStringExtra("Degree"));
        skill.setText("Expertise in "+i.getStringExtra("skill"));
        exp.setText("Experience "+i.getStringExtra("Exp"));



    }
}