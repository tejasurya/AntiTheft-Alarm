package com.example.tejasurya.antitheftalarm;
import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends Activity implements View.OnClickListener {
Button b;
    EditText et;
    String extra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=(EditText)findViewById(R.id.login_password);
        b=(Button)findViewById(R.id.button);
        b.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        String data=et.getText().toString();
        if(!data.equals("")){
        Intent intent = new Intent(MainActivity.this, layout.class);
        intent.putExtra("extra",data );
        startActivity(intent);
        finish();
    }else{
            Toast.makeText(this, "Invalid password", Toast.LENGTH_SHORT).show();
        }
    }

    }