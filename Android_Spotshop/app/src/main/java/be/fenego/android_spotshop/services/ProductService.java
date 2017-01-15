package be.fenego.android_spotshop.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import be.fenego.android_spotshop.models.ProductCollection;
import be.fenego.android_spotshop.models.ProductDetails;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.*;

/**
 * Created by Nick on 21/12/2016.
 * Interface gebruikt door Retrofit voor het uitvoeren van HTTP-Requests.
 */

public interface ProductService {

    String BASE_URL = "https://axesso.fenego.zone/INTERSHOP/rest/WFS/";

    @GET
    Call<ProductDetails> getProduct(@Url String SKU);

// --Commented out by Inspection START (14/01/2017 16:24):
//    @GET("inSPIRED-inTRONICS-Site/-/products?attrs=roundedAverageRating,salePrice,availability")
//    Call<ProductCollection> getProducts();
// --Commented out by Inspection STOP (14/01/2017 16:24)

    @GET("inSPIRED-inTRONICS-Site/-/categories/Specials/TopSellers/products?attrs=image,roundedAverageRating,salePrice,availability")
    Call<ProductCollection> getFeaturedProducts();

    @GET
    Call<ProductCollection> getProductsByImage(@Url String annotations);

    @GET
    Call<ProductCollection> getProductsByText(@Url String annotations);

    Gson gson = new GsonBuilder().create();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();
}
