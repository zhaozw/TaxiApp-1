package com.imoves.taxiapp;

import com.imoves.taxitools.R;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class EstadoActivity extends ActionBarActivity {

	Button btn_disponible, btn_nodisponible;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_estado);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setTitle("Cambiar Estado");
		
		btn_disponible = (Button) findViewById(R.id.buttonD);
		btn_disponible.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Toast.makeText(EstadoActivity.this, "Estado Disponible", Toast.LENGTH_LONG).show();
				finish();
			}
		});
		btn_nodisponible = (Button) findViewById(R.id.buttonN);
		btn_nodisponible.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Toast.makeText(EstadoActivity.this, "Estado no Disponible", Toast.LENGTH_LONG).show();
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
