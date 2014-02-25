package com.imoves.taxitools; 

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class Cancelar extends ActionBarActivity
{
	String value; 
	Button btnSi;
	
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{ 
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cancelar); 
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setTitle("Cambiar Estado");
        btnSi = (Button) findViewById (R.id.btnSi);
        btnSi.setOnClickListener(new Button.OnClickListener()
        {

			@Override
			public void onClick(View arg0) 
			{
				Toast.makeText(Cancelar.this, "Su solicitud ha sido cancelada", Toast.LENGTH_SHORT).show();
				Intent i = new Intent(Cancelar.this, MenuUsuario.class);
				startActivity(i);
				finish();
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
