package be.fenego.android_spotshop.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

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

    ProductService productService;
    ArrayAdapter<Element> productAdapter;

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


