package com.rzierfiz.peinit.UI;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;

import com.rzierfiz.peinit.MainActivity;
import com.rzierfiz.peinit.Pein.Pein;
import com.rzierfiz.peinit.R;

public class Element {
    private Context con;
    private Switch main;
    private Switch s1;
    private Switch s2;
    private ToggleButton b;
    private RadioGroup s1g;
    private RadioGroup s2g;
    private String[] rb1;
    private String[] rb2;
    private Pein pein;
    public Element(ToggleButton ab,RadioGroup arg,RadioGroup arg2,Switch sm,Switch sf)
    {
        con = MainActivity.con;
        b = ab;
        s1 = sm;
        s2 = sf;
        s1g = arg;
        s2g = arg2;
        rb1 = new String[]{"Random","Scream"};
        rb2 = new String[]{"Random","Boo","Explosion","Fart","Fart2","Cough","Sneeze","Stop","Troll Laugh"};
        pein = new Pein(MainActivity.sm);
        init();
    }
    void init()
    {
        for(String name:rb1)
        {
            addInRadioG(s1g,name);
        }
        for(String name:rb2)
        {
            addInRadioG(s2g,name);
        }
        ((RadioButton)s1g.getChildAt(0)).setChecked(true);
        ((RadioButton)s2g.getChildAt(0)).setChecked(true);
       ButDo(b);
        SwitchDo(s1);
        SwitchDo(s2);
        RadioDo(s1g);
        RadioDo(s2g);
    }
    void ButDo(ToggleButton but)
    {
        final ToggleButton b = but;
        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(b.isChecked())
                {
                    pein.work();
                    b.setBackgroundColor(Color.GREEN);

                }
                else{
                    pein.stop();
                    b.setBackgroundColor(Color.RED);
                }

            }
        });
    }
    void SwitchDo(Switch s)
    {
        final Switch temp = s;
        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(temp.isChecked()){
                   if(temp.getId() == R.id.move){
                       ///For move
                       pein.isMove = true;
                   }
                   else{
                       pein.isFall = true;
                       ///For Fall
                   }
                   ///Do Some If Checked
               }
               else{
                   pein.isMove = false;
                   pein.isFall = false;
                   //Don Else
               }
            }
        });
    }
    void RadioDo(RadioGroup rg)
    {
     rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup r,int id)
         {

             //Do Some
             if(r.getId() == s2g.getId())
                pein.getm(id - ((RadioButton)r.getChildAt(0)).getId());
             else
                 pein.getf(id - ((RadioButton)r.getChildAt(0)).getId());


             Log.e("Rg","" +id + ",Top :" + ((RadioButton)r.getChildAt(0)).getId());
         }
     });
    }
    void addInRadioG(RadioGroup rg,String name)
    {
        RadioButton curr = new RadioButton(con);
        curr.setText(name);
        rg.addView(curr);
    }


}
