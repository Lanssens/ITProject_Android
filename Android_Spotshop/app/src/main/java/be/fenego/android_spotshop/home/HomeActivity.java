package be.fenego.android_spotshop.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Console;
import java.util.ArrayList;

import be.fenego.android_spotshop.R;
import be.fenego.android_spotshop.model.Product;
import be.fenego.android_spotshop.service.ProductService;
import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomeActivity extends AppCompatActivity {

    ProductService productService;
    ProductAdapter productAdapter;

    @BindView(R.id.productListView)
    ListView productListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        productService = ProductService.retrofit.create(ProductService.class);

        showProducts();



    }

    private void showProducts(){

        productService.getProducts().enqueue(new Callback<ArrayList<Product>>() {
            @Override
            public void onResponse(Call<ArrayList<Product>> call, Response<ArrayList<Product>> response) {
                productAdapter = new ProductAdapter(getApplicationContext(), response.body());
                productListView.setAdapter(productAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Product>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Can't load products.\nError: " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
