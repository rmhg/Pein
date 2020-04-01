package com.rzierfiz.peinit;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.rzierfiz.peinit.UI.Element;

public class MainActivity extends AppCompatActivity {
    public static Context con;
    public static SensorManager sm;
    Element e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        con = getApplicationContext();
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        e = new Element((ToggleButton) findViewById(R.id.main),(RadioGroup) findViewById(R.id.radioGroup),(RadioGroup) findViewById(R.id.radioGroup2),(Switch) findViewById(R.id.move),(Switch) findViewById(R.id.fall));
        Init();
    }
    void Init()
    {
        ((TextView)findViewById(R.id.about)).setText("App Is Created By Rzier Fiz \nVisit https://www.github.com/rmhg For Source Code And More Projects");
    }
}
