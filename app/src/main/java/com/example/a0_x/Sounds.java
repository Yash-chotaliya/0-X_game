package com.example.a0_x;

import android.content.Context;
import android.media.MediaPlayer;

public class Sounds {

    static void splash(Context context){
        final MediaPlayer player = MediaPlayer.create(context,R.raw.splashscreen);
        player.start();
    }
    static void point(Context context){
        final MediaPlayer player = MediaPlayer.create(context,R.raw.pointplus);
        player.start();
    }
    static void clicked(Context context){
        final MediaPlayer player = MediaPlayer.create(context,R.raw.click);
        player.start();
    }
    static void win(Context context){
        final MediaPlayer player = MediaPlayer.create(context,R.raw.winner);
        player.start();
    }
}
