package com.imoves.taxitools; 


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
 

public class MainActivity extends Activity {
 
	Button btnusuario, btntaxista;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);  
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.selectuser); 
		
		btnusuario = (Button) findViewById(R.id.btnUsuario);
		btntaxista = (Button) findViewById(R.id.btnTaxi);
		
		btnusuario.setOnClickListener(new Button.OnClickListener()
        { 
	    	@Override
	    	 public void onClick(View v) 
	    	 { 
	    		Intent n= new Intent(getApplicationContext(), LoginUsuario.class);
                startActivity(n); 
	    	 }
	    });
		
		btntaxista.setOnClickListener(new Button.OnClickListener()
        { 
	    	@Override
	    	 public void onClick(View v) 
	    	 { 
	    		Intent n= new Intent(getApplicationContext(), LoginTaxista.class);
                startActivity(n); 
	    	 }
	    });	
	}

}