package com.ameya.btapp;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Set;

public class MainActivity extends AppCompatActivity {
    Button on,off,pd;
    TextView tv1,tv2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        on = (Button) findViewById(R.id.on);
        off = (Button) findViewById(R.id.off);
        pd = (Button) findViewById(R.id.pd);

        tv2 = (TextView) findViewById(R.id.pdv);

        BluetoothAdapter ba = BluetoothAdapter.getDefaultAdapter();

        on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ba == null)
                {
                    Toast.makeText(MainActivity.this,"No Bluetooh",Toast.LENGTH_LONG).show();

                }
                else
                {
                    if(!ba.isEnabled())
                    {
                        Intent turn_on = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                        startActivity(turn_on);

                    }
                }
            }
        });
        off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ba.isEnabled())
                {
                    ba.disable();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Turn On Bluetooth First",Toast.LENGTH_LONG).show();
                }
            }
        });
        pd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ba == null)
                {
                    Toast.makeText(MainActivity.this,"No Bluetooth",Toast.LENGTH_LONG).show();

                }
                else
                    {
                        final Set<BluetoothDevice> devices = ba.getBondedDevices();
                        if(devices.size()>0)
                        {
                            for (BluetoothDevice device : devices)
                            {
                              String dname = device.getName();
                              String add = device.getAddress();

                              tv2.setText("Name of the device "+dname+" Address of the device "+add);
                            }
                    }
                }

            }
        });
    }
}