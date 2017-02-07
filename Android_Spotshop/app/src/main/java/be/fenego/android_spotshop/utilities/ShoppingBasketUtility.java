package be.fenego.android_spotshop.utilities;

import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import be.fenego.android_spotshop.callbacks.ChangeBasketOwnerCallback;
import be.fenego.android_spotshop.callbacks.ShoppingBasketCallback;
import be.fenego.android_spotshop.models.ShoppingBasket;
import be.fenego.android_spotshop.models.ShoppingBasketElementList;
import be.fenego.android_spotshop.models.ShoppingBasketPostReturn;
import be.fenego.android_spotshop.models.shoppingBasketModels.BasketOwner;
import be.fenego.android_spotshop.models.shoppingBasketModels.ElementList;
import be.fenego.android_spotshop.models.shoppingBasketModels.InvoiceAddressContainer;
import be.fenego.android_spotshop.models.shoppingBasketModels.OrderPost;
import be.fenego.android_spotshop.models.shoppingBasketModels.OrderPostResponse;
import be.fenego.android_spotshop.models.shoppingBasketModels.PaymentMethod;
import be.fenego.android_spotshop.models.shoppingBasketModels.PutQuantity;
import be.fenego.android_spotshop.models.shoppingBasketModels.ShippingAddressContainer;
import be.fenego.android_spotshop.models.shoppingBasketModels.ShippingMethodContainer;
import be.fenego.android_spotshop.services.ShoppingBasketService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Nick on 19/01/2017.
 * utility voor het ophalen van baskets en basket items uit de database.
 */

public class ShoppingBasketUtility {

    private static final ShoppingBasketService shoppingBasketService = ShoppingBasketService.retrofit.create(ShoppingBasketService.class);

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

    public static void createShoppingBasketWithHeader(final ShoppingBasketCallback callback){
        android.support.v4.app.Fragment f =(android.support.v4.app.Fragment) callback;
        try{
            shoppingBasketService.createShoppingBasketWithHeader(getToken()).enqueue(new Callback<ShoppingBasketPostReturn>() {
                @Override
                public void onResponse(Call<ShoppingBasketPostReturn> call, Response<ShoppingBasketPostReturn> response) {
                    Log.v("Empty basket :", "OK!");
                }

                @Override
                public void onFailure(Call<ShoppingBasketPostReturn> call, Throwable t) {
                    Log.v("Empty basket :", "FAIL!");
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

    public static void deleteShoppingBasketLineItems(final ShoppingBasketCallback callback,String basketID, String itemID){
        android.support.v4.app.Fragment f =(android.support.v4.app.Fragment) callback;
        try{
            shoppingBasketService.deleteShoppingBasketLineItem(getToken(), basketID, itemID).enqueue(new Callback<ShoppingBasket>() {
                @Override
                public void onResponse(Call<ShoppingBasket> call, Response<ShoppingBasket> response) {
                    callback.onSuccessDeleteShoppingBasketLineItem(response.body());
                }

                @Override
                public void onFailure(Call<ShoppingBasket> call, Throwable t) {
                    callback.onErrorDeleteShoppingBasketLineItem(call, t);
                }
            });
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(f.getContext(),"Could not delete item from shopping cart!",Toast.LENGTH_SHORT).show();
        }
    }

    public static void updateShoppingBasketLineItems(final ShoppingBasketCallback callback, String basketID, String itemID, PutQuantity quantity){
        android.support.v4.app.Fragment f =(android.support.v4.app.Fragment) callback;
        try{
            shoppingBasketService.updateShoppingBasketLineItem(getToken(), basketID, itemID, quantity).enqueue(new Callback<ShoppingBasket>() {
                @Override
                public void onResponse(Call<ShoppingBasket> call, Response<ShoppingBasket> response) {
                    callback.onSuccessUpdateShoppingBasketLineItem(response.body());
                }

                @Override
                public void onFailure(Call<ShoppingBasket> call, Throwable t) {
                    callback.onErrorUpdateShoppingBasketLineItem(call, t);
                }
            });
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(f.getContext(),"Could not update item from shopping cart!",Toast.LENGTH_SHORT).show();
        }
    }

    public static void setOwnerOnAnonBasket(final ChangeBasketOwnerCallback callback, String basketID){
        Log.v("Test", "---");
        Log.v("Auth", LoginUtility.retrieveAuthToken());
        Log.v("Anon", LoginUtility.retrieveAnonToken());
        Log.v("Basket", basketID);

        android.support.v4.app.Fragment f =(android.support.v4.app.Fragment) callback;
        BasketOwner basketOwner = new BasketOwner();
        basketOwner.setNewOwnerAuthenticationToken(LoginUtility.retrieveAuthToken());
        try{
            shoppingBasketService.setOwnerOnAnonBasket(LoginUtility.retrieveAnonToken(), basketID ,basketOwner).enqueue(new Callback<ShoppingBasket>() {
                @Override
                public void onResponse(Call<ShoppingBasket> call, Response<ShoppingBasket> response) {
                    Log.v("Log", response.code() + "");
                    Log.v("Log", call.request().url() + "");
                    Log.v("Log", response.message() + "");
                    callback.onSuccessChangeBasketOwner(response.body());
                }

                @Override
                public void onFailure(Call<ShoppingBasket> call, Throwable t) {
                    Log.v("Log", t + "");
                    callback.onErrorChangeBasketOwner();
                }
            });
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(f.getContext(),"Couldn't change the basket owner!",Toast.LENGTH_SHORT).show();
        }
    }

    public static void updateCommonShippingMethod(final ShoppingBasketCallback callback, String basketID, ShippingMethodContainer shippingMethodContainer){
        android.support.v4.app.Fragment f =(android.support.v4.app.Fragment) callback;
        try{
            shoppingBasketService.updateCommonShippingMethod(getToken(),basketID, shippingMethodContainer).enqueue(new Callback<ShoppingBasket>() {
                @Override
                public void onResponse(Call<ShoppingBasket> call, Response<ShoppingBasket> response) {
                    callback.onSuccessUpdateCommonShippingMethod(response.body());
                }

                @Override
                public void onFailure(Call<ShoppingBasket> call, Throwable t) {
                    callback.onErrorUpdateCommonShippingMethod(call, t);
                }
            });
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(f.getContext(),"Could not finalize order!",Toast.LENGTH_SHORT).show();
        }
    }

    public static void postBasketPaymentMethod(final ShoppingBasketCallback callback, String basketID, PaymentMethod paymentMethod){
        android.support.v4.app.Fragment f =(android.support.v4.app.Fragment) callback;
        try{
            shoppingBasketService.postBasketPaymentMethod(getToken(), basketID, paymentMethod).enqueue(new Callback<PaymentMethod>() {
                @Override
                public void onResponse(Call<PaymentMethod> call, Response<PaymentMethod> response) {
                    callback.onSuccessPostBasketPaymentMethod(response.body());
                }

                @Override
                public void onFailure(Call<PaymentMethod> call, Throwable t) {
                    callback.onErrorPostBasketPaymentMethod(call, t);
                }
            });
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(f.getContext(),"Could not finalize order!",Toast.LENGTH_SHORT).show();
        }
    }

    public static void postOrder(final ShoppingBasketCallback callback, OrderPost orderPost){
        android.support.v4.app.Fragment f =(android.support.v4.app.Fragment) callback;
        try{
            shoppingBasketService.postOrderFromBasket(getToken(),orderPost).enqueue(new Callback<OrderPostResponse>() {
                @Override
                public void onResponse(Call<OrderPostResponse> call, Response<OrderPostResponse> response) {
                    Log.v("To Order: " , response.code()+ "");
                    callback.onSuccessPostOrder(response.body());
                }

                @Override
                public void onFailure(Call<OrderPostResponse> call, Throwable t) {
                    callback.onErrorPostOrder(call, t);
                }
            });
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(f.getContext(),"Could not finalize order!",Toast.LENGTH_SHORT).show();
        }
    }

    public static void updateInvoiceAddress(final ShoppingBasketCallback callback, String basketID, InvoiceAddressContainer invoiceAddressContainer){
        android.support.v4.app.Fragment f =(android.support.v4.app.Fragment) callback;
        try{
            shoppingBasketService.updateInvoiceAddress(getToken(), basketID, invoiceAddressContainer).enqueue(new Callback<ShoppingBasket>() {
                @Override
                public void onResponse(Call<ShoppingBasket> call, Response<ShoppingBasket> response) {
                    if(!Integer.toString(response.code()).equals("200")){
                        callback.onErrorUpdateInvoiceAddress(call, new Throwable("Problem with invoice address!"));
                    }else{
                        callback.onSuccessUpdateInvoiceAddress(response.body());
                    }
                }

                @Override
                public void onFailure(Call<ShoppingBasket> call, Throwable t) {
                    callback.onErrorUpdateInvoiceAddress(call, t);
                }
            });
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(f.getContext(),"Could not finalize order!",Toast.LENGTH_SHORT).show();
        }
    }

    public static void updateShippingAddress(final ShoppingBasketCallback callback, String basketID, ShippingAddressContainer shippingAddressContainer){
        android.support.v4.app.Fragment f =(android.support.v4.app.Fragment) callback;
        try{
            shoppingBasketService.updateShippingAddress(getToken(), basketID, shippingAddressContainer).enqueue(new Callback<ShoppingBasket>() {
                @Override
                public void onResponse(Call<ShoppingBasket> call, Response<ShoppingBasket> response) {
                    if(!Integer.toString(response.code()).equals("200")){
                        callback.onErrorUpdateShippingAddress(call, new Throwable("Problem with shipping address!"));
                    }else{
                        callback.onSuccessUpdateShippingAddress(response.body());

                    }
                }

                @Override
                public void onFailure(Call<ShoppingBasket> call, Throwable t) {
                    callback.onErrorUpdateShippingAddress(call, t);
                }
            });
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(f.getContext(),"Could not finalize order!",Toast.LENGTH_SHORT).show();
        }
    }

    private static String getToken(){
        if(LoginUtility.isUserLoggedIn()){
            Log.v("authToken: ", LoginUtility.retrieveAuthToken());
            return LoginUtility.retrieveAuthToken();
        }else {
            Log.v("anonToken: ", LoginUtility.retrieveAnonToken());
            return LoginUtility.retrieveAnonToken();
        }
    }
}

