package com.e2cc.fusedLocation;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.LocationManager;

public class LocationHelper {

    public static String getAddressByLatLong(Context context, double latitude, double longitude) {
        String outputAddress = "";
        Geocoder geocoder = new Geocoder(context, Locale.getDefault());
        try {
            List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
            for (android.location.Address address : addresses) {
                for (int i = 0; i < address.getMaxAddressLineIndex(); i++) {
                    outputAddress += address.getAddressLine(i);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return outputAddress;
    }

    public static boolean checkLocationStatus(Context context) {
        LocationManager lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        boolean gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (!gps_enabled) return false;

        return true;
    }
}
