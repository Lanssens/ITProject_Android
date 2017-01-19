package be.fenego.android_spotshop.callbacks;

import be.fenego.android_spotshop.models.ShoppingBasket;
import be.fenego.android_spotshop.models.ShoppingBasketPostReturn;
import retrofit2.Call;

/**
 * Created by Nick on 19/01/2017.
 */

public interface ShoppingBasketCallback {

    void onSuccessGetBasket(ShoppingBasket shoppingBasket);
    void onErrorGetBasket(Call<ShoppingBasket> call, Throwable t);
    void onSuccessCreateBasket(ShoppingBasketPostReturn shoppingBasketPostReturn);
    void onErrorCreateBasket(Call<ShoppingBasketPostReturn> call, Throwable t);

}
