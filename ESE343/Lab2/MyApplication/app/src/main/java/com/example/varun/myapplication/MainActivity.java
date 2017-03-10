package com.example.varun.myapplication;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static android.R.attr.value;

public class MainActivity extends AppCompatActivity implements SensorListener {
    private SensorManager sensorManager;
    private Sensor accelerometer;

    public void connectToAccelerometer{
        sensorManager=(SensorManager) getSystemService(SENSOR_MANAGER);
        accelerometer=sensorManager.registerListener(this,accelerometer,SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        value = event.values[0];
        new Thread(new Runnable(){
            @Override
            public void run() {
                lightLevel.setText("Light level is "+ value+" lx");
            }
        }).start();


    }
    private class lightThread implements Runnable{
        public void run(){}
    }
    // Called when a registered sensor's accuracy changes
    @Override
    public void onAccuracyChanged(Sensor arg0, int arg1) {
        // TODO Auto-generated method stub

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);

    }

}
