package com.gauravm.intentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class intentactivity2 extends AppCompatActivity {
    TextView tvname,tvphone,tvaddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intentactivity2);

        tvname=(TextView)findViewById(R.id.tvname);
        tvphone=(TextView)findViewById(R.id.tvphone);
        tvaddress=(TextView)findViewById(R.id.tvaddress);
        Intent objintent=getIntent();
        tvname.setText(objintent.getStringExtra("name"));
        tvphone.setText(objintent.getStringExtra("telephone"));
        tvaddress.setText(objintent.getStringExtra("address"));
    }
}
