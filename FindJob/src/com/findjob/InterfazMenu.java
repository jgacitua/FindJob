package com.findjob;
import com.findjob.R;


import interfaz.trabajador.InterfazMapa;
import interfaz.trabajador.InterfazPostulaciones;

import java.util.ArrayList;

import adaptadores.AdapterListMenu;
import adaptadores.MenuItem;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.view.View;


 


public class InterfazMenu extends Activity  {
	
	ListView listMenu;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_interfaz_menu);
		listMenu = (ListView) findViewById(R.id.listMenu);
        llenarListMenu();
	
		
	}
	public void llenarListMenu(){
		 ArrayList<MenuItem> menuArray =new ArrayList<MenuItem>();
		 
	        menuArray.add(
	              new MenuItem("Mapa", R.drawable.remote_desktop)); 
	 
	        menuArray.add(
	              new MenuItem("Mis Datos",  R.drawable.escribir_datos));
	 
	        menuArray.add(
	              new MenuItem("Mi Curriculum",  R.drawable.personal));
	 
	        menuArray.add(
	              new MenuItem("Postulaciones",  R.drawable.notepad));
	        menuArray.add(
		              new MenuItem("Entrevistas",  R.drawable.entrevista));
	        menuArray.add(
		              new MenuItem("Busqueda Avanzada",  R.drawable.search));
	 
	        AdapterListMenu adaptador = new AdapterListMenu(InterfazMenu.this, menuArray);
	        listMenu.setAdapter(adaptador);
	        
	        listMenu.setOnItemClickListener(new OnItemClickListener() {
	            public void onItemClick(AdapterView<?> parent, View view,
	                int position, long id) {
	                switch (position) {
	                  case 0:
	                   Intent newActivity0 = new Intent(InterfazMenu.this,InterfazMapa.class);     
	                   startActivity(newActivity0);
	                  break;
//	                  case 1:
//	                   Intent newActivity1 = new Intent(InterfazMenu.this,NewActivity1.class);     
//	                   startActivity(newActivity1);
//	                  break;
//	                  case 2:
//	                   Intent newActivity2 = new Intent(InterfazMenu.this,NewActivity2.class);     
//	                   startActivity(newActivity2);
//	                  break;
	                  case 3:
	                   Intent newActivity3 = new Intent(InterfazMenu.this,InterfazPostulaciones.class);     
	                   startActivity(newActivity3);
	                  break;
	                  default:
	                    // Nothing do!
	                }

	            }
	          });
	}


	
	
}
