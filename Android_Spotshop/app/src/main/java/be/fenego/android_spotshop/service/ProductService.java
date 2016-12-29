package be.fenego.android_spotshop.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import be.fenego.android_spotshop.model.ProductCollection;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.*;

/**
 * Created by Nick on 21/12/2016.
 */

public interface ProductService {

    //https://axesso.fenego.zone/INTERSHOP/rest/WFS/inSPIRED-inTRONICS-Site/-/products?attrs=roundedAverageRating,salePrice,availability
    public static final String BASE_URL = "https://axesso.fenego.zone/INTERSHOP/rest/WFS/inSPIRED-inTRONICS-Site/";


    @GET("-/products/{SKU}")
    Call<ResponseBody> getProduct(@Path("SKU") String SKU);  ///check type !!!!!

    @GET("-/products?attrs=roundedAverageRating,salePrice,availability")
    Call<ProductCollection> getProducts();

    @GET("-/categories/Specials/TopSellers/products?attrs=image,roundedAverageRating,salePrice,availability")
    Call<ProductCollection> getFeaturedProducts();

    Gson gson = new GsonBuilder().create();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();
}
