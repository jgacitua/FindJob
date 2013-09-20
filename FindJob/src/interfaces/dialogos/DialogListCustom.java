package interfaces.dialogos;

import com.findjob.R;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;

public class DialogListCustom extends Dialog {

	@SuppressWarnings("unused")
	private View view;
	private ListView listView;
	
	public DialogListCustom(Context context, int theme) {
		super(context, theme);
		
	}
	
	@Override
	public void setContentView(View view) {
		this.view=view;
		this.listView=(ListView) view.findViewById(R.id.listViewDialogList);
		
		super.setContentView(view);
	}

	/**
	 * Setea el adapter para el ListView
	 * @param adapter	adaptador de ListView
	 */
	public void setListAdapter(ListAdapter adapter) {
		
		this.listView.setAdapter(adapter);
	}
	
	
	/**
	 * Setea el listener para cuando se presione un elemento en el ListView
	 * @param listener	la acci—n que se realizar‡ al presionar un elemento
	 */
	public void setOnListItemClickListener(OnItemClickListener listener){
		
		this.listView.setOnItemClickListener(listener);
	}
	
	
	

}
