package mappypal.headhallmappyboi;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) ==
                        PackageManager.PERMISSION_GRANTED) {
            // Permission already Granted
            //Do your work here
            //Perform operations here only which requires permission
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
        }
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
        Intent intent = getIntent();
        String start = intent.getStringExtra("startLocation");
        String destin = intent.getStringExtra("destination");

        // Add a marker in Sydney and move the camera
        LatLng headHall = new LatLng(45.949765, -66.641676);
        LatLng oldHeadHall = new LatLng(45.948972, -66.642207);
        LatLng scienceLib = new LatLng(45.947904, -66.641313);
        LatLng hil = new LatLng(45.946292, -66.642960);
        LatLng sub = new LatLng(45.945318, -66.641281);
        LatLng ccJones = new LatLng(45.945669, -66.639387);
        LatLng currieGym = new LatLng(45.946694, -66.638753);
        LatLng beaverGym = new LatLng(45.948083, -66.638658);
        LatLng registrar = new LatLng(45.948164, -66.641400);
        LatLng forestry = new LatLng(45.948276, -66.642130);
        LatLng bookstore = new LatLng(45.947927, -66.643157);


        double longitude = 45.949765;
        double latitude = -66.641676;
        LatLng current = new LatLng(latitude, longitude);
        LatLng endPoint = new LatLng(latitude, longitude);

        switch (start) {
            case "Head Hall":
                current = headHall;
                break;

            case "Old Head Hall":
                current = oldHeadHall;
                break;

            case "CC Jones":
                current = ccJones;
                break;

            case "Science Library (SIL)":
                current = scienceLib;
                break;

            case "Harriet Irving Library (HIL)":
                current = hil;
                break;

            case "Registrars Office":
                current = registrar;
                break;

            case "Currie Center (New Gym)":
                current = currieGym;
                break;

            case "Lady BeaverBrook Gym (Old Gym)":
                current = beaverGym;
                break;

            case "Student Union Building (SUB)":
                current = sub;
                break;

            case "Forestry Building":
                current = forestry;
                break;

            case "Bookstore / Pharmacy":
                current = bookstore;
                break;

            case "Current Location":
                try {
                    LocationManager lm = (LocationManager) getSystemService(MapsActivity.this.LOCATION_SERVICE);
                    Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                    longitude = location.getLongitude();
                    latitude = location.getLatitude();
                    current = new LatLng(latitude, longitude);
                } catch (SecurityException e) {
                    Toast toast2 = Toast.makeText(getApplicationContext(), "No Location Service", Toast.LENGTH_SHORT);
                    toast2.show();
                }
        }

        switch (destin) {
            case "Head Hall":
                endPoint = headHall;
                break;

            case "Old Head Hall":
                endPoint = oldHeadHall;
                break;

            case "CC Jones":
                endPoint = ccJones;
                break;

            case "Science Library (SIL)":
                endPoint = scienceLib;
                break;

            case "Harriet Irving Library (HIL)":
                endPoint = hil;
                break;

            case "Registrars Office":
                endPoint = registrar;
                break;

            case "Currie Center (New Gym)":
                endPoint = currieGym;
                break;

            case "Lady BeaverBrook Gym (Old Gym)":
                endPoint = beaverGym;
                break;

            case "Student Union Building (SUB)":
                endPoint = sub;
                break;

            case "Forestry Building":
                endPoint = forestry;
                break;

            case "Bookstore / Pharmacy":
                endPoint = bookstore;
                break;

        }

        mMap.addMarker(new MarkerOptions().position(endPoint).title("End"));
        mMap.addMarker(new MarkerOptions().position(current).title("Start"));
        String url = Helper.getUrl(String.valueOf(current.latitude), String.valueOf(current.longitude), String.valueOf(endPoint.latitude), String.valueOf(endPoint.longitude));
        FetchUrl fetchUrl = new FetchUrl();
        fetchUrl.execute(url);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(headHall));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(16));
    }

    private class FetchUrl extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... url) {

            // For storing data from web service
            String data = "";

            try {
                // Fetching the data from web service
                data = downloadUrl(url[0]);
                Log.d("Background Task data", data.toString());
            } catch (Exception e) {
                Log.d("Background Task", e.toString());
            }
            return data;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            ParserTask parserTask = new ParserTask();

            // Invokes the thread for parsing the JSON data
            parserTask.execute(result);

        }
    }

    private String downloadUrl(String strUrl) throws IOException {
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(strUrl);

            // Creating an http connection to communicate with url
            urlConnection = (HttpURLConnection) url.openConnection();

            // Connecting to url
            urlConnection.connect();

            // Reading data from url
            iStream = urlConnection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));

            StringBuffer sb = new StringBuffer();

            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            data = sb.toString();
            Log.d("downloadUrl", data.toString());
            br.close();

        } catch (Exception e) {
            Log.d("Exception", e.toString());
        } finally {
            iStream.close();
            urlConnection.disconnect();
        }
        return data;
    }

    private class ParserTask extends AsyncTask<String, Integer, List<List<HashMap<String, String>>>> {

        // Parsing the data in non-ui thread
        @Override
        protected List<List<HashMap<String, String>>> doInBackground(String... jsonData) {

            JSONObject jObject;
            List<List<HashMap<String, String>>> routes = null;

            try {
                jObject = new JSONObject(jsonData[0]);
                Log.d("ParserTask", jsonData[0].toString());
                DataParser parser = new DataParser();
                Log.d("ParserTask", parser.toString());

                // Starts parsing data
                routes = parser.parse(jObject);
                Log.d("ParserTask", "Executing routes");
                Log.d("ParserTask", routes.toString());

            } catch (Exception e) {
                Log.d("ParserTask", e.toString());
                e.printStackTrace();
            }
            return routes;
        }

        // Executes in UI thread, after the parsing process
        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> result) {
            ArrayList<LatLng> points;
            PolylineOptions lineOptions = null;

            // Traversing through all the routes
            for (int i = 0; i < result.size(); i++) {
                points = new ArrayList<>();
                lineOptions = new PolylineOptions();

                // Fetching i-th route
                List<HashMap<String, String>> path = result.get(i);

                // Fetching all the points in i-th route
                for (int j = 0; j < path.size(); j++) {
                    HashMap<String, String> point = path.get(j);

                    double lat = Double.parseDouble(point.get("lat"));
                    double lng = Double.parseDouble(point.get("lng"));
                    LatLng position = new LatLng(lat, lng);

                    points.add(position);
                }

                // Adding all the points in the route to LineOptions
                lineOptions.addAll(points);
                lineOptions.width(10);
                lineOptions.color(Color.RED);

                Log.d("onPostExecute", "onPostExecute lineoptions decoded");

            }

            // Drawing polyline in the Google Map for the i-th route
            if (lineOptions != null) {
                mMap.addPolyline(lineOptions);
            } else {
                Log.d("onPostExecute", "without Polylines drawn");
            }
        }

    }
}


//45.9636° N, 66.6431° W
//45.949765, -66.641676
//45.948972, -66.642207