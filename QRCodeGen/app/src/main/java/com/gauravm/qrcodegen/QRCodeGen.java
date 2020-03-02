package com.gauravm.qrcodegen;


import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;


public class QRCodeGen extends AppCompatActivity {

    String value,value2;
    EditText editText1;
    String radiovalue;
    ArrayList<String>buttonNames;
    RadioGroup radioGroup2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode_gen);
         editText1=(EditText)findViewById(R.id.editText2);


    }
    public void gotosecond(View view){
        radioGroup2 = (RadioGroup) findViewById(R.id.radiogroup2);
        buttonNames = new ArrayList<>();
        buttonNames.add("<10yrs");
        buttonNames.add("10-15yrs");
        buttonNames.add("16-40yrs");
        buttonNames.add(">40yrs");
        radioGroup2.setWeightSum(Float.parseFloat(buttonNames.size() + ""));
        radioGroup2.setBackgroundColor(Color.BLUE);


        for (int i = 0; i < buttonNames.size(); ++i) {

            RadioButton radioButton = new RadioButton(this);
            radioButton.setId(i);
            RadioGroup.LayoutParams childParam1 = new RadioGroup.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
            radioButton.setGravity(Gravity.CENTER);
            radioButton.setLayoutParams(childParam1);
            radioButton.setText(buttonNames.get(i));
            radioButton.setTextColor(Color.BLUE);
            radioButton.setBackgroundColor(Color.WHITE);
            radioButton.setButtonDrawable(null);
            if (buttonNames.get(i).equals("<10yrs")) {
                radioButton.setChecked(true);
                radioButton.setBackgroundColor(Color.BLUE);
                radioButton.setTextColor(Color.WHITE);
            }
            radioGroup2.addView(radioButton, childParam1);

        }


        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i1) {
                RadioButton button = null;

                for (int i = 0; i < buttonNames.size(); ++i) {
                    if (i1 == i) {
                        button = (RadioButton) findViewById(i1);
                        button.setChecked(true);
                        button.setBackgroundColor(Color.BLUE);
                        button.setTextColor(Color.WHITE);
                        Toast.makeText(getApplicationContext(), button.getText() + " checked", Toast.LENGTH_SHORT).show();
                    } else {
                        button = (RadioButton) findViewById(i);
                        button.setChecked(false);
                        button.setBackgroundColor(Color.WHITE);
                        button.setTextColor(Color.BLUE);
                    }
                }
            }
        });


        Intent objintent=new Intent(QRCodeGen.this,Second_Activity.class);
        objintent.putExtra("name",editText1.getText().toString());
        objintent.putExtra("age",value);
        objintent.putExtra("gender",value2);
    }
}
