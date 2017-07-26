import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;

import java.io.IOException;

public class ImageHelper {

    public static Bitmap getBitmapFromGalleryIntent(Context context, Intent data) {
        if (data != null) {
            try {
                return MediaStore.Images.Media.getBitmap(context.getApplicationContext().getContentResolver(), data.getData());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
