package com.imoves.taxiapp;

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
import com.imoves.taxitools.R;

public class TransferirActivity extends ActionBarActivity {

	SolicitudAdapter adapter;
	ListView listview;
	String[] name ={"Avenida Olimpica", "Colonia Flor Blanca", "Estadio Cuscatlan"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_transferir);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setTitle("Transferir");

		adapter = new SolicitudAdapter(TransferirActivity.this,name);
		listview = (ListView) findViewById(R.id.transferir_lista);
		listview.setAdapter(adapter);

		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				startListaProductoActivity(position);
			}
		});
	}

	private void startListaProductoActivity(int position) {

	//	position = position-1;
		for (int k = 0; k < 10; k++) {
			if (position == k) {			
				Intent a = new Intent(TransferirActivity.this, PersonasActivity.class);
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
