package be.fenego.android_spotshop.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import be.fenego.android_spotshop.models.LineItem;
import be.fenego.android_spotshop.models.ProductCollection;
import be.fenego.android_spotshop.models.ShoppingBasket;
import be.fenego.android_spotshop.models.ShoppingBasketPostReturn;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Url;

/**
 * Created by Nick on 19/01/2017.
 */

public interface ShoppingBasketService
{
    String BASE_URL ="https://axesso.fenego.zone/INTERSHOP/rest/WFS/";

    @GET("inSPIRED-inTRONICS-Site/-/baskets/-")
    Call<ShoppingBasket> getActiveShoppingBasket(@Header("Authorization") String token);

    @POST("inSPIRED-inTRONICS-Site/-/baskets")
    Call<ShoppingBasketPostReturn> createShoppingBasket();

    @POST("inSPIRED-inTRONICS-Site/-//baskets/{basketID}/items")
    Call<LineItem> postProductToBasket(@Header("Authorization") String token, @Path("basketID") String basketID, @Body LineItem lineItem);

    Gson gson = new GsonBuilder().create();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();
}
