package com.gauravm.intentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etname,etphone,etaddress;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etname=(EditText)findViewById(R.id.etname);
        etphone=(EditText)findViewById(R.id.etphone);
        etaddress=(EditText)findViewById(R.id.etaddress);

    }
    public void gotosecond(View view){
        Intent objintent=new Intent(MainActivity.this,intentactivity2.class);
        objintent.putExtra("name",etname.getText().toString());
        objintent.putExtra("telephone",etphone.getText().toString());
        objintent.putExtra("address",etaddress.getText().toString());
        startActivity(objintent);

    }


}
