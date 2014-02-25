package com.imoves.taxiapp;

import com.imoves.taxitools.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity2 extends Activity {

	Button btn_uno,btn_dos,btn_tres,btn_cuatro,btn_cinco,btn_seis;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);
		
		btn_uno = (Button) findViewById(R.id.button1);
		btn_uno.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent a = new Intent(MainActivity2.this ,SolicitudActivity.class);
				//a.putExtra("flag", "1");
				startActivity(a);
			}
		});
		
		btn_dos = (Button) findViewById(R.id.button2);
		btn_dos.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent a = new Intent(MainActivity2.this ,UbicacionActivity.class);
				startActivity(a);
			}
		});
		
		btn_tres = (Button) findViewById(R.id.button3);
		btn_tres.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent a = new Intent(MainActivity2.this ,PerfilActivity.class);
				startActivity(a);
			}
		});
		
		btn_cuatro = (Button) findViewById(R.id.button4);
		btn_cuatro.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent a = new Intent(MainActivity2.this ,CarreraActivity.class);
			//	a.putExtra("flag", "0");
				startActivity(a);
			}
		});
		
		btn_cinco = (Button) findViewById(R.id.button5);
		btn_cinco.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent a = new Intent(MainActivity2.this ,TransferirActivity.class);
				startActivity(a);
			}
		});
		
		btn_seis = (Button) findViewById(R.id.button6);
		btn_seis.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent a = new Intent(MainActivity2.this ,EstadoActivity.class);
				startActivity(a);
			}
		});
		
		
	}
}
