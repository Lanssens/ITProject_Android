package be.fenego.android_spotshop.general;

import com.google.api.services.vision.v1.model.BatchAnnotateImagesResponse;

/**
 * Created by Nick on 13/01/2017.
 */

public interface CloudVisionCallback {
    void onSuccessPostImage(BatchAnnotateImagesResponse cloudVisionResponse);
    void onErrorPostImage();
}
