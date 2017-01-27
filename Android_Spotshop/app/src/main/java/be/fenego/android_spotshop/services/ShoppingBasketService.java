package be.fenego.android_spotshop.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import be.fenego.android_spotshop.models.ShoppingBasket;
import be.fenego.android_spotshop.models.ShoppingBasketElementList;
import be.fenego.android_spotshop.models.ShoppingBasketPostReturn;
import be.fenego.android_spotshop.models.shoppingBasketModels.BasketOwner;
import be.fenego.android_spotshop.models.shoppingBasketModels.ElementList;
import be.fenego.android_spotshop.models.shoppingBasketModels.PutQuantity;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by Nick on 19/01/2017.
 * Interface gebruikt door Retrofit voor het uitvoeren van HTTP-Requests.
 */

public interface ShoppingBasketService
{
    String BASE_URL ="https://axesso.fenego.zone/INTERSHOP/rest/WFS/";

    @GET("inSPIRED-inTRONICS-Site/-/baskets/-")
    Call<ShoppingBasket> getActiveShoppingBasket(@Header("authentication-token") String token);

    @POST("inSPIRED-inTRONICS-Site/-/baskets")
    Call<ShoppingBasketPostReturn> createShoppingBasket();

    @PUT("inSPIRED-inTRONICS-Site/-/baskets/{basketID}")
    Call<ShoppingBasket> setOwnerOnAnonBasket(@Header("authentication-token") String token, @Path("basketID") String basketID, @Body BasketOwner basketOwner);

    @POST("inSPIRED-inTRONICS-Site/-/baskets/{basketID}/items")
    Call<ShoppingBasketElementList> postProductToBasket(@Header("authentication-token") String token, @Path("basketID") String basketID, @Body ShoppingBasketElementList shoppingBasketElementList);

    @GET("inSPIRED-inTRONICS-Site/-/baskets/{basketID}/items")
    Call<ElementList> getActiveShoppingBasketLineItems(@Header("authentication-token") String token, @Path("basketID") String basketID);

    @DELETE("inSPIRED-inTRONICS-Site/-/baskets/{basketID}/items/{itemID}")
    Call<ShoppingBasket> deleteShoppingBasketLineItem(@Header("authentication-token") String token, @Path("basketID") String basketID, @Path("itemID") String itemID);

    @PUT("inSPIRED-inTRONICS-Site/-/baskets/{basketID}/items/{itemID}")
    Call<ShoppingBasket> updateShoppingBasketLineItem(@Header("authentication-token") String token, @Path("basketID") String basketID, @Path("itemID") String itemID, @Body PutQuantity quantity);


    Gson gson = new GsonBuilder().create();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();
}
