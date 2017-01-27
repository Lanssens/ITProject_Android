package be.fenego.android_spotshop.review;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import be.fenego.android_spotshop.R;
import be.fenego.android_spotshop.callbacks.AddressCallback;
import be.fenego.android_spotshop.callbacks.CustomerCallback;
import be.fenego.android_spotshop.callbacks.ShoppingBasketCallback;
import be.fenego.android_spotshop.callbacks.StringCallback;
import be.fenego.android_spotshop.home.HomeFragment;
import be.fenego.android_spotshop.login.LoginFragment;
import be.fenego.android_spotshop.models.Address;
import be.fenego.android_spotshop.models.Attribute;
import be.fenego.android_spotshop.models.Customer;
import be.fenego.android_spotshop.models.ProductDetails;
import be.fenego.android_spotshop.models.ShoppingBasket;
import be.fenego.android_spotshop.models.ShoppingBasketElementList;
import be.fenego.android_spotshop.models.ShoppingBasketPostReturn;
import be.fenego.android_spotshop.models.shoppingBasketModels.Element;
import be.fenego.android_spotshop.models.shoppingBasketModels.ElementList;
import be.fenego.android_spotshop.utilities.CustomerUtility;
import be.fenego.android_spotshop.utilities.LoginUtility;
import be.fenego.android_spotshop.utilities.ShoppingBasketUtility;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;

/**
 * Created by Thijs on 1/25/2017.
 */

/*{
        "name": "International Express Delivery",
        "type": "ShippingMethodRO",
        "id": "INT",
        "description": "International Express Delivery",
        "shippingTimeMin": 3,
        "shippingTimeMax": 5
        }*/

/*
{
        "name": "paymentOption",
        "type": "PaymentOption",
        "id": "ISH_CASH_ON_DELIVERY",
        "displayName": "Cash on Delivery",
        "paymentParameters": []
        }*/
public class ReviewFragment extends android.support.v4.app.Fragment implements ShoppingBasketCallback, StringCallback, AddressCallback {
    private ShoppingBasket shoppingBasket;
    private Address invoiceAddress;
    private Address shippingAddress;

    @BindView(R.id.reviewPageListView)
    ListView reviewPageListView;

    @BindView(R.id.reviewPageInvoiceAddressName)
    TextView reviewPageInvoiceAddressName;
    @BindView(R.id.reviewPageInvoiceAddressPostcode)
    TextView reviewPageInvoiceAddressPostcode;
    @BindView(R.id.reviewPageInvoiceAddressStreet)
    TextView reviewPageInvoiceAddressStreet;

    @BindView(R.id.reviewPageShippingAddressStreet)
    TextView reviewPageShippingAddressStreet;
    @BindView(R.id.reviewPageShippingAddressPostcode)
    TextView reviewPageShippingAddressPostcode;
    @BindView(R.id.reviewPageShippingAddressName)
    TextView reviewPageShippingAddressName;

    @BindView(R.id.reviewPageItemAmount)
    TextView reviewPageItemAmount;
    @BindView(R.id.reviewPageShippingMethod)
    TextView reviewPageShippingMethod;
    @BindView(R.id.reviewPagePaymentMethod)
    TextView reviewPagePaymentMethod;

    @BindView(R.id.reviewPageTotalPrice)
    TextView reviewPageTotalPrice;

    @OnClick(R.id.shoppingCartCheckoutImageView)
    public void linkToCheckout(View view) {
        Toast.makeText(getActivity(), "Ready to checkout", Toast.LENGTH_LONG).show();
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(LoginUtility.isUserLoggedIn()){
            // Haal Fragment-layout op
            View fragmentView = inflater.inflate(R.layout.fragment_activity_review_page, container, false);
            ButterKnife.bind(this, fragmentView);


            Bundle bundle = getArguments();
            if(bundle != null){

                this.shoppingBasket = (ShoppingBasket) bundle.get("shoppingBasket");

                reviewPageTotalPrice.setText(shoppingBasket.getTotals().getBasketTotal().getValue() + " USD");
                reviewPageShippingMethod.setText("Int. Express");
                reviewPagePaymentMethod.setText("Cash on Delivery");

            }
            CustomerUtility.getCustomerAddressUri(this);
            ShoppingBasketUtility.getActiveBasketLineItems(this, shoppingBasket.getId());


            return fragmentView;
        }else{
            loadFragment(LoginFragment.class);
        }
        return null;
    }

    public void loadFragment(Class fragmentClass) {

        // Create new fragment and transaction
        Fragment fragment = null;
        try {
            fragment = (Fragment) fragmentClass.newInstance();

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (fragment != null) {
            FragmentTransaction transaction = getFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
        }

    }

    @Override
    public void onSuccessGetActiveBasket(ShoppingBasket shoppingBasket) {

    }

    @Override
    public void onErrorGetActiveBasket(Call<ShoppingBasket> call, Throwable t) {

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
        if(elementList != null) {

            ArrayList<Element> elementArrayList = new ArrayList<>();
            elementArrayList.addAll(elementList.getElements());
            reviewPageItemAmount.setText(elementArrayList.size() + "");
            ArrayAdapter<Element> reviewPageAdapter = new ReviewPageAdapter(getContext(), elementArrayList);
            reviewPageListView.setAdapter(reviewPageAdapter);
        }else{
            System.out.println("elementList is leeg");
        }

    }

    @Override
    public void onErrorGetActiveBasketLineItems(Call<ElementList> call, Throwable t) {

    }

    @Override
    public void onSuccessDeleteShoppingBasketLineItem(ShoppingBasket shoppingBasket) {

    }

    @Override
    public void onErrorDeleteShoppingBasketLineItem(Call<ShoppingBasket> call, Throwable t) {

    }

    @Override
    public void onSuccessUpdateShoppingBasketLineItem(ShoppingBasket shoppingBasket) {

    }

    @Override
    public void onErrorUpdateShoppingBasketLineItem(Call<ShoppingBasket> call, Throwable t) {

    }

    @Override
    public void onSuccessString(String text) {
        CustomerUtility.getCustomerAddress(this, text);
    }

    @Override
    public void onErrorString() {

    }

    @Override
    public void onSuccessAddress(Address address) {
        this.invoiceAddress = address;
        this.shippingAddress = address;
        
        reviewPageInvoiceAddressName.setText(address.getFirstName() + address.getLastName());
        reviewPageInvoiceAddressStreet.setText(address.getStreet());
        reviewPageInvoiceAddressPostcode.setText(address.getPostalCode() + " " + address.getCity() + " " + address.getCountryCode());
        reviewPageShippingAddressName.setText(address.getFirstName() + address.getLastName());
        reviewPageShippingAddressStreet.setText(address.getStreet());
        reviewPageShippingAddressPostcode.setText(address.getPostalCode() + " " + address.getCity() + " " + address.getCountryCode());
    }

    @Override
    public void onAddressError() {

    }
}
