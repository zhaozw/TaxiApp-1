package com.imoves.taxitools; 

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuUsuario extends Activity
{
	String value;
	Button btnCancelar, btnTaxi, btnTaxista, btnTour, btnTips, btnSugerencia, btnReser;
	String text = "Ayudanos a mejorar este servicio, tus sugerencias y comentarios son importantes para nosotros.";
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menuusuario); 
        
        btnCancelar = (Button) findViewById(R.id.btnCancelar);
        btnCancelar.setOnClickListener(new Button.OnClickListener()
        { 
	    	@Override
	    	 public void onClick(View v) 
	    	 { 
	    		Intent n= new Intent(getApplicationContext(), Cancelar.class);
                startActivity(n); 
	    	 }
	    });
        
        btnTaxi = (Button) findViewById(R.id.btnTaxi);
        btnTaxi.setOnClickListener(new Button.OnClickListener()
        { 
	    	@Override
	    	 public void onClick(View v) 
	    	 { 
	    		Intent n= new Intent(getApplicationContext(), Taxi.class);
                startActivity(n); 
	    	 }
	    });
        
        btnTaxista = (Button) findViewById(R.id.btnTaxista);
        btnTaxista.setOnClickListener(new Button.OnClickListener()
        { 
	    	@Override
	    	 public void onClick(View v) 
	    	 { 
	    		Intent n= new Intent(getApplicationContext(), Taxistas.class);
                startActivity(n); 
	    	 }
	    });
        
        btnTour = (Button) findViewById(R.id.btnTour);
        btnTour.setOnClickListener(new Button.OnClickListener()
        { 
	    	@Override
	    	 public void onClick(View v) 
	    	 { 
	    		Intent n= new Intent(getApplicationContext(), TourActivity.class);
                startActivity(n); 
	    	 }
	    });
        
        btnTips = (Button) findViewById(R.id.btnTips);
        btnTips.setOnClickListener(new Button.OnClickListener()
        { 
	    	@Override
	    	 public void onClick(View v) 
	    	 { 
	    		Intent n= new Intent(getApplicationContext(), DetalleTips.class);
                startActivity(n); 
	    	 }
	    });
        
        btnSugerencia = (Button) findViewById(R.id.btnSugerencia);
        btnSugerencia.setOnClickListener(new Button.OnClickListener()
        { 
	    	@Override
	    	 public void onClick(View v) 
	    	 { 
	    		Intent n= new Intent(getApplicationContext(), Sugerencias.class);
	    		n.putExtra("texto", text);
                startActivity(n); 
	    	 }
	    });
        
        btnSugerencia = (Button) findViewById(R.id.btnSugerencia);
        btnSugerencia.setOnClickListener(new Button.OnClickListener()
        { 
	    	@Override
	    	 public void onClick(View v) 
	    	 { 
	    		Intent n= new Intent(getApplicationContext(), Sugerencias.class);
	    		n.putExtra("texto", text);
                startActivity(n); 
	    	 }
	    });
        
        btnReser = (Button) findViewById(R.id.btnReservacion);
        btnReser.setOnClickListener(new Button.OnClickListener()
        { 
	    	@Override
	    	 public void onClick(View v) 
	    	 { 
	    		Intent n= new Intent(getApplicationContext(), ReservaActivity.class);
	    		n.putExtra("texto", text);
                startActivity(n); 
	    	 }
	    });
	}
}
