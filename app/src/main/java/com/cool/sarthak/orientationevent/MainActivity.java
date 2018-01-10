package com.cool.sarthak.orientationevent;

import android.content.Intent;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.OrientationEventListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    OrientationEventListener myOrientationEventListener;
    TextView textviewOrientation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myOrientationEventListener
                = new OrientationEventListener(this, SensorManager.SENSOR_DELAY_NORMAL){

            @Override
            public void onOrientationChanged(int arg0) {
                // TODO Auto-generated method stub\
                textviewOrientation=findViewById(R.id.degree);
//                if(arg0==180) {
//                    Intent intent =new Intent(MainActivity.this, Main2Activity.class);
//                    startActivity(intent);
//                }

                textviewOrientation.setText("Orientation: " + String.valueOf(arg0));
            }};

        if (myOrientationEventListener.canDetectOrientation()){
            Toast.makeText(this, "Can DetectOrientation", Toast.LENGTH_LONG).show();
            myOrientationEventListener.enable();
        }
        else{
            Toast.makeText(this, "Can't DetectOrientation", Toast.LENGTH_LONG).show();
            finish();
        }

    }
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        myOrientationEventListener.disable();
    }
}
