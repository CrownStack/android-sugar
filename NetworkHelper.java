package com.e2cc.sugar;

import android.content.Context;
import android.net.ConnectivityManager;

public class NetworkHelper {

    private static ConnectivityManager _connectivityManager;

    public static boolean IsOn(final Context ctx) {
        if (_connectivityManager == null) _connectivityManager = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        return _connectivityManager.getActiveNetworkInfo() != null && _connectivityManager.getActiveNetworkInfo().isAvailable() && _connectivityManager.getActiveNetworkInfo().isConnectedOrConnecting();
    }
}
