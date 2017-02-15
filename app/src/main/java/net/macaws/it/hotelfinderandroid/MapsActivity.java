package net.macaws.it.hotelfinderandroid;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import net.macaws.it.hotelfinderandroid.model.Hotel;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        Intent h = getIntent();
        ArrayList<Hotel> hoteles = (ArrayList<Hotel>) h.getSerializableExtra("hotels");

        if (hoteles.size() > 0) {

            for (int i = 0; i < hoteles.size(); i++) {
                LatLng hotelLocation = new LatLng(hoteles.get(i).getLatitude(), hoteles.get(i).getLongitude());
                String hotelMarker = hoteles.get(i).getName();
                mMap.addMarker(new MarkerOptions().position(hotelLocation).title(hotelMarker));
            }
            CameraPosition cameraPosition = CameraPosition.builder()
                    .target(new LatLng(hoteles.get(0).getLatitude(), hoteles.get(0).getLongitude()))
                    .zoom(11)
                    .build();
            mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        }
    }
}
