package com.gauravm.clouds;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void gotoSecond(View view){
        editText=(EditText)findViewById(R.id.cityname);
        Intent intent=new Intent(Main2Activity.this,Main3Activity.class);
        intent.putExtra(editText.getText().toString(),"cityname");
        startActivity(intent);

    }
}
