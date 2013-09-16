package interfaz.trabajador;

import com.findjob.R;
import com.findjob.R.layout;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
public class InterfazMapa extends FragmentActivity {
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
     {
    	 super.onCreate(savedInstanceState);
    	setContentView(R.layout.activity_interfaz_mapa);
                               
        
	}

	
//	  public void onDestroyView() {
//	        super.onDestroyView();
//	        SupportMapFragment f = (SupportMapFragment) getFragmentManager().findFragmentById(R.id.map);
//	        if (f != null) 
//	            getFragmentManager().beginTransaction().remove(f).commit();
//	    }

//		public void animateCamera(View view) {
//		if (mapa.getMyLocation() != null)
//		mapa.animateCamera(CameraUpdateFactory.newLatLngZoom(
//		new LatLng( mapa.getMyLocation().getLatitude(), mapa.getMyLocation().getLongitude()), 15));
//		}
//
//		public void addMarker(View view) {
//		mapa.addMarker(new MarkerOptions().position(
//		new LatLng(mapa.getCameraPosition().target.latitude,
//		mapa.getCameraPosition().target.longitude)));
//
//		}
//
//		@Override
//		public void onMapClick(LatLng puntoPulsado) {
//		mapa.addMarker(new MarkerOptions().position(puntoPulsado).
//		icon(BitmapDescriptorFactory
//		.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
//		}
	}	
}
