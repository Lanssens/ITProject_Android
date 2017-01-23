package be.fenego.android_spotshop.shoppingBasket;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import be.fenego.android_spotshop.R;
import be.fenego.android_spotshop.callbacks.ProductCallback;
import be.fenego.android_spotshop.callbacks.ShoppingBasketCallback;
import be.fenego.android_spotshop.models.LineItem;
import be.fenego.android_spotshop.models.ProductCollection;
import be.fenego.android_spotshop.models.ProductDetails;
import be.fenego.android_spotshop.models.ShippingBucket;
import be.fenego.android_spotshop.models.ShoppingBasket;
import be.fenego.android_spotshop.models.ShoppingBasketElementList;
import be.fenego.android_spotshop.models.ShoppingBasketPostReturn;
import be.fenego.android_spotshop.models.shoppingBasketModels.Element;
import be.fenego.android_spotshop.models.shoppingBasketModels.ElementList;
import be.fenego.android_spotshop.utilities.ProductUtility;
import be.fenego.android_spotshop.utilities.ShoppingBasketUtility;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;

/**
 * Created by Nick on 19/01/2017.
 */

public class ShoppingBasketFragment extends Fragment implements ShoppingBasketCallback, ProductCallback {

    ArrayList<Element> elementList = null;

    @BindView(R.id.shoppingBasketListView)
    ListView shoppingBasketListView;
    @BindView(R.id.shoppingCartTextView)
    TextView shoppingBasketTotal;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_activity_shopping_basket,container, false);
        ButterKnife.bind(this, view);

        ShoppingBasketUtility.getActiveShoppingBasket(this);

        return view;
    }

    @Override
    public void onSuccessGetActiveBasket(ShoppingBasket shoppingBasket) {
       try{
           if(shoppingBasket.getShippingBuckets() != null){
               shoppingBasketTotal.setText(shoppingBasket.getTotals().getBasketTotal().getValue().toString() + " USD");
               ShoppingBasketUtility.getActiveBasketLineItems(this, shoppingBasket.getId());
           }
       }catch (NullPointerException e){
           Toast.makeText(getContext(), "No items available yet!", Toast.LENGTH_LONG).show();
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
    public void onSuccessGetProduct(ProductDetails productDetails) {
        for(Element element : elementList){
            if(element.getProduct().getTitle().equals(productDetails.getSku())){
                element.setImageURL(productDetails.getImageURLByName("front M").getEffectiveUrl());
            }
        }
        ArrayAdapter shoppingBasketAdapter = new ShoppingBasketAdapter(getContext(),this.elementList);
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
