package interfaces.dialogos;

import com.findjob.R;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;

public class DialogCustom extends Dialog {

	private View view;

	public DialogCustom(Context context, int theme) {
		super(context, theme);
	}
	
	@Override
	public void setContentView(View view) {
		
		this.view=view;
		
		super.setContentView(view);
	} 
	
	/**
	 * MŽtodo para setear un bot—n con acci—n positiva en un dialog.
	 * @param text					El texto que dir‡ el bot—n
	 * @param clickPositiveListener	El listener para la acci—n que hace el bot—n al ser presionado.
	 */
	public void setPositiveButton(String text, View.OnClickListener clickPositiveListener){
		
		Button bt_aceptar=(Button)view.findViewById(R.id.buttonDialogAceptar);
		bt_aceptar.setText(text);
		bt_aceptar.setVisibility(View.VISIBLE);
		bt_aceptar.setOnClickListener(clickPositiveListener);
		
	} 

	/**
	 * MŽtodo para setear un bot—n con acci—n negativa en un dialog.
	 * @param text					El texto que dir‡ el bot—n
	 * @param clickNegativeListener	El listener para la acci—n que hace el bot—n al ser presionado.
	 */
	public void setNegativeButton(String text, View.OnClickListener clickNegativeListener) {
	
		Button bt_aceptar=(Button)view.findViewById(R.id.buttonDialogCancelar);
		bt_aceptar.setText(text);
		bt_aceptar.setVisibility(View.VISIBLE);
		bt_aceptar.setOnClickListener(clickNegativeListener);
		
	}
	
}
