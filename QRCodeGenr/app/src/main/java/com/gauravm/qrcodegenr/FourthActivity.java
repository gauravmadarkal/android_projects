package com.gauravm.qrcodegenr;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class FourthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        Intent objintent=getIntent();
        String qrcode=objintent.getStringExtra("qrcode");
        ImageView image=(ImageView)findViewById(R.id.image);
        MultiFormatWriter multiFormatWriter=new MultiFormatWriter();
        try{
            BitMatrix bitmatrix=multiFormatWriter.encode(qrcode, BarcodeFormat.QR_CODE,200,200);
            BarcodeEncoder barcodeencoder=new BarcodeEncoder();
            Bitmap bitmap=barcodeencoder.createBitmap(bitmatrix);
            image.setImageBitmap(bitmap);
        }catch(WriterException e){
            e.printStackTrace();
        }
    }
}
