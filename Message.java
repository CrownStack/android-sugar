import android.content.Context;
import android.widget.Toast;

public class Message {

    public static void message(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static Snackbar createSnackbar(Context context, View view, String message) {
        return Snackbar.make(view, message, Snackbar.LENGTH_LONG).show();
    }

    public static Snackbar createSnackbarIndefinite(Context context, View view, String message) {
        return Snackbar.make(view, message, Snackbar.LENGTH_INDEFINITE).show();
    }

    public static Snackbar createSnackbarMultiLine(Context context, View view, String message) {
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT);
        TextView snackbarTextView = (TextView) snackbar.getView().findViewById(android.support.design.R.id.snackbar_text);
        snackbarTextView.setMaxLines(999);
        snackbar.show();

        return snackbar;
    }
}
