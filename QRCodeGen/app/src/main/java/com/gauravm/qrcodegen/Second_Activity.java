package com.gauravm.qrcodegen;
import android.app.Activity;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Second_Activity extends AppCompatActivity {
        String value3,value4,name,age,gender;
        String uniquecode="xxxxxxx";
    String code;
    String A="Maui Thai",B="Jujutsu",C="Karate",D="Judo";
    String P="Cardio",Q="Strength",Ra="Stamina",S="Muscle";
    String V="Dance",W="Swimming",X="Running",Y="Football",Z="Rugby";
    CheckBox checkbox1,checkbox2,checkbox3,checkbox4,checkbox5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent objintent=getIntent();
        RadioGroup rg = (RadioGroup) findViewById(R.id.radiogroup3);
        value3 =
                ((RadioButton)findViewById(rg.getCheckedRadioButtonId()))
                        .getText().toString();
        RadioGroup rg2 = (RadioGroup) findViewById(R.id.radiogroup4);
        value4 =
                ((RadioButton)findViewById(rg.getCheckedRadioButtonId()))
                        .getText().toString();
        name=objintent.getStringExtra("name");
        age=objintent.getStringExtra("age");
        gender=objintent.getStringExtra("gender");
        if(age.equals("<10") || age.equals("10-15yrs") || gender.equals("Female")){
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
            code += "V:1";
        }
        if (checkbox2.isChecked()) {
            code += "W:1";
        }
        if (checkbox3.isChecked()) {
            code += "X:1";
        }
        if (checkbox4.isChecked()) {
            code += "Y:1";
        }
        if(checkbox5.isChecked()) {
            code += "Z:1";
        }
    uniquecode+=code;
        Toast.makeText(this,uniquecode,Toast.LENGTH_LONG).show();



    }

}

