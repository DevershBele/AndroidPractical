package com.ameya.gesturecolor;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager smgr;
    private boolean colour = false;
    private long lastUpdate;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView) findViewById(R.id.tv1);
        tv1.setBackgroundColor(Color.YELLOW);
        smgr = (SensorManager) this.getSystemService(SENSOR_SERVICE);
        lastUpdate = System.currentTimeMillis();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType()== Sensor.TYPE_ACCELEROMETER){
            getAcclerometer(event);
        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor , int accuracy){}

    private void getAcclerometer(SensorEvent event){
        float[] values = event.values;

        float x = values[0];
        float y = values[1];
        float z = values[2];

        float accelarationSquareRoot = (x*x + y*y + z*z) / (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
        long actualTime = event.timestamp;
        if(accelarationSquareRoot >= 2) {
            if(actualTime - lastUpdate < 200) {
                return;
            }
            lastUpdate = actualTime;
            Toast.makeText(MainActivity.this, "Device Moved", Toast.LENGTH_LONG).show();
            if (colour){
                tv1.setBackgroundColor(Color.GREEN);
            } else {
                tv1.setBackgroundColor(Color.CYAN);
            }
            colour = !colour;

        }
    }



    @Override
    protected void onResume()
    {
        super.onResume();
        smgr.registerListener(this, smgr.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        smgr.unregisterListener(this);

    }
}