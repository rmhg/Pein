package com.rzierfiz.pein.SensorAPI;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/*
* @author Rahul Mishra
* This Class Is sensor API For Other Class
*/

abstract public class Sensors implements SensorEventListener {
    private float[] vals;  // Vals...
    private Sensor newSensor;
    private SensorManager Manage;
    public Sensors(SensorManager m,int x)
    {
        Manage = m;
        init(x);

    }
    private void init(int x)
    {
        if(x == 0)
        newSensor = Manage.getDefaultSensor(Sensor.TYPE_GRAVITY);
        else
            newSensor = Manage.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        Manage.registerListener(this,newSensor,SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    abstract public void onSensorChanged(SensorEvent e);
    public void onAccuracyChanged(Sensor s,int i) {

    }
    public float[] getVal()
    {
       return vals;
    }
    public void stop()
    {
        Manage.unregisterListener(this);
    }
}
