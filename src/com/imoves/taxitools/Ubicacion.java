package com.imoves.taxitools;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class Ubicacion extends ActionBarActivity { 
	Button btnUbicacion;
 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Remove title bar
	    this.requestWindowFeature(Window.FEATURE_NO_TITLE);  
		setContentView(R.layout.menutaxi);  
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setTitle("Solicitudes Proximas");
		btnUbicacion = (Button) findViewById(R.id.btnUbicacion);
		btnUbicacion.setOnClickListener(new Button.OnClickListener()
        { 
	    	@Override
	    	 public void onClick(View v) 
	    	 { 
	    		Intent n= new Intent(getApplicationContext(), Ubicacion.class);
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