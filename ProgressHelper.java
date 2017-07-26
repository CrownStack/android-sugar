
import android.app.ProgressDialog;
import android.content.Context;

public class ProgressHelper {

    private static ProgressDialog mProgressDialog;

    public static void start(Context context, String message) {
        mProgressDialog = new ProgressDialog(context);
        mProgressDialog.setMessage(message);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
    }

    public static void stop() {
        if (mProgressDialog.isShowing()) mProgressDialog.dismiss();
    }
}
