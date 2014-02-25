package com.imoves.taxitools;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class SplashScreen extends Activity {

	private long splashDelay = 6000; //6 segundos

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Remove title bar
	    this.requestWindowFeature(Window.FEATURE_NO_TITLE);

	    //Remove notification bar
	    this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.splashscreen); 
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				Intent mainIntent = new Intent().setClass(SplashScreen.this, MainActivity.class);
				startActivity(mainIntent);
				finish();//Destruimos esta activity para prevenit que el usuario retorne aqui presionando el boton Atras.
			}
		};

		Timer timer = new Timer();
		timer.schedule(task, splashDelay);//Pasado los 6 segundos dispara la tarea
	}

}