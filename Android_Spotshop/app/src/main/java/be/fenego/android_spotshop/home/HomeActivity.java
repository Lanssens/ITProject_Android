package be.fenego.android_spotshop.home;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import be.fenego.android_spotshop.R;
import be.fenego.android_spotshop.model.Element;
import be.fenego.android_spotshop.model.ProductCollection;
import be.fenego.android_spotshop.productDetails.ProductDetailsActivity;
import be.fenego.android_spotshop.service.ProductService;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeActivity extends AppCompatActivity {

    private static final int REQUEST_IMAGE_CAPTURE = 1;

    ProductCollection productCollection = null;
    ArrayList<Element> elementList = null;

    ProductService productService;
    ArrayAdapter<Element> productAdapter;
    Bitmap imageBitmap;
    String imageBase64;

    @BindView(R.id.productListView)
    ListView productListView;

    @BindView(R.id.searchButton)
    ImageButton searchButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        //Service instantie aanmaken voor calls uit te voeren.
        productService = ProductService.retrofit.create(ProductService.class);

        //Call die uitgevoerd kan worden via setProductAdapter methode.
        //Call<ProductCollection> getProducts = productService.getProducts();
        Call<ProductCollection> getFeaturedProducts = productService.getFeaturedProducts();

        setProductAdapter(getFeaturedProducts);

    }

    //Geeft detailpagina weer voor bepaald product.
    @OnItemClick(R.id.productListView)
    void showProductDetails(AdapterView<?> adapterView, View view, int i, long l){
        try{
            if(productCollection != null && elementList != null){
                Intent productDetailIntent = new Intent(this, ProductDetailsActivity.class);
                productDetailIntent.putExtra("ProductURI", elementList.get(i).getUri());
                startActivity(productDetailIntent);
            }
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Could not display product details!",Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    @OnClick(R.id.imagePickerButton)
    void openCamera(){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            if(resultCode == RESULT_OK){
                imageBitmap = (Bitmap) data.getExtras().get("data");
                imageBase64 = bitmapToBase64(imageBitmap);
                Log.v("ImageBase64: ", imageBase64);
            }else{
                //TODO: gecancelled
                Log.v("Error: ", "image was not taken");
            }
        }
    }

    private String bitmapToBase64(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream .toByteArray();
        return Base64.encodeToString(byteArray, Base64.DEFAULT);
    }

    //Call uitvoeren & response opslaan & adapter initialiseren en toevoegen aan listview.
    private void setProductAdapter(Call<ProductCollection> call){
        try{
            call.enqueue(new Callback<ProductCollection>() {
                @Override
                public void onResponse(Call<ProductCollection> call, Response<ProductCollection> response) {
                    productCollection = response.body();
                    elementList = (ArrayList<Element>) productCollection.getElements();
                    productAdapter = new ProductAdapter(getApplicationContext(), elementList);
                    productListView.setAdapter(productAdapter);
                }

                @Override
                public void onFailure(Call<ProductCollection> call, Throwable t) {
                    Toast.makeText(getApplicationContext(),"Could not display products!\nGetting product list failed!",Toast.LENGTH_SHORT).show();
                    t.printStackTrace();
                }
            });
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),"Could not display product list!",Toast.LENGTH_SHORT).show();
        }
    }
}


