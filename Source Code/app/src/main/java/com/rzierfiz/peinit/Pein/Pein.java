package com.rzierfiz.peinit.Pein;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.hardware.TriggerEventListener;
import android.util.Log;
import android.widget.TextView;

import com.rzierfiz.pein.SensorAPI.Sensors;
import com.rzierfiz.peinit.R;

public class Pein{
    private int Intensity;
    public  boolean isMove;
    public  boolean isFall;

    private SensorManager manager;
    private Sensors g;
    private Sensors a;
    private TriggerPein tpm;
    private TriggerPein tpf;
    private int gf;
    private int gm;
    public static enum kind{
      Fall,
      Move,
    }
    public Pein(SensorManager manager)
    {
        this.manager = manager;
        Intensity = 0;
        isMove = isFall = false;
        tpf = new TriggerPein(kind.Fall);
        tpm = new TriggerPein(kind.Move);
    }
   public void work() {
           g = new Sensors(manager, 0) {
                public void onSensorChanged(SensorEvent e) {
                        //G-Sensor
                    if(isMove)
                    {
                        calcIntensity(e.values);
                        tpm.ResponsePein(Intensity);
                    }

                }
            };
            a = new Sensors(manager, 1) {
                public void onSensorChanged(SensorEvent e) {
                    //Accelometer
                    if(isFall) {
                        new CollisionDetection(e.values) {
                            @Override
                            public void run() {
                                if (this.isCollision())
                                    tpf.ResponsePein(100);
                                    Log.e("ASensor","Works");
                            }
                        };
                    }
                }
            };
    }
    public void getf(int i)
    {
        Log.e("" + i + ":","Moe");
        tpf.change(i);
    }
    public void getm(int i)
    {
        Log.e("" + i + ":","Moe");
        tpm.change(i);
    }
    public void stop()
    {
        tpf.pause();
        tpm.pause();
       g.stop();
       a.stop();
    }
    void calcIntensity(float[] gsen)
    {
         if((int)gsen[0] != 0 || (int)gsen[1] != 0)
             this.Intensity = 100;
         else
             this.Intensity = 0;
    }

}
