package com.example.varun.maps;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;


public class MapsActivity extends FragmentActivity implements OnConnectionFailedListener {

    private GoogleMap mMap;
    private GoogleApiClient mGoogleApiClient;
    LocationManager locationManager;
    private TextView mLatitudeText;
    private TextView mLongitudeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        if (mGoogleApiClient == null) {
            mGoogleApiClient= new GoogleApiClient.Builder(this)
                    .enableAutoManage(this /* FragmentActivity */,
                            this /* OnConnectionFailedListener */)
                    .addApi(Drive.API)
                    .addScope(Drive.SCOPE_FILE)
                    .setAccountName("varun.rao095@gmail.com")
                    .build();
        }

        locationManager=(LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        LocationListener locationListener=new LocationListener() {
            @Override
            public  void onLocationChanged(Location location) {


            }
        };
   }


    public void onStart(){
        mGoogleApiClient.connect();
        super.onStart();
    }
    public void onConnected(Bundle connectionHint){
       mLatitudeText =(TextView) findViewById(R.id.mLatitudeText);
        mLongitudeText=(TextView) findViewById(R.id.mLongitudeText);

      try {
          Location mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                  mGoogleApiClient);
          if (mLastLocation != null) {
              mLatitudeText.setText(String.valueOf(mLastLocation.getLatitude()));
              mLongitudeText.setText(String.valueOf(mLastLocation.getLongitude()));
          }
      }
      catch(SecurityException e){
          System.out.println(e);
      }
    }
    public void onConnectionFailed(ConnectionResult result){

    }
}
