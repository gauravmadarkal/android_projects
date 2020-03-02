package com.gauravm.listarrayadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView objlistview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    objlistview=(ListView)findViewById(R.id.listdata);
        objlistview.setOnItemClickListener(this);
        //create the string array to store values from the movie string
        //created in string.xml
        //access the strings.xml by get.resources and getstringarray methods
        String [] arrmovies=getResources().getStringArray(R.array.movienames);
       // ArrayList books=new ArrayList();
       // books.add("fifty shades of grey");
       // books.add("song of ice and fire");
        //books.add("shiva trilogy");
        //books.add("harry potter");
        //books.add("lord of rings");

        //create an array adapter object and pass the context
        //layout (in this case it is predesigned android.R.layout for row with a single text view
        ArrayAdapter objadapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrmovies);
    objlistview.setAdapter(objadapter);
        //set the adapter using the above method
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,"you clicked on the position:"+(position+1),Toast.LENGTH_LONG).show();

    }
}
