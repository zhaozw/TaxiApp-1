package com.imoves.taxitools; 

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.Overlay;



/**
 *
 * @author VIJAYAKUMAR M
 *This class for display route current location to hotel location on google map V2
 */
public class Ruta extends FragmentActivity implements LocationListener  {

     
      List<Overlay> mapOverlays;
      GeoPoint point1, point2;
      LocationManager locManager;
      Drawable drawable;
      Document document;
      v2GetRouteDirection v2GetRouteDirection;
      LatLng fromPosition;
      LatLng toPosition;
      GoogleMap mGoogleMap;
      MarkerOptions markerOptions;
      Location location;
      @Override
      protected void onCreate(Bundle savedInstanceState) 
      {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.ruta);
            
            // Getting Google Play availability status
            int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getBaseContext());

            // Showing status
            if(status!=ConnectionResult.SUCCESS){ // Google Play Services are not available
                    
                int requestCode = 10;
                Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status, this, requestCode);
                dialog.show();
                
            }else{            
                    
                // Getting reference to the SupportMapFragment of activity_main.xml
                SupportMapFragment fm = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
                
                // Getting GoogleMap object from the fragment
                mGoogleMap = fm.getMap();
                
                // Enabling MyLocation Layer of Google Map
                mGoogleMap.setMyLocationEnabled(true);                                
                                
                
                 // Getting LocationManager object from System Service LOCATION_SERVICE
	            LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

	            // Creating a criteria object to retrieve provider
	            Criteria criteria = new Criteria();

	            // Getting the name of the best provider
	            String provider = locationManager.getBestProvider(criteria, true);

	            // Getting Current Location
	            Location location = locationManager.getLastKnownLocation(provider);

	            if(location!=null){
	                    onLocationChanged(location);
	            }

	            locationManager.requestLocationUpdates(provider, 20000, 0, this);
            }
      }
      /**
       *
       * @author VIJAYAKUMAR M
       * This class Get Route on the map
       *
       */
      private class GetRouteTask extends AsyncTask<String, Void, String> {
           
            private ProgressDialog Dialog;
            String response = "";
            @Override
            protected void onPreExecute() {
                /*  Dialog = new ProgressDialog(Mapa.this);
                  Dialog.setMessage("Trazando la ruta...");
                  Dialog.show();*/
            }

            @Override
            protected String doInBackground(String... urls) {
                  //Get All Route values
                        document = v2GetRouteDirection.getDocument(fromPosition, toPosition, v2GetRouteDirection.MODE_DRIVING);
                        response = "Success";
                  return response;

            }

            @Override
            protected void onPostExecute(String result) {
            	
                  mGoogleMap.clear();
                  if(response.equalsIgnoreCase("Success")){
                  ArrayList<LatLng> directionPoint = v2GetRouteDirection.getDirection(document);
                  PolylineOptions rectLine = new PolylineOptions().width(10).color(
                              Color.RED);

                  for (int i = 0; i < directionPoint.size(); i++) {
                        rectLine.add(directionPoint.get(i));
                  }
                  // Adding route on the map
                  mGoogleMap.addPolyline(rectLine);
                  markerOptions.position(toPosition);
                  markerOptions.draggable(true);
                  mGoogleMap.addMarker(markerOptions);

                  }
                 
                 // Dialog.dismiss();
            }
      }
      @Override
      protected void onStop() {
            super.onStop();
            finish();
      }
	@Override
	public void onLocationChanged(Location location) 
	{
		// TODO Auto-generated method stub
		// Getting latitude of the current location
        double latitude = location.getLatitude();
        
        // Getting longitude of the current location
        double longitude = location.getLongitude();                
        
        // Creating a LatLng object for the current location
        LatLng latLng = new LatLng(latitude, longitude);
        
        // Showing the current location in Google Map
        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng)); 
        // Zoom in the Google Map
        mGoogleMap.animateCamera(CameraUpdateFactory.zoomTo(15)); 
        //Toast.makeText(this, "Tracking ...", Toast.LENGTH_LONG).show();
        
        v2GetRouteDirection = new v2GetRouteDirection();
        markerOptions = new MarkerOptions();
        fromPosition = new LatLng(location.getLatitude(), location.getLongitude());
        toPosition = new LatLng(13.7050348,-89.2081904);
        GetRouteTask getRoute = new GetRouteTask();
        getRoute.execute();
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
}
