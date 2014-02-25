package com.imoves.taxiapp;
 
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.imoves.taxitools.R;
import com.imoves.taxitools.TaxiUsuario;

public class CarreraActivity extends ActionBarActivity implements LocationListener{

	private GoogleMap map;
	private LocationManager locationManager;
	private static final long MIN_TIME = 400;
	private static final float MIN_DISTANCE = 1000;
	String flag;
	private long totalTimeCountInMilliseconds;  
    private long timeBlinkInMilliseconds;  
    TextView textViewShowTime;
    CountDownTimer countDownTimer;
    boolean blink;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_carrera);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setTitle("Carrera");
		textViewShowTime 	= (TextView) findViewById(R.id.tvTimeCount);
		setTimer(); 
		startTimer(); 
	//	Bundle extra = CarreraActivity.this.getIntent().getExtras();
	//	flag = (String) extra.get("flag");
		
		map = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map1)).getMap();
		
		map.setMyLocationEnabled(true);
		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
	    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, MIN_TIME, MIN_DISTANCE, this); //You can also use LocationManager.GPS_PROVIDER and LocationManager.PASSIVE_PROVIDER        
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
			
		switch (item.getItemId()) {
		
		case android.R.id.home:
		//	if(flag.equals(object))
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
		LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
	    CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 16);
	    map.animateCamera(cameraUpdate);
	    locationManager.removeUpdates(this);
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}
	
	public void setTimer()
    {
    	int time = 2; 
		 

		totalTimeCountInMilliseconds = 60 * time * 1000;

		timeBlinkInMilliseconds = 30 * 1000;
    }
    
    private void startTimer() {
		countDownTimer = new CountDownTimer(totalTimeCountInMilliseconds, 500) {
			// 500 means, onTick function will be called at every 500
			// milliseconds

			@Override
			public void onTick(long leftTimeInMilliseconds) {
				long seconds = leftTimeInMilliseconds / 1000;

				if (leftTimeInMilliseconds < timeBlinkInMilliseconds) {
					//textViewShowTime.setTextAppearance(getApplicationContext(),
							//R.style.blinkText);
					// change the style of the textview .. giving a red
					// alert style
 

					blink = !blink; // toggle the value of blink
				}

				textViewShowTime.setText(String.format("%02d", seconds / 60)
						+ ":" + String.format("%02d", seconds % 60));
				// format the textview to show the easily readable format

			}

			@Override
			public void onFinish() {
				// TODO Auto-generated method stub
				/*Intent n= new Intent(getApplicationContext(), TaxiUsuario.class);
                startActivity(n);
                finish(); */
			} 

		}.start();

	}
}
