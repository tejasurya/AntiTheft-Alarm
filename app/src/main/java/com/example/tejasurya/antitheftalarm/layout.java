package com.example.tejasurya.antitheftalarm;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class layout extends Activity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mSensor;
    ImageView iv;
    String extra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        extra = getIntent().getStringExtra("extra");
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        iv = (ImageView) findViewById(R.id.imageView1);

    }
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mSensor,
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
    public void onSensorChanged(SensorEvent event) {
        if (event.values[0] == 0) {
            iv.setImageResource(R.drawable.save);
        } else {
            String data=extra;
            Intent intent = new Intent(layout.this, login.class);
            intent.putExtra("extra", data);
            startActivity(intent);
            finish();
        }
    }

}
