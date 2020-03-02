package com.gauravm.mydictionary;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.gauravm.mydictionary.AlphabetListAdapter;
import com.gauravm.mydictionary.AlphabetListAdapter.Row;
import com.gauravm.mydictionary.AlphabetListAdapter.Item;
import com.gauravm.mydictionary.AlphabetListAdapter.Section;
import java.io.BufferedReader;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Pattern;
import android.app.ListActivity;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private AlphabetListAdapter adapter = new AlphabetListAdapter();

    ListView listView;
    private List<Object[]> alphabet = new ArrayList<Object[]>();
    private HashMap<String, Integer> sections = new HashMap<String, Integer>();


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        String data = "";
        String str = "";
        String words[];
        int i=0;
        int j=0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_alphabet);
        listView=(ListView)findViewById(R.id.list1);


        List<String> items = new ArrayList<String>();

        InputStream is = this.getResources().openRawResource(R.raw.textdata);
        StringBuffer sbuffer = new StringBuffer();
        BufferedReader reader = new BufferedReader(new InputStreamReader
                (is));

        if (is != null) {
            try {
                while ((data = reader.readLine()) != null) {
                    str += data;
                }


                is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        str = str.toLowerCase();

        words = str.split(" ");
        Set<String> hs = new HashSet<>(Arrays.asList(words));
        List<String> sortedwords = new ArrayList(hs);
        Collections.sort(sortedwords);
        int len = sortedwords.size();
        while (i != len) {
            sbuffer.append(sortedwords.get(i) + "\n");
            i++;
        }


        List<Row> rows = new ArrayList<Row>();
        int start = 0;
        int end = 0;
        String previousLetter = null;
        Object[] tmpIndexItem = null;
        Pattern numberPattern = Pattern.compile("[0-9]");
        int[] rainbow=this.getResources().getIntArray(R.array.rainbow);
        for (String words1 : sortedwords) {
            String firstLetter = words1.substring(0, 1);
            firstLetter = firstLetter.toUpperCase();


            // Group numbers together in the scroller
            if (numberPattern.matcher(firstLetter).matches()) {
                firstLetter = "#";
            }

            // If we've changed to a new letter, add the previous letter to the alphabet scroller
            if (previousLetter != null && !firstLetter.equals(previousLetter)) {
                end = rows.size() - 1;
                tmpIndexItem = new Object[3];
                tmpIndexItem[0] = previousLetter.toUpperCase(Locale.UK);
                tmpIndexItem[1] = start;
                tmpIndexItem[2] = end;
                alphabet.add(tmpIndexItem);

                start = end + 1;
            }

            // Check if we need to add a header row
            if (!firstLetter.equals(previousLetter)) {

                rows.add(new Section(firstLetter,rainbow[j]));
                sections.put(firstLetter, start);
                j++;

            }

            // Add  to the list
            rows.add(new Item(words1));
            previousLetter = firstLetter;
        }


        if (previousLetter != null) {
            // Save the last letter
            tmpIndexItem = new Object[3];
            tmpIndexItem[0] = previousLetter.toUpperCase(Locale.UK);
            tmpIndexItem[1] = start;
            tmpIndexItem[2] = rows.size() - 1;
            alphabet.add(tmpIndexItem);
        }


        adapter.setRows(rows);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);

    }
    @Override
     public void onItemClick(AdapterView<?> parent, View view, int position, long id){

      Item item=(Item) adapter.getItem(position);
        String name=item.text;
        Intent intent=new Intent(this,Main2Activity.class);
        intent.putExtra("word",name);
        startActivity(intent);

    }

    }



