package com.gauravm.mydictionary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int[] rainbow=this.getResources().getIntArray(R.array.rainbow);
        int i=0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView=(TextView)findViewById(R.id.textview2);
        Intent intent=getIntent();
        String word=intent.getStringExtra("word");
        textView.setText(word);
        if(word.startsWith("a")){
            textView.setTextColor(rainbow[0]);
            
        }
        else if(word.startsWith("b")){
            textView.setTextColor(rainbow[1]);
            
        }
        else if(word.startsWith("c")){
            textView.setTextColor(rainbow[2]);
            
        }
        else if(word.startsWith("d")){
            textView.setTextColor(rainbow[3]);
            
        }
        else if(word.startsWith("e")){
            textView.setTextColor(rainbow[4]);
            
        }
        else if(word.startsWith("f")){
            textView.setTextColor(rainbow[5]);
            
        }
        else if(word.startsWith("g")){
            textView.setTextColor(rainbow[6]);
            
        }
        else if(word.startsWith("h")){
            textView.setTextColor(rainbow[7]);
            
        } else if(word.startsWith("i")){
            textView.setTextColor(rainbow[8]);
            
        }
        else if(word.startsWith("j")){
            textView.setTextColor(rainbow[9]);
            
        }
        else if(word.startsWith("k")){
            textView.setTextColor(rainbow[10]);
            
        }
        else if(word.startsWith("l")){
            textView.setTextColor(rainbow[11]);
            
        } else if(word.startsWith("m")){
            textView.setTextColor(rainbow[12]);
            
        }
        else if(word.startsWith("n")){
            textView.setTextColor(rainbow[13]);
            
        }
        else if(word.startsWith("o")){
            textView.setTextColor(rainbow[14]);
            
        }
        else if(word.startsWith("p")){
            textView.setTextColor(rainbow[15]);
            
        } else if(word.startsWith("q")){
            textView.setTextColor(rainbow[16]);
            
        } else if(word.startsWith("r")){
            textView.setTextColor(rainbow[17]);
            
        } else if(word.startsWith("s")){
            textView.setTextColor(rainbow[18]);
            
        } else if(word.startsWith("t")){
            textView.setTextColor(rainbow[19]);
            
        } else if(word.startsWith("u")){
            textView.setTextColor(rainbow[20]);
            
        } else if(word.startsWith("v")){
            textView.setTextColor(rainbow[21]);
            
        } else if(word.startsWith("w")){
            textView.setTextColor(rainbow[22]);
            
        } else if(word.startsWith("x")){
            textView.setTextColor(rainbow[23]);
            
        } else if(word.startsWith("y")){
            textView.setTextColor(rainbow[24]);
            
        } else if(word.startsWith("z")){
            textView.setTextColor(rainbow[25]);
            
        }


    }
}
