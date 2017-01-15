package be.fenego.android_spotshop.callbacks;

import com.google.api.services.vision.v1.model.BatchAnnotateImagesResponse;

/**
 * Created by Nick on 13/01/2017.
 */

@SuppressWarnings("DefaultFileTemplate")
public interface CloudVisionCallback {
    void onSuccessPostImage(BatchAnnotateImagesResponse cloudVisionResponse);
    void onErrorPostImage();
}
