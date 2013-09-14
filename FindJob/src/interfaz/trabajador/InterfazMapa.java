package interfaz.trabajador;

import com.actionbarsherlock.app.SherlockFragment;
import com.findjob.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class InterfazMapa extends SherlockFragment implements OnMapClickListener{
	private final LatLng UPV = new LatLng(39.481106, -0.340987);
	private GoogleMap mapa;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.activity_interfaz_mapa, container, false);
		mapa = ((SupportMapFragment) getFragmentManager()
				.findFragmentById(R.id.map)).getMap();
				mapa.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
				
				PolylineOptions lineas = new PolylineOptions()
	            .add(new LatLng(39.01, -0.3))
	            .add(new LatLng(39.70, -0.8))
	            .add(new LatLng(40.0, -0.5));
	 
	             lineas.width(8);
	             lineas.color(Color.RED);
	 
	    mapa.addPolyline(lineas);
				mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(UPV, 15));
				mapa.setMyLocationEnabled(true);
				mapa.getUiSettings().setZoomControlsEnabled(false);
				mapa.getUiSettings().setCompassEnabled(true);
				mapa.addMarker(new MarkerOptions()
				.position(UPV)
				.title("UPV")
				.snippet("Universidad Politécnica de Valencia")
				.icon(BitmapDescriptorFactory
				.fromResource(R.drawable.ic_launcher))
				.anchor(0.5f, 0.5f));
				mapa.setOnMapClickListener(this);
//		mapa = ((GoogleMap) getActivity()).getMapView();
//	    if (mapa.getParent()!=null)
//	    {
//	        NoSaveStateFrameLayout parentView = (NoSaveStateFrameLayout) this.mMapView.getParent();
//	        parentView.removeView(this.mMapView);
//	    }
	   
		
		return rootView;
	}
	public void onDestroy()
	{
	    super.onDestroy();

	}

	
	public void onResume(){
	    super.onResume();
	   
	}
	public void onPause(){
	    super.onPause();
	}
	
	  public void onDestroyView() {
	        super.onDestroyView();
	        SupportMapFragment f = (SupportMapFragment) getFragmentManager().findFragmentById(R.id.map);
	        if (f != null) 
	            getFragmentManager().beginTransaction().remove(f).commit();
	    }

		public void animateCamera(View view) {
		if (mapa.getMyLocation() != null)
		mapa.animateCamera(CameraUpdateFactory.newLatLngZoom(
		new LatLng( mapa.getMyLocation().getLatitude(), mapa.getMyLocation().getLongitude()), 15));
		}

		public void addMarker(View view) {
		mapa.addMarker(new MarkerOptions().position(
		new LatLng(mapa.getCameraPosition().target.latitude,
		mapa.getCameraPosition().target.longitude)));

		}

		@Override
		public void onMapClick(LatLng puntoPulsado) {
		mapa.addMarker(new MarkerOptions().position(puntoPulsado).
		icon(BitmapDescriptorFactory
		.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
		}
		
}
