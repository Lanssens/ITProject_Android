package be.fenego.android_spotshop.productDetails;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import be.fenego.android_spotshop.R;
import be.fenego.android_spotshop.model.ProductDetails;
import be.fenego.android_spotshop.model.SalePrice;
import be.fenego.android_spotshop.service.ProductService;
import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetailsActivity extends AppCompatActivity {

    ProductService productService;
    private String productSKU = null;
    private ProductDetails productDetails = null;

    @BindView(R.id.productDetailsTitleTextView)
    TextView productDetailsTitle;
    @BindView(R.id.productDetailsDescriptionTextView)
    TextView productDetailsDescription;
    @BindView(R.id.productDetailsPriceTextView)
    TextView productDetailsPrice;
    @BindView(R.id.productDetailsAvailabilityTextView)
    TextView productDetailsAvailability;



   // public static final String BASE_PRODUCT_DETAIL_URL = "https://axesso.fenego.zone/INTERSHOP/rest/WFS/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        ButterKnife.bind(this);

        productService = ProductService.retrofit.create(ProductService.class);

        productSKU = getIntent().getStringExtra("ProductURI");
        setProductDetails(productSKU);
    }


    private void setProductDetails(String SKU){
        productService.getProduct(SKU).enqueue(new Callback<ProductDetails>() {
            @Override
            public void onResponse(Call<ProductDetails> call, Response<ProductDetails> response) {
                productDetails = response.body();
                setViews();
            }

            @Override
            public void onFailure(Call<ProductDetails> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void setViews(){
        productDetailsTitle.setText(productDetails.getProductName());
        productDetailsDescription.setText(productDetails.getShortDescription());
        setPriceView();
        setAvailabilityView();
    }

    private void setPriceView(){
        SalePrice salePrice = productDetails.getSalePrice();
        productDetailsPrice.setText(" $ " + Float.toString(salePrice.getValue()));
    }

    private void setAvailabilityView(){
        if(productDetails.getAvailability()){
            productDetailsAvailability.setText("In Stock");
        }else{
            productDetailsAvailability.setText("out of stock");
        }
    }

}
