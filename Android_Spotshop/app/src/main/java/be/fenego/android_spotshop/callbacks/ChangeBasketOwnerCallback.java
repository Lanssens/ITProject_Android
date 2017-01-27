package be.fenego.android_spotshop.callbacks;

import be.fenego.android_spotshop.models.ShoppingBasket;

/**
 * Created by Thijs on 1/27/2017.
 */

public interface ChangeBasketOwnerCallback {
    void onSuccessChangeBasketOwner(ShoppingBasket basket);
    void onErrorChangeBasketOwner();
}
