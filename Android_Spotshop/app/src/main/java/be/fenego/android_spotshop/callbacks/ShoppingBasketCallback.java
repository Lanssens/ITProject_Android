package be.fenego.android_spotshop.callbacks;

import be.fenego.android_spotshop.models.ShoppingBasket;
import be.fenego.android_spotshop.models.ShoppingBasketElementList;
import be.fenego.android_spotshop.models.ShoppingBasketPostReturn;
import be.fenego.android_spotshop.models.shoppingBasketModels.ElementList;
import retrofit2.Call;

/**
 * Created by Nick on 19/01/2017.
 */

@SuppressWarnings("ALL")
public interface ShoppingBasketCallback {

    void onSuccessGetActiveBasket(ShoppingBasket shoppingBasket);
    void onErrorGetActiveBasket(Call<ShoppingBasket> call, Throwable t);
    void onSuccessCreateBasket(ShoppingBasketPostReturn shoppingBasketPostReturn, String token);
    void onErrorCreateBasket(Call<ShoppingBasketPostReturn> call, Throwable t);
    void onSuccessPostProductToBasket(ShoppingBasketElementList shoppingBasketElementList);
    void onErrorPostProductToBasket(Call<ShoppingBasketElementList> call, Throwable t);
    void onSuccessGetActiveBasketLineItems(ElementList elementList);
    void onErrorGetActiveBasketLineItems(Call<ElementList> call, Throwable t);
    void onSuccessDeleteShoppingBasketLineItem(ShoppingBasket shoppingBasket);
    void onErrorDeleteShoppingBasketLineItem(Call<ShoppingBasket> call, Throwable t);
    void onSuccessUpdateShoppingBasketLineItem(ShoppingBasket shoppingBasket);
    void onErrorUpdateShoppingBasketLineItem(Call<ShoppingBasket> call, Throwable t);
}
