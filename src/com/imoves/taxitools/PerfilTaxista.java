package com.imoves.taxitools; 

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.GridView;
 
public class PerfilTaxista extends ActionBarActivity {
	GridView grdOpciones;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfiltaxista);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setTitle("Cambiar Estado");
		
		
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
