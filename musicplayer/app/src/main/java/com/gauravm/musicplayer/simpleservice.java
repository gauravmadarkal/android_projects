package com.gauravm.musicplayer;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by USER on 23-06-2017.
 */

public class simpleservice extends Service {
    MediaPlayer mediaplayer;
    @Override
    public void onCreate(){
        Toast.makeText(this,"Simple service",Toast.LENGTH_SHORT).show();
        mediaplayer=new MediaPlayer();
        mediaplayer=MediaPlayer.create(this,R.raw.song);


    }

    @Override
    public int onStartCommand(Intent intent,int flags,int startId){
        Toast.makeText(this,"this service started",Toast.LENGTH_SHORT).show();
        mediaplayer.start();
        return super.onStartCommand(intent,flags,startId);

    }
    public void onDestroy(Intent intent,int flags,int startId){
        Toast.makeText(this,"this service stopped",Toast.LENGTH_SHORT).show();
        mediaplayer.stop();
        super.onDestroy();


    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
