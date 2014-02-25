package com.imoves.taxitools;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ReservaActivity extends ActionBarActivity{
	Button btnReserva;
	String texto = "Tu taxi ha sido reservado, la aplicacion mostrara una alerta 10 minutos antes de la hora que lo solicitaste";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reserva);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setTitle("Reserva");
		btnReserva = (Button) findViewById(R.id.button1);
		btnReserva.setOnClickListener(new Button.OnClickListener()
        { 
	    	@Override
	    	 public void onClick(View v) 
	    	 { 
	    		Intent n = new Intent(ReservaActivity.this, Sugerencias.class);
	    		n.putExtra("texto", texto);
	    		startActivity(n);
	    		 
	    	 }
	    });	
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
			
		switch (item.getItemId()) {
		
		case android.R.id.home:
			finish();
			return true;
					
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			finish();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
}
