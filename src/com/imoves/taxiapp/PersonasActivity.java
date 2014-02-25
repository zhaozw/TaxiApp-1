package com.imoves.taxiapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.imoves.adapter.PersonasAdapter;
import com.imoves.taxitools.R;

public class PersonasActivity extends ActionBarActivity{
	
	PersonasAdapter adapter;
	GridView gridview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_persona);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setTitle("Transferir");
		
		adapter = new PersonasAdapter(PersonasActivity.this);
		gridview = (GridView)findViewById(R.id.gridView1);
		gridview.setAdapter(adapter);
		

		gridview.setOnItemClickListener(new OnItemClickListener() {

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
			for (int k = 0; k < 9; k++) {
				if (position == k) {			
					final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
					alertDialog.setTitle("TaxiApp");
					alertDialog.setMessage("¿Desea transferir la carrera a esta persona?");
					alertDialog.setButton("Transferir", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
						//	new DeleteDataTask(hashKey, idArticulo, idEstablecimiento).execute();
							alertDialog.dismiss();
							finish();
						}
					});
					alertDialog.setButton2("Cancelar", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							alertDialog.dismiss();
						}
					});
					alertDialog.show();
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
