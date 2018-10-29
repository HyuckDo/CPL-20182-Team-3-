package com.example.lastm.visual02;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE );

        Log.i("Act1", "start start start");
        final ImageButton start_game = (ImageButton) findViewById(R.id.start_Button);

        start_game.setOnClickListener(
                new View.OnClickListener(){
                        public void onClick(View v){
                            Log.i("Act1", "start start start/");
                            Intent start_display = new Intent(Main2Activity.this, game1.class);
                            Log.i("Act1", "start start start//");
                            startActivity(start_display);
                            finish();

                        }
                    }

        );


    }














}
