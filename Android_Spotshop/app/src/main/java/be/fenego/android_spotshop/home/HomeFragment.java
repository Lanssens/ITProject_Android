package be.fenego.android_spotshop.home;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import be.fenego.android_spotshop.R;
import be.fenego.android_spotshop.models.Element;
import be.fenego.android_spotshop.models.ProductCollection;
import be.fenego.android_spotshop.productDetails.ProductDetailsActivity;
import be.fenego.android_spotshop.services.ProductService;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import be.fenego.android_spotshop.R;

/**
 * Created by Nick on 11/01/2017.
 */

public class HomeFragment extends Fragment {

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
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_activity_home,container, false);
        ButterKnife.bind(this, view);

        //Service instantie aanmaken voor calls uit te voeren.
        productService = ProductService.retrofit.create(ProductService.class);

        //Call die uitgevoerd kan worden via setProductAdapter methode.
        //Call<ProductCollection> getProducts = productService.getProducts();
        Call<ProductCollection> getFeaturedProducts = productService.getFeaturedProducts();

        setProductAdapter(getFeaturedProducts);

        return view;
    }

    //Geeft detailpagina weer voor bepaald product.
    @OnItemClick(R.id.productListView)
    void showProductDetails(AdapterView<?> adapterView, View view, int i, long l){
        try{
            if(productCollection != null && elementList != null){
                Intent productDetailIntent = new Intent(getContext(), ProductDetailsActivity.class);
                productDetailIntent.putExtra("ProductURI", elementList.get(i).getUri());
                startActivity(productDetailIntent);
            }
        }catch (Exception e){
            Toast.makeText(getContext(),"Could not display product details!",Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    //Call uitvoeren & response opslaan & adapter initialiseren en toevoegen aan listview.
    private void setProductAdapter(Call<ProductCollection> call){
        try{
            call.enqueue(new Callback<ProductCollection>() {
                @Override
                public void onResponse(Call<ProductCollection> call, Response<ProductCollection> response) {
                    productCollection = response.body();
                    elementList = (ArrayList<Element>) productCollection.getElements();
                    productAdapter = new ProductAdapter(getContext(), elementList);
                    productListView.setAdapter(productAdapter);
                }

                @Override
                public void onFailure(Call<ProductCollection> call, Throwable t) {
                    Toast.makeText(getContext(),"Could not display products!\nGetting product list failed!",Toast.LENGTH_SHORT).show();
                    t.printStackTrace();
                }
            });
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getContext(),"Could not display product list!",Toast.LENGTH_SHORT).show();
        }
    }
}
