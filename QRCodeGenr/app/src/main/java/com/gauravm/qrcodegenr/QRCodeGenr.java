package com.gauravm.qrcodegenr;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class QRCodeGenr extends AppCompatActivity {
    String value, value2;
    EditText editText1;
    String age,gender;
    ArrayList<String> buttonNames;
    ArrayList<String> buttonNames1;
    RadioGroup radioGroup2, radioGroup1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode_genr);

    }

    public void gotosecond(View view) {
        EditText editText1=(EditText)findViewById(R.id.edittext1);
        radioGroup1 = (RadioGroup) findViewById(R.id.radiogroup1);
        radioGroup2 = (RadioGroup) findViewById(R.id.radiogroup2);
        buttonNames = new ArrayList<>();
        buttonNames.add("<10yrs");
        buttonNames.add("10-15yrs");
        buttonNames.add("16-40yrs");
        buttonNames.add(">40yrs");
        radioGroup1.setWeightSum(Float.parseFloat(buttonNames.size() + ""));
        buttonNames1 = new ArrayList<>();
        buttonNames1.add("Male");
        buttonNames1.add("Female");
        buttonNames1.add("Other");
        radioGroup2.setWeightSum(Float.parseFloat(buttonNames1.size() + ""));

        for (int i = 0; i < buttonNames.size(); ++i) {

            RadioButton radioButton1 = new RadioButton(this);
            radioButton1.setId(i);
            RadioGroup.LayoutParams childParam1 = new RadioGroup.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
            radioButton1.setGravity(Gravity.CENTER);
            radioButton1.setLayoutParams(childParam1);
            radioButton1.setText(buttonNames.get(i));
            radioButton1.setTextColor(Color.BLUE);

            radioButton1.setButtonDrawable(null);

            radioGroup1.addView(radioButton1, childParam1);

        }
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i1) {
                RadioButton button = null;

                for (int i = 0; i < buttonNames.size(); ++i) {
                    if (i1 == i) {
                        button = (RadioButton) findViewById(i1);
                        button.setChecked(true);

                        button.setTextColor(Color.WHITE);
                        Toast.makeText(getApplicationContext(), button.getText() + " checked", Toast.LENGTH_SHORT).show();
                    } else {
                        button = (RadioButton) findViewById(i);
                        button.setChecked(false);
                        button.setTextColor(Color.BLUE);
                    }
                }
            }
        });
        int selectedId = radioGroup1.getCheckedRadioButtonId();
        RadioButton radiobutton= (RadioButton) findViewById(selectedId);
        age=radiobutton.getText().toString();


        for (int i = 0; i < buttonNames1.size(); ++i) {

            RadioButton radioButton1 = new RadioButton(this);
            radioButton1.setId(i);
            RadioGroup.LayoutParams childParam1 = new RadioGroup.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
            radioButton1.setGravity(Gravity.CENTER);
            radioButton1.setLayoutParams(childParam1);
            radioButton1.setText(buttonNames1.get(i));
            radioButton1.setTextColor(Color.BLUE);

            radioButton1.setButtonDrawable(null);

            radioGroup2.addView(radioButton1, childParam1);

        }
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i1) {
                RadioButton button = null;

                for (int i = 0; i < buttonNames1.size(); ++i) {
                    if (i1 == i) {
                        button = (RadioButton) findViewById(i1);
                        button.setChecked(true);

                        button.setTextColor(Color.WHITE);
                        Toast.makeText(getApplicationContext(), button.getText() + " checked", Toast.LENGTH_SHORT).show();
                    } else {
                        button = (RadioButton) findViewById(i);
                        button.setChecked(false);
                        button.setTextColor(Color.BLUE);
                    }
                }
            }
        });
        int selectedId1 = radioGroup2.getCheckedRadioButtonId();
        RadioButton radiobutton1 = (RadioButton) findViewById(selectedId1);
        gender=radiobutton1.getText().toString();

        Intent intent=new Intent(this,SecondActivity.class);
        intent.putExtra("name",editText1.getText());
        intent.putExtra("age",age);
        intent.putExtra("gender",gender);
        startActivity(intent);
    }

}
