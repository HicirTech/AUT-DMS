package com.example.lab8e3;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    private LocationManager locationManager;
    private LocationProvider locationProvider;
    private final int REQUEST_CODE_ASK_PERMISSIONS = 123;
    private boolean hasPermission;
    private TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.display = findViewById(R.id.display);
        this.hasPermission = false;

    }

    public void getLocationManager(View view) {
        if (!hasPermission) this.requestPermission();
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Toast.makeText(this, "Get LocationManagerButton Clicked, location of the devices is:" + locationManager.isLocationEnabled() +
                " Now location provider is " + ((this.locationProvider == null) ? "NULL" : this.locationProvider.getName()), Toast.LENGTH_LONG).show();
    }

    public void getGPSProviderButtonOnclick(View view) {
        if (this.locationManager != null) {
            Toast.makeText(this, "Get get provider button Clicked, this devices has location provider:" + locationManager.getAllProviders(), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "LocationManager is null, please click the [Get Location Manager] button above first", Toast.LENGTH_LONG).show();
        }
    }

    public void isGPSEnabledButtonOnclick(View view) {
        if (this.locationManager != null) {
            this.locationProvider = locationManager.getProvider(LocationManager.NETWORK_PROVIDER);
            Toast.makeText(this, locationProvider.getName()+" is now the location provider, "
                            + " GPS is enable: " + locationManager.isProviderEnabled(locationProvider.getName())
                            + " GPS Altitude support: " + this.locationProvider.supportsAltitude()
                            + " GPS bearing support: " + this.locationProvider.supportsBearing()
                            + " GPS speed support: " + this.locationProvider.supportsSpeed()
                    , Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "LocationManager is null, please click the [Get Location Manager] button above first", Toast.LENGTH_LONG).show();
        }
    }

    public void getGPSButtonOnclick(View view) {

        if(this.locationProvider!=null&&this.locationManager!=null) {


            try {
                locationManager.requestLocationUpdates(locationProvider.getName(), 5000, 1000, new LocationListener() {
                    @Override
                    public void onLocationChanged(Location location) {
                        Toast.makeText(MainActivity.this, "Altitude :" + location.getAltitude() + System.getProperty("line.separator")
                                + "Latitude: " + location.getLatitude() + System.getProperty("line.separator")
                                + "Longitude" + location.getLongitude(), Toast.LENGTH_LONG).show();
                        setText(location.getAltitude(), location.getLatitude(), location.getLongitude());
                    }

                    @Override
                    public void onStatusChanged(String provider, int status, Bundle extras) {

                    }

                    @Override
                    public void onProviderEnabled(String provider) {

                    }

                    @Override
                    public void onProviderDisabled(String provider) {

                    }
                });
            } catch (SecurityException e) {
                Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_LONG).show();
                // requestPermission();
            }
        }else {
            Toast.makeText(MainActivity.this,"CLick the upper 3 button first", Toast.LENGTH_LONG).show();
        }
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,}, REQUEST_CODE_ASK_PERMISSIONS);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    this.hasPermission = true;} else {
                    // Permission Denied
                    Toast.makeText(this, "Location Permission Denied", Toast.LENGTH_SHORT).show();
                    this.hasPermission = false;
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    private void setText(double a, double la,double lo) {
        display.setVisibility(View.VISIBLE);
        display.setText(
                "Altitude :"+ a+System.getProperty ("line.separator")
                +"Latitude: "+la+System.getProperty ("line.separator")
                +"Longitude"+lo);
    }


}
