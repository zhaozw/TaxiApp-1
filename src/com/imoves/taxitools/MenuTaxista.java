package com.imoves.taxitools;

import com.imoves.taxiapp.MainActivity2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MenuTaxista extends Activity { 
	Button btnUbicacion;
 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Remove title bar
	    this.requestWindowFeature(Window.FEATURE_NO_TITLE);  
		setContentView(R.layout.menutaxi);  
		
		btnUbicacion = (Button) findViewById(R.id.btnUbicacion);
		btnUbicacion.setOnClickListener(new Button.OnClickListener()
        { 
	    	@Override
	    	 public void onClick(View v) 
	    	 { 
	    		Intent n= new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(n);
	    	 }
	    });	
		
		
	}

}