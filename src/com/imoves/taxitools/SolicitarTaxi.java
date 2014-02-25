package com.imoves.taxitools;

 
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class SolicitarTaxi extends ActionBarActivity implements LocationListener{

	private GoogleMap map;
	private LocationManager locationManager;
	private static final long MIN_TIME = 400;
	private static final float MIN_DISTANCE = 1000;
	GoogleMap googleMap;
    EditText edit;
    Button btnCancelar, btnSolicitar;
    ProgressDialog loading; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.solicitartaxi);
		
		 
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setTitle("Ubicacion");
		
		map = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
		
		map.setMyLocationEnabled(true);
		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
	    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, MIN_TIME, MIN_DISTANCE, this); //You can also use LocationManager.GPS_PROVIDER and LocationManager.PASSIVE_PROVIDER        
	    
	    btnCancelar = (Button) findViewById(R.id.btnCanTaxi);
        btnCancelar.setOnClickListener(new Button.OnClickListener()
        { 
	    	@Override
	    	 public void onClick(View v) 
	    	 { 
	    		Intent n= new Intent(getApplicationContext(), MenuUsuario.class);
                startActivity(n); 
                finish();
	    	 }
	    });
        
        btnSolicitar = (Button) findViewById(R.id.btnSolicitar);
        btnSolicitar.setOnClickListener(new Button.OnClickListener()
        { 
	    	@Override
	    	 public void onClick(View v) 
	    	 { 
	    		new DownloadImageTask().execute();
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
	
	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		LatLng latLng = new LatLng(location.getLatitude(),
				location.getLongitude());
		CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng,
				16);
		map.animateCamera(cameraUpdate);
		locationManager.removeUpdates(this);
		/*// picker user
        final LatLng IMOVES = new LatLng(13.69826146916221, -89.22037021574124);
        Marker pick1 = googleMap.addMarker(new MarkerOptions()
                                  .position(IMOVES) 
                                  .snippet("Tu posicion")
                                  .icon(BitmapDescriptorFactory.fromResource(R.drawable.pickerusuario)));
        // picker user
        final LatLng METRO = new LatLng(13.7050348,-89.2081904);
        Marker pick2 = googleMap.addMarker(new MarkerOptions()
                                  .position(METRO) 
                                  .snippet("Lugar Destino")
                                  .icon(BitmapDescriptorFactory.fromResource(R.drawable.pickertaxi)));*/
		
	}
	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub
		
	}
	
	private class DownloadImageTask extends AsyncTask<Void, Void, Void> 
	{ 

		public DownloadImageTask()
		{
			// TODO Auto-generated constructor stub
			
		}


		protected void onPreExecute()
		{
			try {
				loading = new ProgressDialog(SolicitarTaxi.this);
				loading.setMessage("Loading ...");
				loading.setCancelable(false);
				loading.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		protected Void doInBackground(Void... params) 
		{
			Intent n= new Intent(getApplicationContext(), TaxiTiempoLlegada.class);
            startActivity(n); 
            finish(); 


			return null;
		}

		 protected void onPostExecute(Void result) 
		 {
			 loading.dismiss();
		 }
	}
}
