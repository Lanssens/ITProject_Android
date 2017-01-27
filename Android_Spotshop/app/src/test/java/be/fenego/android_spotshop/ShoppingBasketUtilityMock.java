package be.fenego.android_spotshop;

import java.util.ArrayList;

import be.fenego.android_spotshop.callbacks.ShoppingBasketCallback;
import be.fenego.android_spotshop.models.ShoppingBasket;
import be.fenego.android_spotshop.models.ShoppingBasketElement;
import be.fenego.android_spotshop.models.ShoppingBasketElementList;
import be.fenego.android_spotshop.models.ShoppingBasketPostReturn;
import be.fenego.android_spotshop.models.shoppingBasketModels.ElementList;

/**
 * Created by Nick on 25/01/2017.
 */

@SuppressWarnings("ALL")
class ShoppingBasketUtilityMock {


    public static void getActiveShoppingBasket(final ShoppingBasketCallback callback){
      callback.onSuccessGetActiveBasket(new ShoppingBasket());
    }

    public static void createShoppingBasket(final ShoppingBasketCallback callback){
        callback.onSuccessCreateBasket(new ShoppingBasketPostReturn(), "ok");
    }

    public static void postProductToBasket(final ShoppingBasketCallback callback){
        callback.onSuccessPostProductToBasket(new ShoppingBasketElementList(new ArrayList<ShoppingBasketElement>()));
    }

    public static void getActiveBasketLineItems(final ShoppingBasketCallback callback){
        callback.onSuccessGetActiveBasketLineItems(new ElementList());
    }

    public static void deleteShoppingBasketLineItems(final ShoppingBasketCallback callback){
        callback.onSuccessDeleteShoppingBasketLineItem(new ShoppingBasket());
    }

    public static void updateShoppingBasketLineItems(final ShoppingBasketCallback callback){
      callback.onSuccessUpdateShoppingBasketLineItem(new ShoppingBasket());
    }





}
