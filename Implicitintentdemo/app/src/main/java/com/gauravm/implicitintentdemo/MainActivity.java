package com.gauravm.implicitintentdemo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void setbtnsms(View view){
        try{
            Intent smsIntent=new Intent(Intent.ACTION_VIEW);
            smsIntent.setType("vnd.android-dir/mms-sms");
            smsIntent.putExtra("address","7204821911");
            smsIntent.putExtra("sms_body","i am in the body");
            startActivity(smsIntent);
            //this is for nougat version
            //Uri uri=uri.parse("smsto:99999999");
            // Intent it=new Intent(Intent.ACTION_SENDTO,uri);
            //it.putExtra("sms_body","i am in body");
            //startActivity(it);
        }
        catch(Exception e)
        {
            Log.d("Exception sms:",e.toString());
            Toast.makeText(this,e.toString(),Toast.LENGTH_LONG).show();


        }

    }
    public void setbtnemail(View view)
    {
        //utilize intent object and send static variable ACTION_send
        Intent intent=new Intent(Intent.ACTION_SEND);
        //set the email format type
        intent.setType("text/html");
        //add the to addresses as a string array
        intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"madarkal.gaurav@gmail.com","abc@acd.com"});
        //add the cc addresses as astring array
        intent.putExtra(Intent.EXTRA_CC,new String[]{"asd@asd.com","xyz@xyz.com"});
        //add a bcc addresses
        intent.putExtra(Intent.EXTRA_BCC,new String[]{"asdc@asdc.com","xyzc@xyzc.com"});
        //add subject
        intent.putExtra(Intent.EXTRA_SUBJECT,"welcome to android");
        //add mail body
        intent.putExtra(Intent.EXTRA_TEXT,"i am in the body");
        //create a chooser to select from multiple email apps
        startActivity(Intent.createChooser(intent,"Send Email"));
    }
    public void setbtnbrowser(View view)
    {
        String url="http://www.google.com";
        Intent i=new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);

    }
}

