package com.gauravm.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void btnstart(View view){
        Intent intent= new Intent(this,simpleservice.class);
        startService(intent);
    }
    public void btnstop(View view){
        Intent intent= new Intent(this,simpleservice.class);
        stopService(intent);
    }
}
