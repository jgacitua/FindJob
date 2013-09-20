package interfaz.trabajador;

import com.findjob.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class InterfazMapa extends FragmentActivity {
	

	/** CTE con la latitud inicial. */
	private static final double LATITUD_INICIAL = 40.5891778;

	/** CTE con la longitud inicial. */
	private static final double LONGITUD_INICIAL = -4.14795;

	/** Referencia al TAG de log. */
	private static final String TAG = "[DirectoAndroidV2_EJ1]";

	/** Referencia a GoogleMap */
	private GoogleMap mMap;

	/** Referencia al campo de entrada de latitud. */
	private EditText etLatitud;

	/** Referencia al campo de entrada de longitud. */
	private EditText etLongitud;

	/** Referencia al valor de la latitud introducido. */
	private double latitud;

	/** Referencia al valor de la longitud introducido. */
	private double longitud;

	/**
	 * @see android.support.v4.app.FragmentActivity#onCreate(android.os.Bundle)
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
     {
    	 super.onCreate(savedInstanceState);
    	setContentView(R.layout.activity_interfaz_mapa);
    	cargaGoogleMap();

		etLatitud = (EditText) this.findViewById(R.id.edLatitud);
		etLatitud.setText(String.valueOf(LATITUD_INICIAL));
		etLongitud = (EditText) this.findViewById(R.id.edLongitud);
		etLongitud.setText(String.valueOf(LONGITUD_INICIAL));
//                mMap.setOnMarkerClickListener(new OnMarkerClickListener()
//                {
//
//                    @Override
//                    public boolean onMarkerClick(Marker arg0) {
//                        if(arg0.getTitle().equals("MyHome")) // if marker source is clicked
//                             Toast.makeText(InterfazMapa.this, arg0.getTitle(),1000).show();// display toast
//                        return true;
//                    }
//
//                });       
      }
     
	}
	/**
	 * El método posicionar realiza la funcionalidad del evento lanzado por el
	 * botón 'Posicionar'.
	 * 
	 * @param view
	 */
	public void OnClickPosicionar(View view) {

		try {
			cargaCoordenadas();

			LatLng latLng = new LatLng(latitud, longitud);
			mMap.addMarker(new MarkerOptions().position(latLng).title(
					"latitud=" + latitud + " longitud=" + longitud)
					.icon(BitmapDescriptorFactory.fromResource(R.drawable.market_avion)));
		} catch (IllegalArgumentException e) {
			Toast.makeText(InterfazMapa.this, "Coordenadas no válidas",
					Toast.LENGTH_SHORT).show();
			Log.d(TAG, "Coordenadas no válidas. ");
		}
	}
	public void OnClickResetear(View view) {
		this.etLatitud.setText("");
		this.etLongitud.setText("");
	}
	
	protected void onResume() {
		super.onResume();
		cargaGoogleMap();
	}
	private void cargaGoogleMap() {
		if (mMap == null) {
			mMap = ((SupportMapFragment) getSupportFragmentManager()
					.findFragmentById(R.id.map)).getMap();
			if (mMap != null) {
				mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
				mMap.setMyLocationEnabled(true);
				posicionInicial();
				Log.d(TAG, "GoogleMap cargado.");
			}
		}
	}
	private void posicionInicial() {
		double latitud = LATITUD_INICIAL;
		double longitud = LONGITUD_INICIAL;
		LatLng latLng = new LatLng(latitud, longitud);
		mMap.addMarker(new MarkerOptions().position(latLng).title(
				"Madrid, España").snippet("Bangalore")    
              .icon(BitmapDescriptorFactory.fromResource(R.drawable.market_avion)));

	}

	/*
	 * El método cargaCoordenadas realiza la carga de las coordenadas insertadas
	 * en la actividad.
	 */
	private void cargaCoordenadas() throws IllegalArgumentException {

		if (null == this.etLatitud.getText().toString()
				|| "".equals(this.etLatitud.getText().toString())
				|| " ".equals(this.etLatitud.getText().toString())) {
			throw new IllegalArgumentException("Coordenadas no válidas");
		}
		this.latitud = Double.parseDouble(this.etLatitud.getText().toString());
		this.longitud = Double
				.parseDouble(this.etLongitud.getText().toString());
		Log.d(TAG, "Coordenadas: latitud=" + latitud + " longitud=" + longitud);
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
