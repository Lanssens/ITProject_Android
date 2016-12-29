package be.fenego.android_spotshop.home;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import be.fenego.android_spotshop.R;
import be.fenego.android_spotshop.model.Element;
import be.fenego.android_spotshop.model.ProductCollection;
import be.fenego.android_spotshop.service.ProductService;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeActivity extends AppCompatActivity {

    private static final int REQUEST_IMAGE_CAPTURE = 1;

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

        productService = ProductService.retrofit.create(ProductService.class);
        Call<ProductCollection> getProducts = productService.getProducts();
        Call<ProductCollection> getFeaturedProducts = productService.getFeaturedProducts();

        setProductAdapter(getFeaturedProducts);


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

    private void setProductAdapter(Call<ProductCollection> call){
        call.enqueue(new Callback<ProductCollection>() {
            @Override
            public void onResponse(Call<ProductCollection> call, Response<ProductCollection> response) {
                ProductCollection productCollection = response.body();
                ArrayList<Element> elementList = (ArrayList<Element>) productCollection.getElements();

                Log.v("output: ", productCollection.getName());
                Log.v("output: ",  elementList.get(0).getDescription());
                Log.v("output: ",(String) elementList.get(0).getAttibuteValueByName("image"));

                productAdapter = new ProductAdapter(getApplicationContext(), elementList);
                productListView.setAdapter(productAdapter);
            }

            @Override
            public void onFailure(Call<ProductCollection> call, Throwable t) {
                t.printStackTrace();
                //TODO: wat als hij faalt ???
            }
        });
    }
}


