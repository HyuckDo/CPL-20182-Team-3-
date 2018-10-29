package com.example.lastm.visual02;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE );

        final ImageButton Image_start = (ImageButton) findViewById(R.id.balloon_start_Button);

        Image_start.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Intent intent1 = new Intent(MainActivity.this, Main2Activity.class);
                        startActivity(intent1);
                        finish();

                    }
                }
        );



    }
    @Override
    protected void onStop(){

        super.onStop();
    }


}
