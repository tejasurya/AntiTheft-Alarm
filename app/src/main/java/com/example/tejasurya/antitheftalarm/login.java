package com.example.tejasurya.antitheftalarm;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class login extends Activity implements View.OnClickListener {

    ImageView iv;
    String extra;
    EditText et;
    Button bt;
    MediaPlayer mp = new MediaPlayer();
    private SensorManager mSensorManager;
    private Sensor mSensor;

    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        extra = getIntent().getStringExtra("extra");
        iv = (ImageView) findViewById(R.id.imageView1);
        mp = MediaPlayer.create(this, R.raw.alarm);
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        iv = (ImageView) findViewById(R.id.imageView1);
            mp.start();
        bt=(Button)findViewById(R.id.button);
        bt.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        String x=et.getText().toString();
        if(x.equals(extra))
        {
            mp.stop();
            finish();
            Toast.makeText(this,"Keep your phone safe...",Toast.LENGTH_LONG).show();

        }
        else{
            Toast.makeText(this,"Wrong password...",Toast.LENGTH_SHORT).show();
            et.setText("");
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Your mobile is safe", Toast.LENGTH_SHORT).show();
    }
}
