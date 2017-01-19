package be.fenego.android_spotshop.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import be.fenego.android_spotshop.models.ProductCollection;
import be.fenego.android_spotshop.models.ShoppingBasket;
import be.fenego.android_spotshop.models.ShoppingBasketPostReturn;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by Nick on 19/01/2017.
 */

public interface ShoppingBasketService
{
    String BASE_URL ="https://axesso.fenego.zone/INTERSHOP/rest/WFS/inSPIRED-inTRONICS-Site/-/";

    @GET("baskets/-")
    Call<ShoppingBasket> getShoppingBasket();

    @POST("baskets")
    Call<ShoppingBasketPostReturn> createShoppingBasket();

    Gson gson = new GsonBuilder().create();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();
}
