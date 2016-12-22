package be.fenego.android_spotshop.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import be.fenego.android_spotshop.model.Product;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.*;

/**
 * Created by Nick on 21/12/2016.
 */

public interface ProductService {

    public static final String BASE_URL = "https://axesso.fenego.zone/INTERSHOP/rest/WFS/inSPIRED-inTRONICS-Site/";

    @GET("-/products/{SKU}")
    Call<Product> getProduct(@Path("SKU") String SKU);

    @GET("-/products")
    Call<ArrayList<Product>> getProducts();

    @GET("-/categories/Specials/TopSellers/products")
    Call<ArrayList<Product>> getFeaturedProducts();


    Gson gson = new GsonBuilder().create();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();
}
