import android.content.Intent;
import android.net.Uri;

public class IntentHelper {

    private static final String MIME_TYPE_EMAIL = "message/rfc822";
    private static final String MIME_TYPE_TEXT = "text/*";

    public static Intent openWebBrowserIntent(String url) {
        if (!url.startsWith("https://") && !url.startsWith("http://")) url = "http://" + url;
        return new Intent(Intent.ACTION_VIEW, Uri.parse(url));
    }

    public static Intent callNumberIntent(String phoneNumber) {
        final Intent intent;
        if (phoneNumber == null || phoneNumber.trim().length() <= 0)
            intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"));
        else
            intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber.replace(" ", "")));

        return intent;
    }

    public static Intent gmailIntent(String[] addresses, String subject, String body) {
        final Intent intent = new Intent(Intent.ACTION_SEND);
        if (addresses != null)
            intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        if (body != null)
            intent.putExtra(Intent.EXTRA_TEXT, body);
        if (subject != null)
            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.setType(MIME_TYPE_EMAIL);
        intent.setPackage("com.google.android.gm");

        return intent;
    }

    public static Intent shareIntent(String message, String chooserDialogTitle) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT, message);
        shareIntent.setType(MIME_TYPE_TEXT);

        return Intent.createChooser(shareIntent, chooserDialogTitle);
    }

    public static Intent openWebBrowserIntent(String url) {
        if (!url.startsWith("https://") && !url.startsWith("http://")) {
            url = "http://" + url;
        }

        return new Intent(Intent.ACTION_VIEW, Uri.parse(url));
    }

    public static Intent settingIntent() {
        return new Intent(Settings.ACTION_SETTINGS);
    }
}
