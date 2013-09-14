package com.findjob;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class InterfazLogin extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interfaz_login);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.interfaz_login, menu);
        return true;
    }
    
    public void OnClickIngresar(View view)
    {
    	    Intent i = new Intent(this,InterfazMenu.class);
		   startActivity(i);
		   finish();
    }
}
