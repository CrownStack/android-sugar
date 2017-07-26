
import android.content.Context;
import android.net.ConnectivityManager;

public class NetworkHelper {

    private static ConnectivityManager sConnectivityManager;

    public static boolean IsOn(final Context ctx) {
        if (sConnectivityManager == null) sConnectivityManager = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        return sConnectivityManager.getActiveNetworkInfo() != null && sConnectivityManager.getActiveNetworkInfo().isAvailable() && sConnectivityManager.getActiveNetworkInfo().isConnectedOrConnecting();
    }
}
