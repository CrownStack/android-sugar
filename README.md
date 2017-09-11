

## Welcome to Sugar classes Guidelines:

* [FileUtils](https://github.com/CrownStack/android-sugar/blob/dev/README.md#fileutils)
* [Gallery](https://github.com/CrownStack/android-sugar/blob/dev/README.md#gallery)
* [ImageHelper](https://github.com/CrownStack/android-sugar/blob/dev/README.md#imagehelper)
* [IntentHelper](https://github.com/CrownStack/android-sugar/blob/dev/README.md#intenthelper)
* [Message](https://github.com/CrownStack/android-sugar/blob/dev/README.md#message)
* [NetworkHelper](https://github.com/CrownStack/android-sugar/blob/dev/README.md#networkhelper)
* [ProgressHelper](https://github.com/CrownStack/android-sugar/blob/dev/README.md#progresshelper)
* [AppPreference](https://github.com/CrownStack/android-sugar/blob/dev/README.md#appPreference)
* [DialogHelper](https://github.com/CrownStack/android-sugar/blob/dev/README.md#dialogHelper)
* [StringUtils](https://github.com/CrownStack/android-sugar/blob/dev/README.md#stringUtils)

### [FileUtils](https://github.com/CrownStack/android-sugar/blob/dev/FileUtils.java)
* getPath(final Context context, final Uri uri): To get file path from Uri.

### [Gallery](https://github.com/CrownStack/android-sugar/blob/dev/Gallery.java)
* openPhoto(final int RequestCode): To choose image from Gallery.

### [ImageHelper](https://github.com/CrownStack/android-sugar/blob/dev/ImageHelper.java)
* getBitmapFromGalleryIntent(Context context, Intent data): Convert it into bitMap from gallery Intent.

### [IntentHelper](https://github.com/CrownStack/android-sugar/blob/dev/IntentHelper.java)
* openWebBrowserIntent(String url): Open url in web browser.
* callNumberIntent(String phoneNumber): Make a call on passing number.
* gmailIntent(String[] addresses, String subject, String body) : send email via gmail.
* shareIntent(String message, String chooserDialogTitle) : open share intent.

### [Message](https://github.com/CrownStack/android-sugar/blob/dev/Message.java)
* message(Context context, String message): To show toast message.

### [NetworkHelper](https://github.com/CrownStack/android-sugar/blob/dev/NetworkHelper.java)
* IsOn(final Context ctx): To check Internet connection.

### [ProgressHelper](https://github.com/CrownStack/android-sugar/blob/dev/ProgressHelper.java)
* start(Context context, String message): To start ProgressDialog.
* stop(): To stop ProgressDialog.

### [AppPreference](https://github.com/CrownStack/android-sugar/blob/dev/AppPreference.java)
To strore value in preferance, get and remove value from preferance.

### [DialogHelper](https://github.com/CrownStack/android-sugar/blob/dev/DialogHelper.java)
* showConfirmDialog(Activity activity, String message): show confirmation dialog.
* showAlertDialog(Activity activity, String message): show alert dialog.

### [StringUtils](https://github.com/CrownStack/android-sugar/blob/dev/StringUtils.java)
* isValidEmail(String emailId): check emailId format is valid or not.
