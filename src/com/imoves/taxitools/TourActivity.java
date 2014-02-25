package com.imoves.taxitools;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.imoves.adapter.SolicitudAdapter;
import com.imoves.taxitools.DetalleTour;
import com.imoves.taxitools.R;

public class TourActivity extends ActionBarActivity {

	SolicitudAdapter adapter;
	ListView listview;

	String[] nombre = {"Avenida Olimpica", "Colonia Flor Blanca", "Estadio Cuscatlan"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_solicitud);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setTitle("Solicitudes Proximas");

		adapter = new SolicitudAdapter(TourActivity.this,nombre);
		listview = (ListView) findViewById(R.id.solicitud_lista);
		listview.setAdapter(adapter);
		

		listview.setOnItemClickListener(new OnItemClickListener() {
			   
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				// TODO Auto-generated method stub
				startListaProductoActivity(position);
			}
		});
	}
	
	private void startListaProductoActivity(int position) {

	//	position = position-1;
		for (int k = 0; k < 10; k++) {
			if (position == k) {			
				Intent a = new Intent(TourActivity.this, DetalleTour.class);
				startActivity(a);
			}
		}
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
