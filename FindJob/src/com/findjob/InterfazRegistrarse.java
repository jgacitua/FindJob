package com.findjob;

import interfaz.empresario.InterfazMisDatosEmpresario;
import interfaz.trabajador.InterfazMisDatosTrabajador;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class InterfazRegistrarse extends Activity {
	 RadioGroup RdgPerfil;
	 String tipoPerfil;
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_interfaz_registrarse);
        RdgPerfil = (RadioGroup)findViewById(R.id.rdBtnGroup);
        tipoPerfil = "Empleado";
        RdgPerfil.setOnCheckedChangeListener(new OnCheckedChangeListener(){
        	 
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                if (checkedId == R.id.rdBtnEmpleado){
                	tipoPerfil = "Empleado";
                }else if (checkedId == R.id.rdBtnEmpresario){
                	tipoPerfil = "Empresario";
                }
                 
            }
             
        });
		
	}
	public void OnClickRegistrar(View view)
    {
		if (tipoPerfil.equalsIgnoreCase("Empleado")){
		   Intent i = new Intent(this,InterfazMisDatosTrabajador.class);
		   startActivity(i);
		}else{
			Intent i = new Intent(this,InterfazMisDatosEmpresario.class);
			   startActivity(i);
			
		}
    }
}