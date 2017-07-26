package com.e2cc.sugar;

import android.content.Intent;
import android.net.Uri;

public class IntentHelper {

    public static Intent openWebBrowserIntent(String url) {
        if (!url.startsWith("https://") && !url.startsWith("http://")) url = "http://" + url;
        return new Intent(Intent.ACTION_VIEW, Uri.parse(url));
    }

    public static Intent callNumberIntent(String phoneNumber) {
        final Intent intent;
        if (phoneNumber == null || phoneNumber.trim().length() <= 0) intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"));
        else intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber.replace(" ", "")));

        return intent;
    }
}
