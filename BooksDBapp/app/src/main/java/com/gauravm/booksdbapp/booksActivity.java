package com.gauravm.booksdbapp;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class booksActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    databasehelper dbhelper;
    SimpleCursorAdapter simpleCursorAdapter;
    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);
    dbhelper=new databasehelper(this);
        displaybooks();
    }
    public void displaybooks(){
        Cursor cursor=dbhelper.getallbooks();
        String [] from=new String[]
                {
                        databasehelper.KEYAUTHORNAME,
                        databasehelper.KEYBOOKNAME,
                        databasehelper.KEYPUBLISHER,

                };
        int[] to=new int[]{
                R.id.tvauthor,
                R.id.tvbookname,
                R.id.tvpublisher
        };
    simpleCursorAdapter=new SimpleCursorAdapter(this,R.layout.rowinfo,cursor,from,to);
        listview=(ListView)findViewById(R.id.listbooks);
        listview.setAdapter(simpleCursorAdapter);
        listview.setOnItemClickListener(this);
    }




    @Override
    protected void onResume() {
        super.onResume();
        Cursor cursor=dbhelper.getallbooks();
        simpleCursorAdapter.swapCursor(cursor);
        listview.setAdapter(simpleCursorAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Cursor cursor=(Cursor)listview.getItemAtPosition(position);
        String strbooks=cursor.getString(cursor.getColumnIndexOrThrow(databasehelper.KEYBOOKNAME));
        String strauthor=cursor.getString(cursor.getColumnIndexOrThrow(databasehelper.KEYAUTHORNAME));
        String strpublisher=cursor.getString(cursor.getColumnIndexOrThrow(databasehelper.KEYPUBLISHER));
        Toast.makeText(this,strbooks+" "+strauthor+" "+strpublisher,Toast.LENGTH_LONG).show();
        Intent intent=new Intent(this,update.class);
        intent.putExtra("author",strauthor);
        intent.putExtra("bookname",strbooks);
        intent.putExtra("publisher",strpublisher);
        intent.putExtra("_id",id);
        startActivity(intent);
    }
}
