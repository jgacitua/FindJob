package interfaz.trabajador;

import java.util.ArrayList;


import adaptadores.AdapterListMenu;
import adaptadores.MenuItem;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import interfaces.dialogos.DialogListCustom;
import interfaces.dialogos.DialogMaker;


import com.findjob.R;

public class InterfazActividadDelTrabajador extends Activity {
	private DialogListCustom dialogListSectores;
	private DialogListCustom dialogListArea;
	AdapterListMenu adaptadorSector ;
	AdapterListMenu adaptadorArea ;
	String txtSector ;
	String txtArea ;
	 ArrayList<MenuItem> ActividadesArray= new ArrayList<MenuItem>();;
	private ListView listActividades;
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_interfaz_actividad_trabajador);
        listActividades = (ListView) this.findViewById(R.id.listActividadesTrabajador);
      
		
	}
	public void OnClickAgregarActividad(View view){
		dialogListSectores = DialogMaker.createListAlertDialog(InterfazActividadDelTrabajador.this, "Sectores");
		llenarListaDialogSectores();
		dialogListSectores.show();
		dialogListSectores.setOnListItemClickListener(
		        new OnItemClickListener()
		        {public void onItemClick(AdapterView<?> arg0, View view,
		                    int position, long id) {
		                txtSector = adaptadorSector.getItemNomSector(position);
						dialogListSectores.dismiss();
						dialogListArea = DialogMaker.createListAlertDialog(InterfazActividadDelTrabajador.this, "Area");
						llenarListaDialogArea(txtSector);
						dialogListArea .show();
						dialogListArea.setOnListItemClickListener(
						        new OnItemClickListener()
						        {public void onItemClick(AdapterView<?> arg0, View view,
						                    int position, long id) {
						                txtArea = adaptadorArea.getItemNomSector(position);
										dialogListArea.dismiss();
										agregarElementoListActividades(txtArea);
										
						            }});
		            }});
		
	}
	public void agregarElementoListActividades(String Area){
		
		if(txtSector.equalsIgnoreCase("Salud")){
        ActividadesArray.add(
              new MenuItem(Area, R.drawable.la_salud)); 
 
		}else
			if(txtSector.equalsIgnoreCase("Ingenieria")){
	        ActividadesArray.add(
	                new MenuItem(Area, R.drawable.ingenieria)); 
	   
	  		}else
	  			if(txtSector.equalsIgnoreCase("Financiero")){
	  		        ActividadesArray.add(
	  		                new MenuItem(Area, R.drawable.financiero)); 
	  		   
	  		  		}else
	  		  		if(txtSector.equalsIgnoreCase("Telecomunicaciones")){
		  		        ActividadesArray.add(
		  		                new MenuItem(Area, R.drawable.telecomunicaciones)); 
		  		   
		  		  		}
		
        AdapterListMenu adaptador = new AdapterListMenu(InterfazActividadDelTrabajador.this, ActividadesArray);
        listActividades.setAdapter(adaptador);
	}
	public void llenarListaDialogSectores(){
		ArrayList<MenuItem> sectorArray =new ArrayList<MenuItem>();
		 
		 sectorArray.add(
	              new MenuItem("Salud", R.drawable.la_salud)); 
	 
		 sectorArray.add(
	              new MenuItem("Ingenieria",  R.drawable.ingenieria));
	 
		 sectorArray.add(
	              new MenuItem("Financiero",  R.drawable.financiero));
	 
		 sectorArray.add(
	              new MenuItem("Telecomunicaciones",  R.drawable.telecomunicaciones));
	 
	        adaptadorSector = new AdapterListMenu(InterfazActividadDelTrabajador.this,sectorArray);
	        dialogListSectores.setListAdapter(adaptadorSector);
	        
	}
	
	
	
	public void llenarListaDialogArea(String Sector){
		 ArrayList<MenuItem> menuArray =new ArrayList<MenuItem>();
		 if(Sector.equalsIgnoreCase("Salud")){
	        menuArray.add(
	              new MenuItem("Dentista", R.drawable.trabajador_icono)); 
	 
	        menuArray.add(
	              new MenuItem("Paramedico",  R.drawable.trabajador_icono));
	 
	        menuArray.add(
	              new MenuItem("Enfermero",  R.drawable.trabajador_icono));
	 
	        menuArray.add(
	              new MenuItem("Terapia",  R.drawable.trabajador_icono));
		 }else
			 if(Sector.equalsIgnoreCase("Ingenieria")){
			        menuArray.add(
			              new MenuItem("Informatica", R.drawable.trabajador_icono)); 
			 
			        menuArray.add(
			              new MenuItem("Construcción",  R.drawable.trabajador_icono));
			 
			        menuArray.add(
			              new MenuItem("Mecanica",  R.drawable.trabajador_icono));
			 
			        menuArray.add(
			              new MenuItem("Trasporte",  R.drawable.trabajador_icono));
				 }else
					 if(Sector.equalsIgnoreCase("Financiero")){
					        menuArray.add(
					              new MenuItem("Contador", R.drawable.trabajador_icono)); 
					 
					        menuArray.add(
					              new MenuItem("Bancario",  R.drawable.trabajador_icono));
					 
					        menuArray.add(
					              new MenuItem("Administración",  R.drawable.trabajador_icono));
					 
					        menuArray.add(
					              new MenuItem("Seguros",  R.drawable.trabajador_icono));
						 }
	        adaptadorArea = new AdapterListMenu(InterfazActividadDelTrabajador.this,menuArray);
	        dialogListArea.setListAdapter(adaptadorArea);
	}

}
