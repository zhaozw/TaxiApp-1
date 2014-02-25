package com.imoves.taxitools; 

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class Sugerencias extends ActionBarActivity
{
	String value;
	Button btnCancelar, btnTaxi, btnTaxista, btnTour, btnTips, btnSugerencia;
	
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sugerencia); 
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setTitle("Cambiar Estado");
		
		Bundle extra = Sugerencias.this.getIntent().getExtras();
		value = (String) extra.getString("texto");
		
		TextView textView1 = (TextView) findViewById(R.id.textView1);
		
		textView1.setText(value);
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
