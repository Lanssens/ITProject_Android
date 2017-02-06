package be.fenego.android_spotshop.callbacks;

import be.fenego.android_spotshop.models.ShoppingBasket;
import be.fenego.android_spotshop.models.ShoppingBasketElementList;
import be.fenego.android_spotshop.models.ShoppingBasketPostReturn;
import be.fenego.android_spotshop.models.shoppingBasketModels.ElementList;
import be.fenego.android_spotshop.models.shoppingBasketModels.OrderPostResponse;
import be.fenego.android_spotshop.models.shoppingBasketModels.PaymentMethod;
import retrofit2.Call;

/**
 * Created by Nick on 19/01/2017.
 */

@SuppressWarnings("ALL")
public interface ShoppingBasketCallback {

    @SuppressWarnings("unused")
    void onSuccessGetActiveBasket(ShoppingBasket shoppingBasket);
    @SuppressWarnings("unused")
    void onErrorGetActiveBasket(Call<ShoppingBasket> call, Throwable t);
    @SuppressWarnings("unused")
    void onSuccessCreateBasket(ShoppingBasketPostReturn shoppingBasketPostReturn, String token);
    @SuppressWarnings("unused")
    void onErrorCreateBasket(Call<ShoppingBasketPostReturn> call, Throwable t);
    @SuppressWarnings("unused")
    void onSuccessPostProductToBasket(ShoppingBasketElementList shoppingBasketElementList);
    @SuppressWarnings("unused")
    void onErrorPostProductToBasket(Call<ShoppingBasketElementList> call, Throwable t);
    @SuppressWarnings("unused")
    void onSuccessGetActiveBasketLineItems(ElementList elementList);
    @SuppressWarnings("unused")
    void onErrorGetActiveBasketLineItems(Call<ElementList> call, Throwable t);
    @SuppressWarnings("unused")
    void onSuccessDeleteShoppingBasketLineItem(ShoppingBasket shoppingBasket);
    @SuppressWarnings("unused")
    void onErrorDeleteShoppingBasketLineItem(Call<ShoppingBasket> call, Throwable t);
    @SuppressWarnings("unused")
    void onSuccessUpdateShoppingBasketLineItem(ShoppingBasket shoppingBasket);
    @SuppressWarnings("unused")
    void onErrorUpdateShoppingBasketLineItem(Call<ShoppingBasket> call, Throwable t);
    @SuppressWarnings("unused")
    void onSuccessUpdateCommonShippingMethod(ShoppingBasket shoppingBasket);
    @SuppressWarnings("unused")
    void onErrorUpdateCommonShippingMethod(Call<ShoppingBasket> call, Throwable t);
    @SuppressWarnings("unused")
    void onSuccessPostBasketPaymentMethod(PaymentMethod paymentMethod);
    @SuppressWarnings("unused")
    void onErrorPostBasketPaymentMethod(Call<PaymentMethod> call, Throwable t);
    @SuppressWarnings("unused")
    void onSuccessPostOrder(OrderPostResponse orderPostResponse);
    @SuppressWarnings("unused")
    void onErrorPostOrder(Call<OrderPostResponse> call, Throwable t);
    @SuppressWarnings("unused")
    void onSuccessUpdateInvoiceAddress(ShoppingBasket shoppingBasket);
    @SuppressWarnings("unused")
    void onErrorUpdateInvoiceAddress(Call<ShoppingBasket> call, Throwable t);
    @SuppressWarnings("unused")
    void onSuccessUpdateShippingAddress(ShoppingBasket shoppingBasket);
    @SuppressWarnings("unused")
    void onErrorUpdateShippingAddress(Call<ShoppingBasket> call, Throwable t);

}
