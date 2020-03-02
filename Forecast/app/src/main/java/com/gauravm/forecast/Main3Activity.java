package com.gauravm.forecast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main3Activity extends AppCompatActivity {
        EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }
    public void gotoSecond(View view){
        editText=(EditText)findViewById(R.id.cityname);
        Intent intent=new Intent(Main3Activity.this,Main2Activity.class);
        intent.putExtra(editText.getText().toString(),"cityname");
        startActivity(intent);

    }
}
