package com.gauravm.helloafternoonbatch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tvdisplaymessage;
    private EditText etgetmessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"hello from oncreate()",Toast.LENGTH_LONG).show();
       //we are initializing the object to its corresponding view in the xml layout file
        tvdisplaymessage=(TextView)findViewById(R.id.tvmessage);
        etgetmessage=(EditText)findViewById(R.id.etmymessage);
    }
    //method to display message in the text view after button click
    //we need to pass the view object to this method
    //as the object binds the view and the java method
    public void showmessage(View view){
        tvdisplaymessage.setText("thank you for clicking..."+etgetmessage.getText().toString());}

//to go from first activity to second
   public void gotosecondactivity(View view){
       Intent objintent= new Intent(MainActivity.this,secondActivity.class);
 startActivity(objintent);
   }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"hello from onstart()",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"hello from onresume()",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,"hello from onpause()",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"hello from onstop()",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"hello from ondestroy()",Toast.LENGTH_LONG).show();
    }

}
