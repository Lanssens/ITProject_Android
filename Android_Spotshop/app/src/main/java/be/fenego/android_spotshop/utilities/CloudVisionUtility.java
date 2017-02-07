package be.fenego.android_spotshop.utilities;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.vision.v1.Vision;
import com.google.api.services.vision.v1.VisionRequest;
import com.google.api.services.vision.v1.VisionRequestInitializer;
import com.google.api.services.vision.v1.model.AnnotateImageRequest;
import com.google.api.services.vision.v1.model.BatchAnnotateImagesRequest;
import com.google.api.services.vision.v1.model.BatchAnnotateImagesResponse;
import com.google.api.services.vision.v1.model.Feature;
import com.google.api.services.vision.v1.model.Image;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import be.fenego.android_spotshop.callbacks.CloudVisionCallback;

/**
 * Created by Nick on 13/01/2017.
 * utility voor het ophalen van annotations van een afbeelding via google cloud vision.
 */

public class CloudVisionUtility {
    private static final String ANDROID_CERT_HEADER = "X-Android-Cert";
    private static final String ANDROID_PACKAGE_HEADER = "X-Android-Package";
    private static final String CLOUD_VISION_API_KEY = "AIzaSyAxOtQGcr5J11JNALl91xn63XW8ncew52Q";

    public static void postImage(final CloudVisionCallback callback, final Bitmap bitmap) {
        final Fragment f = (Fragment) callback;
        new AsyncTask<Object, Void, BatchAnnotateImagesResponse>() {
            @Override
            protected BatchAnnotateImagesResponse doInBackground(Object... params) {
                BatchAnnotateImagesResponse response;
                try {
                    HttpTransport httpTransport = AndroidHttp.newCompatibleTransport();
                    JsonFactory jsonFactory = GsonFactory.getDefaultInstance();

                    VisionRequestInitializer requestInitializer =
                            new VisionRequestInitializer(CLOUD_VISION_API_KEY) {
                                @Override
                                protected void initializeVisionRequest(VisionRequest<?> visionRequest)
                                        throws IOException {
                                    super.initializeVisionRequest(visionRequest);

                                    String packageName = f.getContext().getPackageName();
                                    visionRequest.getRequestHeaders().set(ANDROID_PACKAGE_HEADER, packageName);

                                    String sig = PackageManagerUtility.getSignature(f.getContext().getPackageManager(), packageName);

                                    visionRequest.getRequestHeaders().set(ANDROID_CERT_HEADER, sig);
                                }
                            };

                    Vision.Builder builder = new Vision.Builder(httpTransport, jsonFactory, null);
                    builder.setVisionRequestInitializer(requestInitializer);

                    Vision vision = builder
                            .setApplicationName("Android_Spotshop")
                            .build();

                    BatchAnnotateImagesRequest batchAnnotateImagesRequest =
                            new BatchAnnotateImagesRequest();
                    batchAnnotateImagesRequest.setRequests(new ArrayList<AnnotateImageRequest>() {{
                        AnnotateImageRequest annotateImageRequest = new AnnotateImageRequest();

                        // Add the image
                        Image base64EncodedImage = new Image();
                        // Convert the bitmap to a JPEG
                        // Just in case it's a format that Android understands but Cloud Vision
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 90, byteArrayOutputStream);
                        byte[] imageBytes = byteArrayOutputStream.toByteArray();

                        // Base64 encode the JPEG
                        base64EncodedImage.encodeContent(imageBytes);
                        annotateImageRequest.setImage(base64EncodedImage);

                        // add the features we want
                        annotateImageRequest.setFeatures(new ArrayList<Feature>() {{
                            Feature labelDetection = new Feature();
                            Feature logoDetection = new Feature();
                            Feature textDetection = new Feature();
                            labelDetection.setType("LABEL_DETECTION");
                            logoDetection.setType("LOGO_DETECTION");
                            textDetection.setType("LABEL_DETECTION");
                            labelDetection.setMaxResults(10);
                            logoDetection.setMaxResults(10);
                            textDetection.setMaxResults(10);
                            add(labelDetection);
                            add(logoDetection);
                            add(textDetection);
                        }});

                        // Add the list of one thing to the request
                        add(annotateImageRequest);
                    }});

                    Vision.Images.Annotate annotateRequest =
                            vision.images().annotate(batchAnnotateImagesRequest);
                    // Due to a bug: requests to Vision API containing large images fail when GZipped.
                    annotateRequest.setDisableGZipContent(true);
                    Log.d(f.getTag(), "created Cloud Vision request object, sending request");

                    response = annotateRequest.execute();
                    return response;

                } catch (GoogleJsonResponseException e) {
                    Log.d(f.getTag(), "failed to make API request because " + e.getContent());
                } catch (IOException e) {
                    Log.d(f.getTag(), "failed to make API request because of other IOException " +
                            e.getMessage());
                }
                return null;
            }

            @Override
            protected void onPostExecute(BatchAnnotateImagesResponse response) {
                callback.onSuccessPostImage(response);
            }

            @Override
            protected void onCancelled() {
                //Toast.makeText(f.getContext(), "Could not find products for image!", Toast.LENGTH_LONG).show();
                callback.onErrorPostImage();
            }
        }.execute();
    }
}
