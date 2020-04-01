package com.rzierfiz.peinit.Pein;



import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.util.Log;

import com.rzierfiz.peinit.MainActivity;
import com.rzierfiz.peinit.R;

import java.io.FileDescriptor;
import java.io.InputStream;

public class TriggerPein {
    private MediaPlayer player;
    private MediaPlayer reply;
    private String fileLocation;
    private int Intensity;
    private int tolarance;
    private int[] vals;
    private int[] fallvals;
    private int [] replyvals;
    private Pein.kind p;
    public TriggerPein(Pein.kind pein)
    {
        p = pein;
        int Path = 0;
        init();
        switch(pein)
        {
            case Fall:{
                  Path = this.fallvals[rand(0,fallvals.length)];
            }
            break;
            case Move:{
                   Path = this.vals[rand(0,vals.length)];
                   Path = vals[2];
            }
            break;
        }
        player = MediaPlayer.create(MainActivity.con, Path);
    }
    void change(int id)
    {
        id--;
        int[] cval;
        if(p == Pein.kind.Fall)
            cval = fallvals;
        else
            cval = vals;
        player.reset();
        if(id == -1)
        player = MediaPlayer.create(MainActivity.con,cval[rand(0,cval.length - 1)]);
        else
        player = MediaPlayer.create(MainActivity.con,cval[id]);
    }
    void init()
    {
        player = new MediaPlayer();
        reply = new MediaPlayer();
        tolarance = 0;
        this.Intensity = 0;
        player.reset();
        vals = new int[]{R.raw.boo,R.raw.explosion,R.raw.fart,R.raw.fart2,R.raw.cough,R.raw.sneeze,R.raw.stop,R.raw.troll_laugh};
        reply = MediaPlayer.create(MainActivity.con,R.raw.thank_you);
        fallvals = new int[]{R.raw.scream};
    }
    public static int rand(int low,int high)
    {
        return (int)(Math.random()*high + low);
    }
    public void stop() {
        player.stop();
        reply.stop();
    }
    public void pause(){
        player.pause();
        reply.pause();
    }
    void ResponsePein(int Intensity)
    {
        if(Intensity == 0)
        {
            if(player.isPlaying())
            {

                player.pause();
                //reply.start();
            }
        }
        else
            if(!player.isPlaying())
            {
                player.seekTo(0);
                player.start();
            }

        float lv = 100,rv = 100;
        player.setVolume(lv,rv);
    }
    private void Reply()
    {

    }
    protected void finalize()
    {
        player.stop();
    }
}
