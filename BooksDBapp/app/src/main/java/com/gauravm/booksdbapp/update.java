package com.gauravm.booksdbapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class update extends AppCompatActivity {

    EditText updauthor,updbook,updpublisher;
    databasehelper dh;
    long lid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        updauthor=(EditText)findViewById(R.id.updauthor);
        updbook=(EditText)findViewById(R.id.updbook);
        updpublisher=(EditText)findViewById(R.id.updpublisher);
        Intent intent=getIntent();
        String strauthor=intent.getStringExtra("author");
        String strbooks=intent.getStringExtra("bookname");
        String strpublisher=intent.getStringExtra("publisher");
        lid=intent.getLongExtra("_id",2);
        updauthor.setText(strauthor);
        updbook.setText(strbooks);
        updpublisher.setText(strpublisher);
        dh=new databasehelper(this);
    }
   public void ondelete(View view) {
       AlertDialog.Builder alertdialogbuilder = new AlertDialog.Builder(this);
       alertdialogbuilder.setTitle(("booksdbapp"));
       alertdialogbuilder.setMessage("Are you sure you want to delete?");
       alertdialogbuilder.setPositiveButton("Yes",
               new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {
               try
               {
                   dh.deleteEntry(lid);
                   updauthor.setText("");
                   updbook.setText("");
                   updpublisher.setText("");
                   Toast.makeText(update.this, "Record has been deleted successfully", Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(update.this,booksActivity.class);
                   startActivity(intent);
                   finish();
               } catch (Exception e) {
                   Toast.makeText(update.this," "+e, Toast.LENGTH_LONG).show();
               }
           }
       });
        alertdialogbuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(update.this, "Delete not performed", Toast.LENGTH_SHORT).show();
            }
        });
       alertdialogbuilder.create();
       alertdialogbuilder.show();

   }

    public void onupdate(View view)
    {
    dh.updateEntry(lid,updbook.getText().toString()
            ,updauthor.getText().toString()
            ,updpublisher.getText().toString());
        Toast.makeText(this,"Record has been updated successfully",Toast.LENGTH_LONG).show();
    finish();
    }
}
