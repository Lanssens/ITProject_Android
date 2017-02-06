package be.fenego.android_spotshop.Callbacks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import be.fenego.android_spotshop.callbacks.ShoppingBasketCallback;
import be.fenego.android_spotshop.models.ShoppingBasket;
import be.fenego.android_spotshop.models.ShoppingBasketElementList;
import be.fenego.android_spotshop.models.ShoppingBasketPostReturn;
import be.fenego.android_spotshop.models.shoppingBasketModels.ElementList;
import be.fenego.android_spotshop.models.shoppingBasketModels.OrderPostResponse;
import be.fenego.android_spotshop.models.shoppingBasketModels.PaymentMethod;
import be.fenego.android_spotshop.shoppingBasket.ShoppingBasketFragment;
import retrofit2.Call;

/**
 * Created by Nick on 25/01/2017.
 */

@SuppressWarnings({"ALL", "ConstantConditions", "unused"})
public class ShoppingBasketTest implements ShoppingBasketCallback {

    @SuppressWarnings("unused")
    private ShoppingBasketFragment shoppingBasketFragment = null;

    @SuppressWarnings("unused")
    @Before
    public void setUp(){
        shoppingBasketFragment = new ShoppingBasketFragment();
    }

    @SuppressWarnings("unused")
    @After
    public void cleanUp(){
        shoppingBasketFragment = null;
    }

    @SuppressWarnings("unused")
    @Test
    public void getActiveTest(){
        ShoppingBasketUtilityMock.getActiveShoppingBasket(this);
    }

    @SuppressWarnings("unused")
    @Test
   public void createBasketTest(){
        ShoppingBasketUtilityMock.createShoppingBasket(this);
    }

    @SuppressWarnings("unused")
    @Test
    public void postToBasketTest(){
        ShoppingBasketUtilityMock.postProductToBasket(this);
    }

    @SuppressWarnings("unused")
    @Test
   public void getActiveLineItemsTest(){
        ShoppingBasketUtilityMock.getActiveBasketLineItems(this);
    }

    @SuppressWarnings("unused")
    @Test
   public void deleteLineItemTest(){
        ShoppingBasketUtilityMock.deleteShoppingBasketLineItems(this);
    }

    @SuppressWarnings("unused")
    @Test
   public void updateLineItemTest(){
        ShoppingBasketUtilityMock.updateShoppingBasketLineItems(this);
    }

    @SuppressWarnings("unused")
    @Override
    public void onSuccessGetActiveBasket(ShoppingBasket shoppingBasket) {
        Assert.assertNotNull(shoppingBasket);
    }

    @SuppressWarnings("unused")
    @Override
    public void onErrorGetActiveBasket(Call<ShoppingBasket> call, Throwable t) {

    }

    @SuppressWarnings("unused")
    @Override
    public void onSuccessCreateBasket(ShoppingBasketPostReturn shoppingBasketPostReturn, String token) {
        Assert.assertNotNull(shoppingBasketPostReturn);
    }

    @SuppressWarnings("unused")
    @Override
    public void onErrorCreateBasket(Call<ShoppingBasketPostReturn> call, Throwable t) {

    }

    @SuppressWarnings("unused")
    @Override
    public void onSuccessPostProductToBasket(ShoppingBasketElementList shoppingBasketElementList) {
        Assert.assertNotNull(shoppingBasketElementList);
    }

    @SuppressWarnings("unused")
    @Override
    public void onErrorPostProductToBasket(Call<ShoppingBasketElementList> call, Throwable t) {

    }

    @SuppressWarnings("unused")
    @Override
    public void onSuccessGetActiveBasketLineItems(ElementList elementList) {
        Assert.assertNotNull(elementList);
    }

    @SuppressWarnings("unused")
    @Override
    public void onErrorGetActiveBasketLineItems(Call<ElementList> call, Throwable t) {

    }

    @SuppressWarnings("unused")
    @Override
    public void onSuccessDeleteShoppingBasketLineItem(ShoppingBasket shoppingBasket) {
        Assert.assertNotNull(shoppingBasket);
    }

    @SuppressWarnings("unused")
    @Override
    public void onErrorDeleteShoppingBasketLineItem(Call<ShoppingBasket> call, Throwable t) {

    }

    @SuppressWarnings("unused")
    @Override
    public void onSuccessUpdateShoppingBasketLineItem(ShoppingBasket shoppingBasket) {
        Assert.assertNotNull(shoppingBasket);
    }

    @SuppressWarnings("unused")
    @Override
    public void onErrorUpdateShoppingBasketLineItem(Call<ShoppingBasket> call, Throwable t) {

    }

    @SuppressWarnings("unused")
    @Override
    public void onSuccessUpdateCommonShippingMethod(ShoppingBasket shoppingBasket) {

    }

    @SuppressWarnings("unused")
    @Override
    public void onErrorUpdateCommonShippingMethod(Call<ShoppingBasket> call, Throwable t) {

    }

    @SuppressWarnings("unused")
    @Override
    public void onSuccessPostBasketPaymentMethod(PaymentMethod paymentMethod) {

    }

    @SuppressWarnings("unused")
    @Override
    public void onErrorPostBasketPaymentMethod(Call<PaymentMethod> call, Throwable t) {

    }

    @SuppressWarnings("unused")
    @Override
    public void onSuccessPostOrder(OrderPostResponse orderPostResponse) {

    }

    @SuppressWarnings("unused")
    @Override
    public void onErrorPostOrder(Call<OrderPostResponse> call, Throwable t) {

    }

    @SuppressWarnings("unused")
    @Override
    public void onSuccessUpdateInvoiceAddress(ShoppingBasket shoppingBasket) {

    }

    @SuppressWarnings("unused")
    @Override
    public void onErrorUpdateInvoiceAddress(Call<ShoppingBasket> call, Throwable t) {

    }

    @SuppressWarnings("unused")
    @Override
    public void onSuccessUpdateShippingAddress(ShoppingBasket shoppingBasket) {

    }

    @SuppressWarnings("unused")
    @Override
    public void onErrorUpdateShippingAddress(Call<ShoppingBasket> call, Throwable t) {

    }
}
