package interfaz.trabajador;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.findjob.R;

public class InterfazMisDatosTrabajador extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_interfaz_mis_datos_trabajador);
		
		
	}
	public void OnClickSiguiente(View view)
    {
		
			Intent i = new Intent(this,InterfazActividadDelTrabajador.class);
			   startActivity(i);
			
		
    }
	
}
