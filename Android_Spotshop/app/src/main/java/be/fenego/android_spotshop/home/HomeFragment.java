package be.fenego.android_spotshop.home;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;
import com.google.api.services.vision.v1.model.BatchAnnotateImagesResponse;
import com.google.api.services.vision.v1.model.EntityAnnotation;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import be.fenego.android_spotshop.R;
import be.fenego.android_spotshop.callbacks.CloudVisionCallback;
import be.fenego.android_spotshop.callbacks.CustomerCallback;
import be.fenego.android_spotshop.models.Customer;
import be.fenego.android_spotshop.models.searchHistory.HistoryItem;
import be.fenego.android_spotshop.utilities.CloudVisionUtility;
import be.fenego.android_spotshop.utilities.CustomerUtility;
import be.fenego.android_spotshop.utilities.ImageUtility;
import be.fenego.android_spotshop.utilities.LoginUtility;
import be.fenego.android_spotshop.utilities.PermissionUtility;
import be.fenego.android_spotshop.callbacks.ProductCallback;
import be.fenego.android_spotshop.utilities.ProductUtility;
import be.fenego.android_spotshop.models.Element;
import be.fenego.android_spotshop.models.ProductCollection;
import be.fenego.android_spotshop.models.ProductDetails;
import be.fenego.android_spotshop.productDetails.ProductDetailsFragment;
import be.fenego.android_spotshop.utilities.SearchHistoryUtility;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import retrofit2.Call;
import static android.app.Activity.RESULT_OK;


/**
 * Created by Nick on 11/01/2017.
 */

@SuppressWarnings({"WeakerAccess", "UnusedParameters", "DefaultFileTemplate"})
public class HomeFragment extends Fragment implements CloudVisionCallback, ProductCallback, CustomerCallback{
    //images
    private static final int GALLERY_PERMISSIONS_REQUEST = 0;
    private static final int GALLERY_IMAGE_REQUEST = 1;
    private static final int CAMERA_PERMISSIONS_REQUEST = 2;
    private static final int CAMERA_IMAGE_REQUEST = 3;
    private static final String FILE_NAME = "temp.jpg";

    private HistoryItem historyItem;

    private ArrayList<Element> elementList = null;

    @BindView(R.id.productListView)
    ListView productListView;

    @BindView(R.id.searchButton)
    ImageButton searchButton;

    @BindView(R.id.searchEditText)
    EditText searchEditText;

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_activity_home,container, false);
        ButterKnife.bind(this, view);

        ProductUtility.getFeaturedProducts(this);

        return view;
    }

    //Geeft detailpagina weer voor bepaald product.
    @OnItemClick(R.id.productListView)
    void showProductDetails(AdapterView<?> adapterView, View view, int i, long l){
        ProductUtility.getProductDetails(this,elementList.get(i).getUri());
    }

    //Zoekt producten via tekst.
    @OnClick(R.id.searchButton)
    void searchProducts(View view){
        if(!searchEditText.getText().toString().isEmpty()){
            ProductUtility.getProductByText(this, searchEditText.getText().toString());
        }
    }

    //Dialog voor afbeelding te maken / image te selecteren.
    @OnClick(R.id.imagePickerButton)
    void openImageChooser(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder
                .setMessage(R.string.dialog_select_prompt)
                .setPositiveButton(R.string.dialog_select_gallery, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startGalleryChooser();
                    }
                })
                .setNegativeButton(R.string.dialog_select_camera, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startCamera();
                    }
                });
        builder.create().show();
    }

    //Zal de gallerychooser oproepen.
    private void startGalleryChooser() {
        if (PermissionUtility.requestPermission(this, GALLERY_PERMISSIONS_REQUEST, Manifest.permission.READ_EXTERNAL_STORAGE)) {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select a photo"),
                    GALLERY_IMAGE_REQUEST);
        }
    }

    //Zal camera app starten.
    private void startCamera() {
        if (PermissionUtility.requestPermission(
                this,
                CAMERA_PERMISSIONS_REQUEST,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA)) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(getCameraFile()));
            startActivityForResult(intent, CAMERA_IMAGE_REQUEST);
        }
    }

    //Haalt gemaakte afbeelding op.
    private File getCameraFile() {
        File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        return new File(dir, FILE_NAME);
    }

    //Afbeelding doorsturen naar Google.
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GALLERY_IMAGE_REQUEST && resultCode ==  RESULT_OK && data != null) {
            uploadImage(data.getData());
        } else if (requestCode == CAMERA_IMAGE_REQUEST && resultCode == RESULT_OK) {
            uploadImage(Uri.fromFile(getCameraFile()));
        }
    }

    //Scaled afbeelding down & roept cloudvision utility op.
    private void uploadImage(Uri uri) {
        if (uri != null) {
            try {
                // scale the image to save on bandwidth
                Bitmap bitmap = ImageUtility.scaleImageDown(MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), uri),
                        1200);

                //voegt image toe aan historyitem + zet om naar base64
                Bitmap bitmaps = ImageUtility.scaleImageDown(MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), uri),
                        200);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmaps.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream .toByteArray();
                String encoded = Base64.encodeToString(byteArray, Base64.DEFAULT);
                historyItem = new HistoryItem();
                historyItem.setImageString(encoded);

                //roept utility op voor cloudvision aan te spreken
                CloudVisionUtility.postImage(this,bitmap);
            } catch (IOException e) {
                Log.d(getTag(), "Image picking failed because " + e.getMessage());
                Toast.makeText(getContext(), "Something is wrong with that image. Pick a different one please.", Toast.LENGTH_LONG).show();
            }
        } else {
            Log.d(getTag(), "Image picker gave us a null image.");
            Toast.makeText(getContext(), "Something is wrong with that image. Pick a different one please.", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onSuccessPostImage(BatchAnnotateImagesResponse cloudVisionResponse) {
        String annotationParameter = formatResponse(cloudVisionResponse);
        ProductUtility.getProductsByImage(this,annotationParameter);
        if(LoginUtility.isUserLoggedIn()){
            CustomerUtility.getCustomerData(this);
        }else{
            historyItem.setCustomerId("Anonymous_Android");
            SearchHistoryUtility.postSearchHistory(historyItem);
        }
    }

    @Override
    public void onErrorPostImage() {
        Toast.makeText(getContext(),"Could not get products from image!\nGetting product list failed!",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccessGetProduct(ProductDetails productDetails) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("productDetails",productDetails);

        ProductDetailsFragment productDetailsFragment = new ProductDetailsFragment();
        productDetailsFragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.flContent, productDetailsFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onErrorGetProduct(Call<ProductDetails> call, Throwable t) {
        Toast.makeText(getContext(),"Could not display product details!",Toast.LENGTH_SHORT).show();
        t.printStackTrace();
    }

    @Override
    public void onSuccessGetFeaturedProducts(ProductCollection productCollection) {
        handleSuccess(productCollection);
    }

    @Override
    public void onErrorGetFeaturedProducts(Call<ProductCollection> call, Throwable t) {
        Toast.makeText(getContext(),"Could not display products!\nGetting product list failed!",Toast.LENGTH_SHORT).show();
        t.printStackTrace();
    }

    @Override
    public void onSuccessGetProductsByImage(ProductCollection productCollection) {
        handleSuccess(productCollection);
    }

    @Override
    public void onErrorGetProductsByImage(Call<ProductCollection> call, Throwable t) {
        t.printStackTrace();
        Toast.makeText(getContext(),"Could not get products from image!\nGetting product list failed!",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccessGetProductsByText(ProductCollection productCollection) {
        handleSuccess(productCollection);
    }

    @Override
    public void onErrorGetProductsByText(Call<ProductCollection> call, Throwable t) {
        t.printStackTrace();
        Toast.makeText(getContext(),"Could not get products from database!\nGetting product list failed!",Toast.LENGTH_SHORT).show();
    }

    //handelt success af.
    private void handleSuccess(ProductCollection productCollection){
        elementList = (ArrayList<Element>) productCollection.getElements();
        if(!productCollection.getElements().isEmpty()){
            setProductAdapter();
        }else{
            Toast.makeText(getContext(),"No products found!",Toast.LENGTH_SHORT).show();
        }
    }

    //Adapter initialiseren en toevoegen aan listview.
    private void setProductAdapter(){
        ArrayAdapter<Element> productAdapter = new ProductAdapter(getContext(), elementList);
        productListView.setAdapter(productAdapter);
    }

    //Mehtode die output format voor aan call mee te geven.
    private String formatResponse(BatchAnnotateImagesResponse cloudVisionResponse){
        String result = "inSPIRED-inTRONICS-Site/-/products?attrs=image,roundedAverageRating,salePrice,availability&searchTerm=*";
        List<String> historyList = new ArrayList<String>();;

        List<EntityAnnotation> annotations = new ArrayList<>();
        if(cloudVisionResponse.getResponses().get(0).getLabelAnnotations() != null)
            annotations.addAll(cloudVisionResponse.getResponses().get(0).getLabelAnnotations());
        if(cloudVisionResponse.getResponses().get(0).getLogoAnnotations() != null)
            annotations.addAll(cloudVisionResponse.getResponses().get(0).getLogoAnnotations());
        if(cloudVisionResponse.getResponses().get(0).getTextAnnotations() != null)
            annotations.addAll(cloudVisionResponse.getResponses().get(0).getTextAnnotations());

        for(EntityAnnotation entityAnnotation : annotations){
            if(entityAnnotation.getScore() > 0.5){  //zekerheid ratio
                result += entityAnnotation.getDescription() + "*";
                //add to historyitem
                historyList.add(entityAnnotation.getDescription());
            }
        }

        historyItem.setTags(historyList);

        return result;
    }

    @Override
    public void onSuccessCustomer(Customer customer) {
        historyItem.setCustomerId(customer.getCustomerNo());
        SearchHistoryUtility.postSearchHistory(historyItem);
    }

    @Override
    public void onError() {
        Log.v("fail", "fail");
    }
}
