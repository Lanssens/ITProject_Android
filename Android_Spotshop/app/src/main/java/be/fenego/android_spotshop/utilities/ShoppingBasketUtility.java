package be.fenego.android_spotshop.utilities;

import android.util.Log;
import android.widget.Toast;

import java.util.List;

import be.fenego.android_spotshop.callbacks.ShoppingBasketCallback;
import be.fenego.android_spotshop.models.LineItem;
import be.fenego.android_spotshop.models.ShoppingBasket;
import be.fenego.android_spotshop.models.ShoppingBasketPostReturn;
import be.fenego.android_spotshop.services.ProductService;
import be.fenego.android_spotshop.services.ServiceGenerator;
import be.fenego.android_spotshop.services.ShoppingBasketService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Nick on 19/01/2017.
 */

public class ShoppingBasketUtility {

    private static ShoppingBasketService shoppingBasketService = ShoppingBasketService.retrofit.create(ShoppingBasketService.class);

    public static void getActiveShoppingBasket(final ShoppingBasketCallback callback){
        android.support.v4.app.Fragment f =(android.support.v4.app.Fragment) callback;
        try{
            shoppingBasketService.getActiveShoppingBasket("Basic " + LoginUtility.retrieveAuthToken()).enqueue(new Callback<ShoppingBasket>() {
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
                    callback.onSuccessCreateBasket(response.body());
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

    public static void postProductToBasket(final ShoppingBasketCallback callback,String basketID, LineItem lineItem){
        android.support.v4.app.Fragment f =(android.support.v4.app.Fragment) callback;
        try{
            shoppingBasketService.postProductToBasket("Basic " + LoginUtility.retrieveAuthToken(), basketID, lineItem).enqueue(new Callback<LineItem>() {
                @Override
                public void onResponse(Call<LineItem> call, Response<LineItem> response) {
                    callback.onSuccessPostProductToBasket(response.body());
                }

                @Override
                public void onFailure(Call<LineItem> call, Throwable t) {
                    callback.onErrorPostProductToBasket(call, t);
                }
            });
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(f.getContext(),"Could not post product to basket!",Toast.LENGTH_SHORT).show();
        }
    }
}
