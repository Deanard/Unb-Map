package mappypal.headhallmappyboi;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity3 extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    public LatLng newTemp = new LatLng(45.949765, -66.641676);
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps3);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        btn1 = findViewById(R.id.button4);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double stringToPassBack = newTemp.longitude;
                double string2 = newTemp.latitude;

                // put the String to pass back into an Intent and close this activity
                Intent intent = new Intent();
                intent.putExtra("longKey", stringToPassBack);
                intent.putExtra("latKey", string2);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        ;

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

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {

            @Override
            public void onMapClick(LatLng point) {
                // TODO Auto-generated method stub
                newTemp = point;
                mMap.clear();
                mMap.addMarker(new MarkerOptions().position(point));
            }
        });
        // Add a marker in Sydney and move the camera
        LatLng newTemp = new LatLng(-34, 151);

    }

}
