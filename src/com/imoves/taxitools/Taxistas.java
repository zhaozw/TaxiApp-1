package com.imoves.taxitools; 

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
 
public class Taxistas extends ActionBarActivity {
	GridView grdOpciones;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.taxistas);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setTitle("Cambiar Estado");
        GridView gridview = (GridView) findViewById(R.id.gridView);// crear el
        // gridview a partir del elemento del xml gridview
 
        gridview.setAdapter(new ImageAdapter(this));// con setAdapter se llena
        // el gridview con datos. en
        // este caso un nuevo objeto de la clase ImageAdapter,
        // que está definida en otro archivo
        // para que detecte la pulsación se le añade un listener de itemClick
        // que recibe un OniTemClickListener creado con new
 
        gridview.setOnItemClickListener(new OnItemClickListener() {
            // dentro de este listener difinimos la función que se ejecuta al
            // hacer click en un item
            // el metodo pertenece a AdapterView, es decir, es
            // AdapterView.OnItemClickListener
            // dentro de este, tenemos el método onItemClick, que es el que se
            // invoca al pulsar un item del AdapterView
            // esa función recibe el objeto padre, que es un adapterview en el
            // que se ha pulasdo, una vista, que es el elemento sobre el que se
            // ha pulsado,
            // una posicion, que es la posicion del elemento dentro del adapter,
            // y un id, que es el id de fila del item que se ha pulsado
            public void onItemClick(AdapterView<?> parent, View v,
                    int position, long id) {
		        	Intent n= new Intent(getApplicationContext(), PerfilTaxista.class);
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
