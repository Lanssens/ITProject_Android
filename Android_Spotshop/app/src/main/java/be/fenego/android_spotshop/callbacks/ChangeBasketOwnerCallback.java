package be.fenego.android_spotshop.callbacks;

import be.fenego.android_spotshop.models.ShoppingBasket;

/**
 * Created by Thijs on 1/27/2017.
 */

@SuppressWarnings("DefaultFileTemplate")
public interface ChangeBasketOwnerCallback {
    @SuppressWarnings("UnusedParameters")
    void onSuccessChangeBasketOwner(ShoppingBasket basket);
    @SuppressWarnings("EmptyMethod")
    void onErrorChangeBasketOwner();
}
