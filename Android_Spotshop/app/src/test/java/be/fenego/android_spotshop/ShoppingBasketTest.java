package be.fenego.android_spotshop;

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

@SuppressWarnings({"ALL", "ConstantConditions"})
public class ShoppingBasketTest implements ShoppingBasketCallback {

    private ShoppingBasketFragment shoppingBasketFragment = null;

    @Before
    public void setUp(){
        shoppingBasketFragment = new ShoppingBasketFragment();
    }

    @After
    public void cleanUp(){
        shoppingBasketFragment = null;
    }

    @Test
    public void getActiveTest(){
        ShoppingBasketUtilityMock.getActiveShoppingBasket(this);
    }

    @Test
   public void createBasketTest(){
        ShoppingBasketUtilityMock.createShoppingBasket(this);
    }

    @Test
    public void postToBasketTest(){
        ShoppingBasketUtilityMock.postProductToBasket(this);
    }

    @Test
   public void getActiveLineItemsTest(){
        ShoppingBasketUtilityMock.getActiveBasketLineItems(this);
    }

    @Test
   public void deleteLineItemTest(){
        ShoppingBasketUtilityMock.deleteShoppingBasketLineItems(this);
    }

    @Test
   public void updateLineItemTest(){
        ShoppingBasketUtilityMock.updateShoppingBasketLineItems(this);
    }

    @Override
    public void onSuccessGetActiveBasket(ShoppingBasket shoppingBasket) {
        if(shoppingBasket != null){
            boolean b = true;
            Assert.assertTrue(b);
        }
    }

    @Override
    public void onErrorGetActiveBasket(Call<ShoppingBasket> call, Throwable t) {

    }

    @Override
    public void onSuccessCreateBasket(ShoppingBasketPostReturn shoppingBasketPostReturn, String token) {
        if(shoppingBasketPostReturn != null){
            boolean b = true;
            Assert.assertTrue(b);
        }
    }

    @Override
    public void onErrorCreateBasket(Call<ShoppingBasketPostReturn> call, Throwable t) {

    }

    @Override
    public void onSuccessPostProductToBasket(ShoppingBasketElementList shoppingBasketElementList) {
        if(shoppingBasketElementList != null){
            boolean b = true;
            Assert.assertTrue(b);
        }
    }

    @Override
    public void onErrorPostProductToBasket(Call<ShoppingBasketElementList> call, Throwable t) {

    }

    @Override
    public void onSuccessGetActiveBasketLineItems(ElementList elementList) {
        if(elementList != null){
            boolean b = true;
            Assert.assertTrue(b);
        }
    }

    @Override
    public void onErrorGetActiveBasketLineItems(Call<ElementList> call, Throwable t) {

    }

    @Override
    public void onSuccessDeleteShoppingBasketLineItem(ShoppingBasket shoppingBasket) {
        if(shoppingBasket != null){
            boolean b = true;
            Assert.assertTrue(b);
        }
    }

    @Override
    public void onErrorDeleteShoppingBasketLineItem(Call<ShoppingBasket> call, Throwable t) {

    }

    @Override
    public void onSuccessUpdateShoppingBasketLineItem(ShoppingBasket shoppingBasket) {
        if(shoppingBasket != null){
            boolean b = true;
            Assert.assertTrue(b);
        }
    }

    @Override
    public void onErrorUpdateShoppingBasketLineItem(Call<ShoppingBasket> call, Throwable t) {

    }

    @Override
    public void onSuccessUpdateCommonShippingMethod(ShoppingBasket shoppingBasket) {

    }

    @Override
    public void onErrorUpdateCommonShippingMethod(Call<ShoppingBasket> call, Throwable t) {

    }

    @Override
    public void onSuccessPostBasketPaymentMethod(PaymentMethod paymentMethod) {

    }

    @Override
    public void onErrorPostBasketPaymentMethod(Call<PaymentMethod> call, Throwable t) {

    }

    @Override
    public void onSuccessPostOrder(OrderPostResponse orderPostResponse) {

    }

    @Override
    public void onErrorPostOrder(Call<OrderPostResponse> call, Throwable t) {

    }

    @Override
    public void onSuccessUpdateInvoiceAddress(ShoppingBasket shoppingBasket) {

    }

    @Override
    public void onErrorUpdateInvoiceAddress(Call<ShoppingBasket> call, Throwable t) {

    }

    @Override
    public void onSuccessUpdateShippingAddress(ShoppingBasket shoppingBasket) {

    }

    @Override
    public void onErrorUpdateShippingAddress(Call<ShoppingBasket> call, Throwable t) {

    }
}
