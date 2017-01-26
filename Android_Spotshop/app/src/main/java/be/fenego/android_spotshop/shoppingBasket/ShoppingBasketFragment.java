package be.fenego.android_spotshop.shoppingBasket;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import be.fenego.android_spotshop.R;
import be.fenego.android_spotshop.callbacks.ProductCallback;
import be.fenego.android_spotshop.callbacks.ShoppingBasketCallback;
import be.fenego.android_spotshop.models.ProductCollection;
import be.fenego.android_spotshop.models.ProductDetails;
import be.fenego.android_spotshop.models.ShoppingBasket;
import be.fenego.android_spotshop.models.ShoppingBasketElementList;
import be.fenego.android_spotshop.models.ShoppingBasketPostReturn;
import be.fenego.android_spotshop.models.shoppingBasketModels.Element;
import be.fenego.android_spotshop.models.shoppingBasketModels.ElementList;
import be.fenego.android_spotshop.models.shoppingBasketModels.PutQuantity;
import be.fenego.android_spotshop.models.shoppingBasketModels.Quantity;
import be.fenego.android_spotshop.utilities.ProductUtility;
import be.fenego.android_spotshop.utilities.ShoppingBasketUtility;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;

/**
 * Created by Nick on 19/01/2017.
 */

@SuppressWarnings("DefaultFileTemplate")
public class ShoppingBasketFragment extends Fragment implements ShoppingBasketCallback, ProductCallback {

    private ArrayList<Element> elementList = null;

    private String delete = "";
    private String update = "";
    private Quantity updateQuantity = null;

    private boolean minus = false;
    private boolean plus = false;

    private ShoppingBasketAdapter shoppingBasketAdapter;

    @BindView(R.id.shoppingBasketListView)
    ListView shoppingBasketListView;
    @SuppressWarnings("WeakerAccess")
    @BindView(R.id.shoppingCartTextView)
    TextView shoppingBasketTotal;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_activity_shopping_basket,container, false);
        ButterKnife.bind(this, view);

        ShoppingBasketUtility.getActiveShoppingBasket(this);

        return view;
    }

    //Methode die shoppingBasketUtility zal oproepen voor een DELETE call uit te voeren
    public void deleteShoppingBasketItem(View view){
        Log.v("clicked delete: \n", "item: " + view.getContentDescription().toString());
        delete = view.getContentDescription().toString();
        ShoppingBasketUtility.getActiveShoppingBasket(this);
    }

    //Methode die shoppingBasketUtility zal oproepen voor een UPDATE call uit te voeren
    public void updateShoppingBasketItem(View view){
        if(view.getId() == R.id.shoppingBasketMinusButton){
            minus = true;
            update = view.getContentDescription().toString();
            ShoppingBasketUtility.getActiveShoppingBasket(this);
        }else if(view.getId() == R.id.shoppingBasketPlusButton){
            plus = true;
            update = view.getContentDescription().toString();
            ShoppingBasketUtility.getActiveShoppingBasket(this);
        }
    }

    //Na ophalen active basket bepalen wat er mee gebeurd moet worden.
    @SuppressLint("SetTextI18n")
    @Override
    public void onSuccessGetActiveBasket(ShoppingBasket shoppingBasket) {
       try{
           if(delete.equals("") && update.equals("")){
               if(shoppingBasket.getShippingBuckets() != null){
                   shoppingBasketTotal.setText(shoppingBasket.getTotals().getBasketTotal().getValue().toString() + " USD");
                   ShoppingBasketUtility.getActiveBasketLineItems(this, shoppingBasket.getId());
               }
           }else if(!delete.equals("") && update.equals("")){
               ShoppingBasketUtility.deleteShoppingBasketLineItems(this, shoppingBasket.getId(), delete);
           }else if(delete.equals("") && ! update.equals("")){
               for(Element element : elementList){
                   if(element.getId().equals(update)){
                       updateQuantity =  element.getQuantity();
                   }
               }
               if(plus){
                   updateQuantity.setValue(updateQuantity.getValue() + 1);
               }else if(minus){
                   updateQuantity.setValue(updateQuantity.getValue() - 1);
               }
               PutQuantity putQuantity = new PutQuantity(updateQuantity);
               ShoppingBasketUtility.updateShoppingBasketLineItems(this, shoppingBasket.getId(), update, putQuantity);
           }
       }catch (NullPointerException e){
           Toast.makeText(getContext(), "No items available yet!", Toast.LENGTH_LONG).show();
           if(shoppingBasketAdapter != null)
           shoppingBasketAdapter.clear();
           shoppingBasketTotal.setText("0.00 USD");
       }
    }

    @Override
    public void onErrorGetActiveBasket(Call<ShoppingBasket> call, Throwable t) {
        t.printStackTrace();
        Toast.makeText(getContext(),"Could not get basket from database!",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccessCreateBasket(ShoppingBasketPostReturn shoppingBasketPostReturn, String token) {

    }

    @Override
    public void onErrorCreateBasket(Call<ShoppingBasketPostReturn> call, Throwable t) {

    }

    @Override
    public void onSuccessPostProductToBasket(ShoppingBasketElementList shoppingBasketElementList) {

    }

    @Override
    public void onErrorPostProductToBasket(Call<ShoppingBasketElementList> call, Throwable t) {

    }

    @Override
    public void onSuccessGetActiveBasketLineItems(ElementList elementList) {
        this.elementList = (ArrayList<Element>) elementList.getElements();
        for(Element element : this.elementList){
            ProductUtility.getProductDetails(this, element.getProduct().getUri());
        }
    }

    @Override
    public void onErrorGetActiveBasketLineItems(Call<ElementList> call, Throwable t) {
        t.printStackTrace();
        Toast.makeText(getContext(),"Could not get basket from database!",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccessDeleteShoppingBasketLineItem(ShoppingBasket shoppingBasket) {
        delete = "";

        Toast.makeText(getContext(),"You just removed a product!",Toast.LENGTH_SHORT).show();
        ShoppingBasketUtility.getActiveShoppingBasket(this);
    }

    @Override
    public void onErrorDeleteShoppingBasketLineItem(Call<ShoppingBasket> call, Throwable t) {
        Toast.makeText(getContext(),"Could not delete product!",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onSuccessUpdateShoppingBasketLineItem(ShoppingBasket shoppingBasket) {
        update = "";
        updateQuantity = null;
        plus = false;
        minus = false;
        Toast.makeText(getContext(),"You just updated the quantity!",Toast.LENGTH_SHORT).show();
        ShoppingBasketUtility.getActiveShoppingBasket(this);
    }

    @Override
    public void onErrorUpdateShoppingBasketLineItem(Call<ShoppingBasket> call, Throwable t) {
        Toast.makeText(getContext(),"Could not update quantity!",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccessGetProduct(ProductDetails productDetails) {
        for(Element element : elementList){
            if(element.getProduct().getTitle().equals(productDetails.getSku())){
                element.setImageURL(productDetails.getImageURLByName("front M").getEffectiveUrl());
            }
        }
        shoppingBasketAdapter = new ShoppingBasketAdapter(getContext(),this.elementList, ShoppingBasketFragment.this);
        shoppingBasketListView.setAdapter(shoppingBasketAdapter);
    }

    @Override
    public void onErrorGetProduct(Call<ProductDetails> call, Throwable t) {
        t.printStackTrace();
        Toast.makeText(getContext(),"Could not get basket from database!",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccessGetFeaturedProducts(ProductCollection productCollection) {

    }

    @Override
    public void onErrorGetFeaturedProducts(Call<ProductCollection> call, Throwable t) {

    }

    @Override
    public void onSuccessGetProductsByImage(ProductCollection productCollection) {

    }

    @Override
    public void onErrorGetProductsByImage(Call<ProductCollection> call, Throwable t) {

    }

    @Override
    public void onSuccessGetProductsByText(ProductCollection productCollection) {

    }

    @Override
    public void onErrorGetProductsByText(Call<ProductCollection> call, Throwable t) {

    }
}
