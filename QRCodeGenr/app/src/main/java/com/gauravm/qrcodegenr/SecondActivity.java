package com.gauravm.qrcodegenr;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    String value3,value4,name,age,gender;
    String uniquecode="xxxxxxx";
    String code;
    String A="Maui Thai",B="Karate",C="Jujutsu",D="Judo";
    String P="Cardio",Q="Strength",Ra="Stamina",S="Muscle";
    String V="Dance",W="Swimming",X="Running",Y="Football",Z="Rugby";
    CheckBox checkbox1,checkbox2,checkbox3,checkbox4,checkbox5;
    ArrayList<String> buttonNames2;
    ArrayList<String> buttonNames3;
    ArrayList<String> buttonNames4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

    }
    public void generate(View view){
        Intent objintent=getIntent();
        name=objintent.getStringExtra("name");
        age=objintent.getStringExtra("age");
        gender=objintent.getStringExtra("gender");
        RadioGroup radioGroup3=(RadioGroup)findViewById(R.id.radiogroup3);
        RadioGroup radioGroup4=(RadioGroup)findViewById(R.id.radiogroup4);
        buttonNames2 = new ArrayList<>();
        buttonNames2.add("Maui Thai");
        buttonNames2.add("Jujutsu");
        buttonNames2.add("Karate");
        buttonNames2.add("Judo");
        radioGroup3.setWeightSum(Float.parseFloat(buttonNames2.size() + ""));  buttonNames2 = new ArrayList<>();
        buttonNames3 = new ArrayList<>();
        buttonNames3.add("Cardio");
        buttonNames3.add("Strength");
        buttonNames3.add("Stamina");
        buttonNames3.add("Muscle");
        radioGroup4.setWeightSum(Float.parseFloat(buttonNames3.size() + ""));  buttonNames3 = new ArrayList<>();
        for (int i = 0; i < buttonNames2.size(); ++i) {

            RadioButton radioButton = new RadioButton(this);
            radioButton.setId(i);
            RadioGroup.LayoutParams childParam1 = new RadioGroup.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
            radioButton.setGravity(Gravity.CENTER);
            radioButton.setLayoutParams(childParam1);
            radioButton.setText(buttonNames2.get(i));
            radioButton.setTextColor(Color.BLUE);

            radioButton.setButtonDrawable(null);
            if (buttonNames2.get(i).equals("Maui Thai")) {
                radioButton.setChecked(true);
                radioButton.setTextColor(Color.WHITE);
            }
            radioGroup3.addView(radioButton, childParam1);

        }


        radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i1) {
                RadioButton button = null;

                for (int i = 0; i < buttonNames2.size(); ++i) {
                    if (i1 == i) {
                        button = (RadioButton) findViewById(i1);
                        button.setChecked(true);

                        button.setTextColor(Color.WHITE);

                    } else {
                        button = (RadioButton) findViewById(i);
                        button.setChecked(false);
                        button.setBackgroundColor(Color.WHITE);
                        button.setTextColor(Color.BLUE);
                    }
                }
            }
        });
        int selectedId = radioGroup3.getCheckedRadioButtonId();
        RadioButton radiobutton5 = (RadioButton) findViewById(selectedId);
        value3=radiobutton5.getText().toString();
        Toast.makeText(this,value3,Toast.LENGTH_SHORT).show();
        for (int i = 0; i < buttonNames3.size(); ++i) {

            RadioButton radioButton = new RadioButton(this);
            radioButton.setId(i);
            RadioGroup.LayoutParams childParam1 = new RadioGroup.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
            radioButton.setGravity(Gravity.CENTER);
            radioButton.setLayoutParams(childParam1);
            radioButton.setText(buttonNames3.get(i));
            radioButton.setTextColor(Color.BLUE);

            radioButton.setButtonDrawable(null);
            if (buttonNames3.get(i).equals("Maui Thai")) {
                radioButton.setChecked(true);
                radioButton.setTextColor(Color.WHITE);
            }
            radioGroup4.addView(radioButton, childParam1);

        }


        radioGroup4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i1) {
                RadioButton button = null;

                for (int i = 0; i < buttonNames4.size(); ++i) {
                    if (i1 == i) {
                        button = (RadioButton) findViewById(i1);
                        button.setChecked(true);

                        button.setTextColor(Color.WHITE);
                    } else {
                        button = (RadioButton) findViewById(i);
                        button.setChecked(false);
                        button.setBackgroundColor(Color.WHITE);
                        button.setTextColor(Color.BLUE);
                    }
                }
            }
        });
        int selectedId1 = radioGroup4.getCheckedRadioButtonId();
        RadioButton radiobutton6 = (RadioButton) findViewById(selectedId1);
        value4=radiobutton6.getText().toString();

        if(age.equals("<10yrs") || age.equals("10-15yrs") || gender.equals("Female")){

            if(value3.equals(A)){
                uniquecode+="A:1B:0C:0D:0";
            }
            else if(value3.equals(B)){
                uniquecode+="A:0B:1C:0D:0";

            }
            else if(value3.equals(C)){
                uniquecode+="A:0B:0C:1D:0";
            }
            else if(value3.equals(D)){
                uniquecode+="A:0B:0C:0D:1";
            }
            else{

            }

        }
        if((age.equals("16-40yrs")||age.equals(">40yrs")) && gender.equals("Male")){
            if(value3.equals(A)){
                uniquecode+="A:2B:0C:0D:0";
            }
            else if(value3.equals(B)){
                uniquecode+="A:0B:2C:0D:0";

            }
            else if(value3.equals(C)){
                uniquecode+="A:0B:0C:2D:0";
            }
            else if(value3.equals(D)){
                uniquecode+="A:0B:0C:0D:2";
            }
            else{
                uniquecode+="A:0B:0C:0D:0";
            }
        }


        if(value4.equals(P)){


            uniquecode+="P:1Q:0R:0S:0";
        }
        else if(value4.equals(Q)) {
            uniquecode +="P:0Q:1R:0S:0";
        }
        else if(value4.equals(Ra)) {
            uniquecode +="P:0Q:0Ra:1S:0";
        }
        else if(value4.equals(S)) {
            uniquecode +="P:0Q:0Ra:0S:1";
        }
        else
        {
            uniquecode +="P:0Q:0Ra:0S:0";
        }
        checkbox1=(CheckBox)findViewById(R.id.checkBox1);
        checkbox2=(CheckBox)findViewById(R.id.checkBox2);
        checkbox3=(CheckBox)findViewById(R.id.checkBox3);
        checkbox4=(CheckBox)findViewById(R.id.checkBox4);
        checkbox5=(CheckBox)findViewById(R.id.checkBox5);
        if(checkbox1.isChecked()) {
            code = "V:1W:0X:0Y:0Z:0";

            if (checkbox2.isChecked()) {
                code = "V:1W:1X:0Y:0Z:0";

                if (checkbox3.isChecked()) {
                    code = "V:1W:1X:1Y:0Z:0";

                    if (checkbox4.isChecked()) {
                        code = "V:1W:1X:1Y:1Z:0";

                        if (checkbox5.isChecked()) {
                            code = "V:1W:1X:1Y:1Z:1";
                        }
                    }
                }
            }
        }

        uniquecode+=code;


    Intent intent=new Intent(this,FourthActivity.class);
        intent.putExtra("qrcode",uniquecode);
        startActivity(intent);


    }
}
