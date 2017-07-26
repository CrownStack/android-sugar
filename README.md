##### Welcome to Sugar classes Gildelines:

### [FileUtils](https://github.com/CrownStack/android-sugar/blob/dev/FileUtils.java)

* getPath(): To get file path from Uri.

Ex: String path =  FileUtils.getPath(this, data.getData());

### [Gallery](https://github.com/CrownStack/android-sugar/blob/dev/Gallery.java)

* openPhoto(): To choose image from Gallery.

Ex: @RequiresPermission(allOf = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE})
    private void openGallery(int requestCode) {
        Gallery gallery = new Gallery(this);
        gallery.openPhoto(REQUEST_GALLERY);
          }
          
           @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            switch (requestCode) {

                case REQUEST_GALLERY:
                    relativeUploadOne.setVisibility(View.VISIBLE);
                    setPhoto(data, REQUEST_GALLERY);
                    break;           
            }
        }
    }

### [ImageHelper](https://github.com/CrownStack/android-sugar/blob/dev/ImageHelper.java)

* getBitmapFromGalleryIntent(): Convert it into bitMap from gallery Intent.

Ex:     private void setPhoto(Intent data, int REQUEST) {
        if (ImageHelper.getBitmapFromGalleryIntent(this, data) != null) {
            if(REQUEST == REQUEST_GALLERY) {
                imageFirstPath = FileUtils.getPath(this, data.getData());
                imageView.setImageBitmap(ImageHelper.getBitmapFromGalleryIntent(this, data));
            }                     
        }
    }

### [IntentHelper](https://github.com/CrownStack/android-sugar/blob/dev/IntentHelper.java)

* openWebBrowserIntent(): By passing url it will open in web browser.

Ex: startActivity(IntentHelper.openWebBrowserIntent(CHAT_LINK));

* callNumberIntent(): By passing phone number it will call.

Ex: void callTapped() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            Message.message(this, getString(R.string.go_to_setting));
            return;
        }
        showConfirmPopUp();
    }
    
    @RequiresPermission(Manifest.permission.CALL_PHONE)
    private void showConfirmPopUp() {
        PopUpHelper.showConfirmPopup(this, "Are you sure you want to call: \n 1-800-123-1234?", new PopUpHelper.ConfirmPopup() {
            @Override
            public void onConfirm(boolean isConfirm) {
                if (isConfirm) startActivity(IntentHelper.callNumberIntent(1-800-123-1234));
            }

            @Override
            public void onDismiss(boolean isDismiss) {
            }
        });
    }

### [Message](https://github.com/CrownStack/android-sugar/blob/dev/Message.java)

* message(): To show toast message.

Ex:  Message.message(this, "Show message");

### [NetworkHelper](https://github.com/CrownStack/android-sugar/blob/dev/NetworkHelper.java)

* IsOn(): To check Internet connection.

Ex: if (NetworkHelper.IsOn(this)) {Your code}
    else Message.message(this, "Check your internet connection.");

### [ProgressHelper](https://github.com/CrownStack/android-sugar/blob/dev/ProgressHelper.java)

* start(): To start ProgressDialog.

Ex: ProgressHelper.start(this, getString(R.string.please_wait));

* stop(): To stop ProgressDialog.

Ex:  ProgressHelper.stop();
