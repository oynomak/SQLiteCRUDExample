package edu.oynomak.sqlitecrudexample;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class GoogleMapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_maps);
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

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        /*
        ********* Setting Google Map Type *********

        Using the google map object we can change the map type too.
        There are four different types of map and each give different view of the map.
        These types are Normal, Hybrid, Satellite and Terrain. We can use them as given below.
        */
        // googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        // googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        // googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);

        /*
        ********* Google Map Zoom, Rotation *********

        We can enable/disable map zoom and rotations using the following lines of codes:
         */
        googleMap.getUiSettings().setZoomGesturesEnabled(true);
        googleMap.getUiSettings().setRotateGesturesEnabled(true);
        /*
        ********* Some other customization methods available in the GoogleMap class are given below. *********

        googleMap.addCircle(CircleOptions options) : This method add a circle to the map
        googleMap.addPolygon(PolygonOptions options) : This method add a polygon to the map
        googleMap.addTileOverlay(TileOverlayOptions options) : This method add tile overlay to the map
        googleMap.animateCamera(CameraUpdate update) : This method Moves the map according to the update with an animation
        googleMap.clear() : This method removes everything from the map
        googleMap.getMyLocation() : This method returns the currently displayed user location
        googleMap.moveCamera(CameraUpdate update) : This method repositions the camera according to the instructions defined in the update
        googleMap.setTrafficEnabled(boolean enabled) : This method Toggles the traffic layer on or off
        googleMap.snapshot(GoogleMap.SnapshotReadyCallback callback) : This method Takes a snapshot of the map
        googleMap.stopAnimation() : This method stops the camera animation if there is one in progress

         */

        /*
         *********     Adding Markers on the Google Map *********
         */
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(37.4233438,-122.0728817))
                .title("LinkedIn")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(37.4629101,-122.2449094))
                .title("Facebook")
                .snippet("Facebook HQ: Menlo Park"));

        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(37.3092293,-122.1136845))
                .title("Apple"));

    }
}

/*
SOURCE:
        - https://www.journaldev.com/10380/android-google-maps-example-tutorial
        - https://www.tutorialspoint.com/android/android_google_maps.htm
        - https://www.vogella.com/tutorials/AndroidGoogleMaps/article.html
 */
