package interfaces.dialogos;

import android.app.Dialog;
import android.content.Context;
import android.view.View;

public class DialogProgressCustom extends Dialog {

	@SuppressWarnings("unused")
	private View view;

	public DialogProgressCustom(Context ctx, int theme){
		super(ctx,theme);
	}
	
	@Override
	public void setContentView(View view) {
		this.view = view;
		super.setContentView(view);
	}
	
	
	
	
}
