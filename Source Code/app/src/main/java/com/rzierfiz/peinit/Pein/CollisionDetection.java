package com.rzierfiz.peinit.Pein;

import android.util.Log;

abstract public class CollisionDetection {
    private float[] vals;
    public CollisionDetection(float[] e)
    {
        this.vals = e;
        run();
    }
    boolean isCollision() {

        for (int i = 0; i < vals.length; i++) {
            float temp = vals[i];
            if (temp >= 35) {
                return true;
            }
        }
        return false;
    }
    abstract void run();
}
