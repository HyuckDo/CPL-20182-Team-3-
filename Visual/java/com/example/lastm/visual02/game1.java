package com.example.lastm.visual02;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.media.Image;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.VisualVoicemailService;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;
import java.util.ArrayList;

public class game1 extends AppCompatActivity {

    ImageView icon_blue, icon_yellow, icon_green, icon_red, icon_purple; // 처음 나오는 풍선
    ImageView bg;

    ImageButton[] button;
    ImageButton[] rand_button;


    int x = 0, y = 0; // 좌표
    int size_x = 1600, size_y = 500; // 최대 좌표
    int rand_num, corrent_num; // 랜덤

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        icon_blue = (ImageView) findViewById(R.id.icon_blue);
        icon_yellow = (ImageView) findViewById(R.id.icon_yellow);
        icon_green = (ImageView) findViewById(R.id.icon_green);
        icon_red = (ImageView) findViewById(R.id.icon_red);
        icon_purple = (ImageView) findViewById(R.id.icon_purple);

        button = new ImageButton[20];

        button[0] = (ImageButton) findViewById(R.id.balloon_button_blue);
        button[1] = (ImageButton) findViewById(R.id.balloon_button_blue1);
        button[2] = (ImageButton) findViewById(R.id.balloon_button_blue2);
        button[3] = (ImageButton) findViewById(R.id.balloon_button_blue3);

        button[4] = (ImageButton) findViewById(R.id.balloon_button_yellow);
        button[5] = (ImageButton) findViewById(R.id.balloon_button_yellow1);
        button[6] = (ImageButton) findViewById(R.id.balloon_button_yellow2);
        button[7] = (ImageButton) findViewById(R.id.balloon_button_yellow3);

        button[8] = (ImageButton) findViewById(R.id.balloon_button_purple);
        button[9] = (ImageButton) findViewById(R.id.balloon_button_purple1);
        button[10] = (ImageButton) findViewById(R.id.balloon_button_purple2);
        button[11] = (ImageButton) findViewById(R.id.balloon_button_purple3);

        button[12] = (ImageButton) findViewById(R.id.balloon_button_red);
        button[13] = (ImageButton) findViewById(R.id.balloon_button_red1);
        button[14] = (ImageButton) findViewById(R.id.balloon_button_red2);
        button[15] = (ImageButton) findViewById(R.id.balloon_button_red3);

        button[16] = (ImageButton) findViewById(R.id.balloon_button_green);
        button[17] = (ImageButton) findViewById(R.id.balloon_button_green1);
        button[18] = (ImageButton) findViewById(R.id.balloon_button_green2);
        button[19] = (ImageButton) findViewById(R.id.balloon_button_green3);


        for (int i = 0; i < 4; i++) {
            button[i].setImageResource(R.drawable.balloon_blue0001);
        }
        for (int i = 4; i < 8; i++) {
            button[i].setImageResource(R.drawable.balloon_green0001);
        }
        for (int i = 8; i < 12; i++) {
            button[i].setImageResource(R.drawable.balloon_red0001);
        }
        for (int i = 12; i < 16; i++) {
            button[i].setImageResource(R.drawable.balloon_purple0001);
        }
        for (int i = 16; i < 20; i++) {
            button[i].setImageResource(R.drawable.balloon_yellow0001);
        }



        Random random = new Random();

        bg = (ImageView) findViewById(R.id.play_background); // 배경

        // com = rand_num;
        rand_num = random.nextInt(5);
        corrent_num = rand_num;

        bg.setVisibility(View.VISIBLE); // 배경화면 표시

        Corrent_color(corrent_num);  // 처음 표시하는 풍선 색

        Handler gameHandler = new Handler();

        gameHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                y = 350;
                play_game(button, x, y);
            }
        }, 3000);

       //zi(button, x, y);
       // play_game(button, x, y);

    }

    public void zi(ImageButton button[], int x, int y){

        int xx= x, yy = y;

        for(int i=0; i<20; i++) {

            button[i].setX(xx);
            button[i].setY(yy);
            button[i].setVisibility(View.VISIBLE);

            xx += 150;
            if (xx > 1750) {
                xx = 0;
                yy += 150;
            }
            if (yy > 500) {
                i = 20;
            }

        }
    }
    public void play_game(ImageButton button[], int x, int y) { // 좌표별로 표시

        Random random = new Random();
        int rand_num;
        int xx, yy;

        rand_button = new ImageButton[20];

        xx = x;
        yy = y;

        for (int i = 0; i < 20; i++) {

            rand_num = random.nextInt(20);

            switch (rand_num) {
                case 0: case 1: case 2: case 3:
                    rand_button[i] = button[rand_num];
                    rand_button[i].setImageResource(R.drawable.balloon_blue0001);
                    break;
                case 4: case 5: case 6: case 7:
                    rand_button[i] = button[rand_num];
                    rand_button[i].setImageResource(R.drawable.balloon_green0001);
                    break;
                case 8: case 9: case 10: case 11:
                    rand_button[i] = button[rand_num];
                    rand_button[i].setImageResource(R.drawable.balloon_purple0001);
                    break;
                case 12: case 13: case 14: case 15:
                    rand_button[i] = button[rand_num];
                    rand_button[i].setImageResource(R.drawable.balloon_red0001);
                    break;
                case 16: case 17: case 18: case 19:
                    rand_button[i] = button[rand_num];
                    rand_button[i].setImageResource(R.drawable.balloon_yellow0001);
                    break;

            }

            rand_button[i].setX(xx);
            rand_button[i].setY(yy);
            rand_button[i].setVisibility(View.VISIBLE);

            xx += 150;
            if (xx > 1600) {
                xx = 0;
                yy += 150;
            }
            if (yy > 500) {
                i = 20;
            }



        }
    }


    public void Corrent_color(int cr){ // 처음에 나오는 공 색

        Handler delayHandler = new Handler();
        switch (cr) {

            case 0:
                icon_blue.setVisibility(View.VISIBLE);
                delayHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        icon_blue.setVisibility(View.INVISIBLE);
                    }
                }, 3000);
                break;
            case 1:
                icon_yellow.setVisibility(View.VISIBLE);
                delayHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        icon_yellow.setVisibility(View.INVISIBLE);
                    }
                }, 3000);
                break;
            case 2:
                icon_green.setVisibility(View.VISIBLE);
                delayHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        icon_green.setVisibility(View.INVISIBLE);
                    }
                }, 3000);

                break;
            case 3:
                icon_red.setVisibility(View.VISIBLE);
                delayHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        icon_red.setVisibility(View.INVISIBLE);
                    }
                }, 3000);

                break;
            case 4:
                icon_purple.setVisibility(View.VISIBLE);
                delayHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        icon_purple.setVisibility(View.INVISIBLE);
                    }
                }, 3000);
                break;
        }

    }


}
