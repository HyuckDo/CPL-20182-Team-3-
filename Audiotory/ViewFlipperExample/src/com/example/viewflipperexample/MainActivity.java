package com.example.viewflipperexample;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ViewFlipper;

public class MainActivity extends Activity {

	private Timer timer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// 이미지들이 담긴 컨테이너
		final ViewFlipper vf = (ViewFlipper) findViewById(R.id.view_flipper);

		// 타이머를 이용하여 0.5초 마다 다음 이미지를 보여줌
		timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				// UI를 손대기 위해서는 runOnUiThread를 사용해야 함
				runOnUiThread(new Runnable() {

					@Override
					public void run() {
						// 다음 이미지 표시
						vf.showNext();
					}

				});
			}
		}, 500, 500);

	}

	@Override
	protected void onPause() {
		super.onPause();
		timer.cancel();
	}

}
