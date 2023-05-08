package com.example.cvinfo;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.cvinfo.R.id;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Spinner s,s1;
    Spinner deg;
    RadioButton male,female;
    EditText degree,fname,lname,desc,ph,email,skill,qu;

    Button btn,btn2;
    ToggleButton tbenroll;
    ImageView img;
    String qual,image;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        deg=(Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence>d=ArrayAdapter.createFromResource(getApplicationContext(),R.array.Degree, android.R.layout.simple_spinner_item);
        d.setDropDownViewResource(android.R.layout.simple_spinner_item);
        deg.setAdapter(d);
        deg.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(Objects.equals(deg.getSelectedItem().toString(),"Middle")){
                    qual="Middle from ";
                    degree.setHint("e.g. ABC School");
                }else if(Objects.equals(deg.getSelectedItem().toString(),"Matric")){
                    qual="Matriculated from ";
                    degree.setHint("e.g. Board Name");
                }else if(Objects.equals(deg.getSelectedItem().toString(),"Inter")){
                    qual="Intermediate from ";
                    degree.setHint("e.g. Board Name");
                }else if(Objects.equals(deg.getSelectedItem().toString(),"Graduate")){
                    qual="Graduation in ";
                    degree.setHint("e.g. BsCS");
                }else if(Objects.equals(deg.getSelectedItem().toString(),"Masters")){
                    qual="Masters in ";
                    degree.setHint("e.g. MsCS");
                }else if(Objects.equals(deg.getSelectedItem().toString(),"Phd")){
                    qual="Doctorate in ";
                    degree.setHint("e.g. AI");
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        fname=(EditText) findViewById(R.id.editTextTextPersonName3);
        lname=(EditText)findViewById(R.id.editTextTextPersonName4);
        btn2=(Button)findViewById(R.id.button2);
        btn2.setOnClickListener(this);
        degree=(EditText) findViewById(R.id.editTextTextPersonName6);
        btn=(Button) findViewById(R.id.button);
        btn.setOnClickListener(this);
        img=(ImageView)findViewById(R.id.imageView3);

        s1=(Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence>adapter1=ArrayAdapter.createFromResource(MainActivity.this,R.array.Experience, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_item);
        s1.setAdapter(adapter1);

        male=(RadioButton) findViewById(R.id.male);
        female=(RadioButton) findViewById(R.id.female);
        tbenroll=(ToggleButton) findViewById(id.toggleButton);
        tbenroll.setTextOff("UnEnrolled");
        tbenroll.setTextOn("Enrolled");
        desc=(EditText) findViewById(id.editTextTextMultiLine2);
        ph=(EditText) findViewById(id.editTextPhone);
        email=(EditText) findViewById(id.editTextTextEmailAddress);
        skill=(EditText) findViewById(id.editTextTextMultiLine);

    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        if(Objects.equals(id,R.id.button)){
            Intent ig=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(ig,3);
        } else if (Objects.equals(id,R.id.button2)) {
            Intent i=new Intent(getApplicationContext(),MainActivity2.class);
            i.putExtra("Fname",fname.getText().toString());
            i.putExtra("Lname",lname.getText().toString());
            i.putExtra("Desc",desc.getText().toString());
            i.putExtra("Phone",ph.getText().toString());
            i.putExtra("Email",email.getText().toString());
            if(male.isChecked()){
                i.putExtra("Gender","Male");
            } else if (female.isChecked()) {
                i.putExtra("Gender","Female");
            }
            if(tbenroll.isChecked()){
                i.putExtra("Current","Enrolled");
            }else{
                i.putExtra("Current","UnEnrolled");
            }
            i.putExtra("Degree",qual+degree.getText().toString());
            i.putExtra("skill",skill.getText().toString());
            i.putExtra("Exp",s1.getSelectedItem().toString());
            startActivity(i);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK&&data!=null){
            Uri Selectimg=data.getData();
            img.setImageURI(Selectimg);
            image=Selectimg.toString();
            btn.setText("Change Image");
        }
    }
}