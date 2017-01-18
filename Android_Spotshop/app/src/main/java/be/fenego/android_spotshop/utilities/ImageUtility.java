package be.fenego.android_spotshop.utilities;
import android.graphics.Bitmap;

/**
 * Created by Nick on 12/01/2017.
 */

@SuppressWarnings("DefaultFileTemplate")
public class ImageUtility {
    public static Bitmap scaleImageDown(Bitmap bitmap, @SuppressWarnings("SameParameterValue") int maxDimension){
        int originalWidth = bitmap.getWidth();
        int originalHeight = bitmap.getHeight();
        int resizedWidth = maxDimension;
        int resizedHeight = maxDimension;

        if (originalHeight > originalWidth) {
            resizedHeight = maxDimension;
            resizedWidth = (int) (resizedHeight * (float) originalWidth / (float) originalHeight);
        } else if (originalWidth > originalHeight) {
            resizedWidth = maxDimension;
            resizedHeight = (int) (resizedWidth * (float) originalHeight / (float) originalWidth);
        } else if (originalHeight == originalWidth) {
            resizedHeight = maxDimension;
            resizedWidth = maxDimension;
        }
        return Bitmap.createScaledBitmap(bitmap, resizedWidth, resizedHeight, false);
    }
}
