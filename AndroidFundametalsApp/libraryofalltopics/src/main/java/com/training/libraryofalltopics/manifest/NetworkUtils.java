package com.training.libraryofalltopics.manifest;

//import static androidx.core.content.ContextCompat.getSystemService;
//import android.net.NetworkInfo;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;

import androidx.appcompat.app.AppCompatActivity;

public class NetworkUtils extends AppCompatActivity {
    public static boolean isNetworkAvailable(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm == null) return false;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Network network = cm.getActiveNetwork();
            if (network == null) return false;

            NetworkCapabilities caps = cm.getNetworkCapabilities(network);
            return caps != null
                    && caps.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                    && caps.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED);
        } else {
            Network[] networks = cm.getAllNetworks();
            for (Network network : networks) {
                NetworkCapabilities caps = cm.getNetworkCapabilities(network);
                if (caps != null && caps.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)) {
                    return true;
                }
            }
            return false;
        }
    }
}
