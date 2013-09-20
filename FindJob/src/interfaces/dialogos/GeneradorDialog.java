package interfaces.dialogos;

import interfaces.dialogos.DialogCustom;
import interfaces.dialogos.DialogMaker;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;

public class GeneradorDialog {
	public DialogCustom dialog;
	private Activity actividad;
	public GeneradorDialog(Activity actividad){
		this.actividad = actividad;
	}
	public void dialog(String msj){
		dialog = DialogMaker.createAlertDialog(actividad, "Atención",msj);
	   	dialog.setNegativeButton("Aceptar", new OnClickListener(){
			public void onClick(View v) {
				dialog.dismiss();
				}							
		   });
	     dialog.show();
	}
}
