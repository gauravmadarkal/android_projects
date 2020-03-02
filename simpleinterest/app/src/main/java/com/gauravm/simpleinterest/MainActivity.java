package com.gauravm.simpleinterest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et1,et2,et3;
    TextView displaymessage;
    double interest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.editText);
        et2=(EditText)findViewById(R.id.editText2);
        et3=(EditText)findViewById(R.id.editText3);
        displaymessage=(TextView)findViewById(R.id.textView);}


    public void calculateinterest(View view){
        String value1=et1.getText().toString();
        String value2=et2.getText().toString();
        String value3=et3.getText().toString();
        int principle=Integer.parseInt(value1);
        int time=Integer.parseInt(value2);
        float rate=Float.valueOf(value3);
        interest=(principle*time*rate*0.01);
        displaymessage.setText("the simple interest is="+interest);
    }
}
