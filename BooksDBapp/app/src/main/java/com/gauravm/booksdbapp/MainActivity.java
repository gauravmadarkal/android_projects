package com.gauravm.booksdbapp;

import android.content.Intent;
import android.database.DatabaseUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etauthor,etbookname,etpublisher;
    databasehelper dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etauthor=(EditText)findViewById(R.id.etauthorname);
        etbookname=(EditText)findViewById(R.id.etbookname);
        etpublisher=(EditText)findViewById(R.id.etpublisher);
    dbhelper=new databasehelper(this);

    }
    public void onsubmit(View view) {
        try {
            dbhelper.addbooks(etauthor.getText().toString(),
                    etbookname.getText().toString(),
                    etpublisher.getText().toString());
            Toast.makeText(this, "Record has been saved successfully", Toast.LENGTH_LONG).show();

        } catch (Exception e) {
            Log.i("onsubmit", e.toString());
            Toast.makeText(this,e.toString(), Toast.LENGTH_LONG).show();
        }
    }

    public  void onview(View view){
        Intent intent=new Intent(MainActivity.this,booksActivity.class);
        startActivity(intent);
    }
}
