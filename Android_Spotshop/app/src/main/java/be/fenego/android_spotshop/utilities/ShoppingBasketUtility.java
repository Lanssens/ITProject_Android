package be.fenego.android_spotshop.utilities;

import android.util.Log;
import android.widget.Toast;
import be.fenego.android_spotshop.callbacks.ShoppingBasketCallback;
import be.fenego.android_spotshop.models.ShoppingBasket;
import be.fenego.android_spotshop.models.ShoppingBasketElementList;
import be.fenego.android_spotshop.models.ShoppingBasketPostReturn;
import be.fenego.android_spotshop.models.shoppingBasketModels.ElementList;
import be.fenego.android_spotshop.services.ShoppingBasketService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.HTTP;

/**
 * Created by Nick on 19/01/2017.
 */

public class ShoppingBasketUtility {

    private static ShoppingBasketService shoppingBasketService = ShoppingBasketService.retrofit.create(ShoppingBasketService.class);

    public static void getActiveShoppingBasket(final ShoppingBasketCallback callback){
        android.support.v4.app.Fragment f =(android.support.v4.app.Fragment) callback;
        try{
            shoppingBasketService.getActiveShoppingBasket(getToken()).enqueue(new Callback<ShoppingBasket>() {
                @Override
                public void onResponse(Call<ShoppingBasket> call, Response<ShoppingBasket> response) {
                    callback.onSuccessGetActiveBasket(response.body());
                }

                @Override
                public void onFailure(Call<ShoppingBasket> call, Throwable t) {
                    callback.onErrorGetActiveBasket(call, t);
                }
            });
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(f.getContext(),"Could not get basket from database!",Toast.LENGTH_SHORT).show();
        }
    }

    public static void createShoppingBasket(final ShoppingBasketCallback callback){
        android.support.v4.app.Fragment f =(android.support.v4.app.Fragment) callback;
        try{
            shoppingBasketService.createShoppingBasket().enqueue(new Callback<ShoppingBasketPostReturn>() {
                @Override
                public void onResponse(Call<ShoppingBasketPostReturn> call, Response<ShoppingBasketPostReturn> response) {
                    callback.onSuccessCreateBasket(response.body(), response.headers().get("authentication-token"));
                }

                @Override
                public void onFailure(Call<ShoppingBasketPostReturn> call, Throwable t) {
                    callback.onErrorCreateBasket(call, t);
                }
            });
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(f.getContext(),"Could not create basket!",Toast.LENGTH_SHORT).show();
        }
    }

    public static void postProductToBasket(final ShoppingBasketCallback callback,String basketID, ShoppingBasketElementList shoppingBasketElementList){
        android.support.v4.app.Fragment f =(android.support.v4.app.Fragment) callback;
        try{
            shoppingBasketService.postProductToBasket(getToken(), basketID, shoppingBasketElementList).enqueue(new Callback<ShoppingBasketElementList>() {
                @Override
                public void onResponse(Call<ShoppingBasketElementList> call, Response<ShoppingBasketElementList> response) {
                    Log.v("post URL: " , call.request().url().toString());
                    Log.v("post HEADER: ", call.request().header("authentication-token"));
                    Log.v("code: ",Integer.toString(response.code()));
                    if(!Integer.toString(response.code()).equals("201")){
                        callback.onErrorPostProductToBasket(call, new Throwable("Bad response!"));
                    }else{
                        callback.onSuccessPostProductToBasket(response.body());
                    }
                }

                @Override
                public void onFailure(Call<ShoppingBasketElementList> call, Throwable t) {
                    callback.onErrorPostProductToBasket(call, t);
                }
            });
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(f.getContext(),"Could not post product to basket!",Toast.LENGTH_SHORT).show();
        }
    }

    public static void getActiveBasketLineItems(final ShoppingBasketCallback callback,String basketID){
        android.support.v4.app.Fragment f =(android.support.v4.app.Fragment) callback;
        try{
            shoppingBasketService.getActiveShoppingBasketLineItems(getToken(), basketID).enqueue(new Callback<ElementList>() {
                @Override
                public void onResponse(Call<ElementList> call, Response<ElementList> response) {
                    callback.onSuccessGetActiveBasketLineItems(response.body());
                }

                @Override
                public void onFailure(Call<ElementList> call, Throwable t) {
                    callback.onErrorGetActiveBasketLineItems(call, t);
                }
            });
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(f.getContext(),"Could not get basket from database!",Toast.LENGTH_SHORT).show();
        }
    }

    private static String getToken(){
        if(LoginUtility.isUserLoggedIn()){
            Log.v("Post: authToken: ", LoginUtility.retrieveAuthToken());
            return LoginUtility.retrieveAuthToken();
        }else {
            Log.v("Post: anonToken: ", LoginUtility.retrieveAnonToken());
            return LoginUtility.retrieveAnonToken();
        }
    }
}

