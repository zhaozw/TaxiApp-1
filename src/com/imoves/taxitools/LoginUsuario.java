package com.imoves.taxitools;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginUsuario extends ActionBarActivity { 
	EditText txtUsuario, txtContra;
	Button btnGo; 
	String usuario, contra;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Remove title bar
	    this.requestWindowFeature(Window.FEATURE_NO_TITLE);  
		setContentView(R.layout.loginusuario); 
		
		txtUsuario 	 = (EditText) findViewById(R.id.txtUsuario);
		txtContra	 = (EditText) findViewById(R.id.txtContrasena);
		
		
		btnGo = (Button) findViewById(R.id.btnGo);
		btnGo.setOnClickListener(new Button.OnClickListener()
        { 
	    	@Override
	    	 public void onClick(View v) 
	    	 { 	    		 
	    		usuario = txtUsuario.getText().toString();
	    		contra = txtContra.getText().toString();  
	    		 
	    		if (usuario.equals("") && contra.equals("")) { 
	    			Toast.makeText(LoginUsuario.this, "Por favor, digite los datos requeridos", Toast.LENGTH_SHORT).show(); 
				} else { 
					
					if (usuario.equals("usuario") && contra.equals("123456")) {
						Intent n= new Intent(getApplicationContext(), MenuUsuario.class);
	                    startActivity(n);
	                    finish(); 
	                    
					} else {
						Toast.makeText(LoginUsuario.this, "Usuario o contraseña equivocadas", Toast.LENGTH_SHORT).show();
	                    txtUsuario.setText("");
	                    txtContra.setText("");
					} 
				}
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