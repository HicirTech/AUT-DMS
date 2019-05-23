package com.example.lab8e3;

import android.content.Context;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private LocationManager locationManager;
    private LocationProvider locationProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getLocationManager(View view) {
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Toast.makeText(this,"Get LocationManagerButton Clicked, location of the devices is:"+locationManager.isLocationEnabled(),Toast.LENGTH_LONG).show();
        System.out.println(getSystemService(Context.LOCATION_SERVICE));
    }

    public void getGPSProviderButtonOnclick(View view) {
    }

    public void isGPSEnabledButtonOnclick(View view) {
    }

    public void getGPSButtonOnclick(View view) {
    }
}
