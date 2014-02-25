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

public class DetalleTips extends ActionBarActivity {

	TipsActivity adapter;
	ListView listview;
	String text = "Descripcion de Tips";
	String[] nombre = {"Compartir tu ubicación", "Dale puntos al conductor", "Reporta el tráfico", "Recomienda a tus amigos", "Marca tus puntos frecuentes"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_solicitud);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setTitle("Solicitudes Proximas");

		adapter = new TipsActivity(DetalleTips.this, nombre);
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

		//position = position-1;
		for (int k = 0; k < nombre.length; k++) {
			if (position == k) {			
				Intent a = new Intent(DetalleTips.this, Sugerencias.class);
				a.putExtra("texto", text);
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
