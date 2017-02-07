package be.fenego.android_spotshop.review;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import be.fenego.android_spotshop.R;
import be.fenego.android_spotshop.callbacks.AddressCallback;
import be.fenego.android_spotshop.callbacks.ShoppingBasketCallback;
import be.fenego.android_spotshop.callbacks.StringCallback;
import be.fenego.android_spotshop.login.LoginFragment;
import be.fenego.android_spotshop.models.Address;
import be.fenego.android_spotshop.models.ShoppingBasket;
import be.fenego.android_spotshop.models.ShoppingBasketElementList;
import be.fenego.android_spotshop.models.ShoppingBasketPostReturn;
import be.fenego.android_spotshop.models.shoppingBasketModels.CommonShipToAddress;
import be.fenego.android_spotshop.models.shoppingBasketModels.CommonShippingMethod;
import be.fenego.android_spotshop.models.shoppingBasketModels.Element;
import be.fenego.android_spotshop.models.shoppingBasketModels.ElementList;
import be.fenego.android_spotshop.models.shoppingBasketModels.InvoiceAddress;
import be.fenego.android_spotshop.models.shoppingBasketModels.InvoiceAddressContainer;
import be.fenego.android_spotshop.models.shoppingBasketModels.OrderPost;
import be.fenego.android_spotshop.models.shoppingBasketModels.OrderPostResponse;
import be.fenego.android_spotshop.models.shoppingBasketModels.PaymentMethod;
import be.fenego.android_spotshop.models.shoppingBasketModels.ShippingAddressContainer;
import be.fenego.android_spotshop.models.shoppingBasketModels.ShippingMethodContainer;
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

@SuppressWarnings({"FieldCanBeLocal", "WeakerAccess", "DefaultFileTemplate", "unused"})
public class ReviewFragment extends android.support.v4.app.Fragment implements ShoppingBasketCallback, StringCallback, AddressCallback {
    @SuppressWarnings("unused")
    private ShoppingBasket shoppingBasket;
    @SuppressWarnings("unused")
    private Address invoiceAddress;

    @SuppressWarnings("unused")
    @BindView(R.id.reviewPageListView)
    ListView reviewPageListView;

    @SuppressWarnings("unused")
    @BindView(R.id.reviewPageInvoiceAddressName)
    TextView reviewPageInvoiceAddressName;
    @SuppressWarnings("unused")
    @BindView(R.id.reviewPageInvoiceAddressPostcode)
    TextView reviewPageInvoiceAddressPostcode;
    @SuppressWarnings("unused")
    @BindView(R.id.reviewPageInvoiceAddressStreet)
    TextView reviewPageInvoiceAddressStreet;

    @SuppressWarnings("unused")
    @BindView(R.id.reviewPageShippingAddressStreet)
    TextView reviewPageShippingAddressStreet;
    @SuppressWarnings("unused")
    @BindView(R.id.reviewPageShippingAddressPostcode)
    TextView reviewPageShippingAddressPostcode;
    @SuppressWarnings("unused")
    @BindView(R.id.reviewPageShippingAddressName)
    TextView reviewPageShippingAddressName;

    @SuppressWarnings("unused")
    @BindView(R.id.reviewPageItemAmount)
    TextView reviewPageItemAmount;
    @SuppressWarnings("unused")
    @BindView(R.id.reviewPageShippingMethod)
    TextView reviewPageShippingMethod;
    @SuppressWarnings("unused")
    @BindView(R.id.reviewPagePaymentMethod)
    TextView reviewPagePaymentMethod;

    @SuppressWarnings("unused")
    @BindView(R.id.reviewPageTotalPrice)
    TextView reviewPageTotalPrice;

    private ProgressDialog progress;

    //zorgt ervoor dat shopping basket om wordt gezet naar order door shippingmethod, payment method, invoice adres en shipping adres in te stellen.
    @SuppressWarnings("unused")
    @OnClick(R.id.shoppingCartCheckoutImageView)
    public void linkToCheckout() {
        ShoppingBasketUtility.updateCommonShippingMethod(this, shoppingBasket.getId(), new ShippingMethodContainer(new CommonShippingMethod("ShippingMethodRO", "International Express Delivery", "INT",3,5)));
    }
    @SuppressWarnings("unused")
    @SuppressLint("SetTextI18n")
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(LoginUtility.isUserLoggedIn()){
            // Haal Fragment-layout op
            View fragmentView = inflater.inflate(R.layout.fragment_activity_review_page, container, false);
            ButterKnife.bind(this, fragmentView);


            Bundle bundle = getArguments();
            if(bundle != null){

                this.shoppingBasket = (ShoppingBasket) bundle.get("shoppingBasket");

                if(this.shoppingBasket != null){
                    reviewPageTotalPrice.setText(shoppingBasket.getTotals().getBasketTotal().getValue() + " USD");
                    reviewPageShippingMethod.setText("Int. Express");
                    reviewPagePaymentMethod.setText("Cash on Delivery");
                }
            }

            progress = new ProgressDialog(getActivity());
            progress.setTitle("Loading");
            progress.setMessage("Loading data...");
            progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
            progress.show();

            CustomerUtility.getCustomerAddressUri(this);
            ShoppingBasketUtility.getActiveBasketLineItems(this, shoppingBasket.getId());


            return fragmentView;
        }else{
            loadFragment(LoginFragment.class);
        }
        return null;
    }

    //zal nieuw fragment inladen.
    @SuppressWarnings("unused")
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

    @SuppressWarnings("unused")
    @Override
    public void onSuccessGetActiveBasket(ShoppingBasket shoppingBasket) {

    }

    @SuppressWarnings("unused")
    @Override
    public void onErrorGetActiveBasket(Call<ShoppingBasket> call, Throwable t) {

    }

    @SuppressWarnings("unused")
    @Override
    public void onSuccessCreateBasket(ShoppingBasketPostReturn shoppingBasketPostReturn, String token) {
    }

    @SuppressWarnings("unused")
    @Override
    public void onErrorCreateBasket(Call<ShoppingBasketPostReturn> call, Throwable t) {

    }

    @SuppressWarnings("unused")
    @Override
    public void onSuccessPostProductToBasket(ShoppingBasketElementList shoppingBasketElementList) {

    }

    @SuppressWarnings("unused")
    @Override
    public void onErrorPostProductToBasket(Call<ShoppingBasketElementList> call, Throwable t) {

    }

    @SuppressWarnings("unused")
    @SuppressLint("SetTextI18n")
    @Override
    public void onSuccessGetActiveBasketLineItems(ElementList elementList) {
        if(elementList != null) {

            ArrayList<Element> elementArrayList = new ArrayList<>();
            elementArrayList.addAll(elementList.getElements());

            int itemCount = 0;
            for(Element element : elementArrayList){
                itemCount += element.getQuantity().getValue();
            }

            reviewPageItemAmount.setText(itemCount + "");
            ArrayAdapter<Element> reviewPageAdapter = new ReviewPageAdapter(getContext(), elementArrayList);
            reviewPageListView.setAdapter(reviewPageAdapter);

        }else{
            System.out.println("elementList is leeg");
        }


    }

    @SuppressWarnings("unused")
    @Override
    public void onErrorGetActiveBasketLineItems(Call<ElementList> call, Throwable t) {

    }

    @SuppressWarnings("unused")
    @Override
    public void onSuccessDeleteShoppingBasketLineItem(ShoppingBasket shoppingBasket) {

    }

    @SuppressWarnings("unused")
    @Override
    public void onErrorDeleteShoppingBasketLineItem(Call<ShoppingBasket> call, Throwable t) {

    }

    @SuppressWarnings("unused")
    @Override
    public void onSuccessUpdateShoppingBasketLineItem(ShoppingBasket shoppingBasket) {

    }

    @SuppressWarnings("unused")
    @Override
    public void onErrorUpdateShoppingBasketLineItem(Call<ShoppingBasket> call, Throwable t) {

    }

    @SuppressWarnings("unused")
    @Override
    public void onSuccessUpdateCommonShippingMethod(ShoppingBasket shoppingBasket) {
        ShoppingBasketUtility.postBasketPaymentMethod(this, shoppingBasket.getId(), new PaymentMethod("ISH_CASH_ON_DELIVERY","Payment"));
    }

    @SuppressWarnings("unused")
    @Override
    public void onErrorUpdateCommonShippingMethod(Call<ShoppingBasket> call, Throwable t) {
        Toast.makeText(getContext(),"Could not finalize order!\n" + t.getMessage(),Toast.LENGTH_SHORT).show();
    }

    @SuppressWarnings("unused")
    @Override
    public void onSuccessPostBasketPaymentMethod(PaymentMethod paymentMethod) {
        ShoppingBasketUtility.updateInvoiceAddress(this,shoppingBasket.getId(), new InvoiceAddressContainer(new InvoiceAddress(invoiceAddress.getAddressName(),invoiceAddress.getEmail(), invoiceAddress.getFirstName(), invoiceAddress.getLastName(),invoiceAddress.getCountryCode(),invoiceAddress.getPostalCode(), invoiceAddress.getCity(), invoiceAddress.getStreet())));
    }

    @SuppressWarnings("unused")
    @Override
    public void onErrorPostBasketPaymentMethod(Call<PaymentMethod> call, Throwable t) {
        Toast.makeText(getContext(),"Could not finalize order!\n" + t.getMessage(),Toast.LENGTH_SHORT).show();
    }

    @SuppressWarnings("unused")
    @Override
    public void onSuccessPostOrder(OrderPostResponse orderPostResponse) {
        ShoppingBasketUtility.createShoppingBasketWithHeader(this);
        loadFragment(FinishedFragment.class);
    }

    @SuppressWarnings("unused")
    @Override
    public void onErrorPostOrder(Call<OrderPostResponse> call, Throwable t) {
        Toast.makeText(getContext(),"Could not finalize order!\n" + t.getMessage(),Toast.LENGTH_SHORT).show();
    }

    @SuppressWarnings("unused")
    @Override
    public void onSuccessUpdateInvoiceAddress(ShoppingBasket shoppingBasket) {
        ShoppingBasketUtility.updateShippingAddress(this, shoppingBasket.getId(), new ShippingAddressContainer(new CommonShipToAddress(invoiceAddress.getAddressName(), invoiceAddress.getFirstName(), invoiceAddress.getLastName(),invoiceAddress.getCountryCode(),invoiceAddress.getPostalCode(), invoiceAddress.getCity(), invoiceAddress.getStreet())));
    }

    @SuppressWarnings("unused")
    @Override
    public void onErrorUpdateInvoiceAddress(Call<ShoppingBasket> call, Throwable t) {
        Toast.makeText(getContext(),"Could not finalize order!\n" + t.getMessage(),Toast.LENGTH_SHORT).show();
    }

    @SuppressWarnings("unused")
    @Override
    public void onSuccessUpdateShippingAddress(ShoppingBasket shoppingBasket) {
        ShoppingBasketUtility.postOrder(this, new OrderPost(shoppingBasket.getId(), "true"));
    }

    @SuppressWarnings("unused")
    @Override
    public void onErrorUpdateShippingAddress(Call<ShoppingBasket> call, Throwable t) {
        Toast.makeText(getContext(),"Could not finalize order!\n" + t.getMessage(),Toast.LENGTH_SHORT).show();
    }

    @SuppressWarnings("unused")
    @Override
    public void onSuccessString(String text) {
        CustomerUtility.getCustomerAddress(this, text);
    }

    @SuppressWarnings("unused")
    @Override
    public void onErrorString() {

    }

    @SuppressWarnings("unused")
    @SuppressLint("SetTextI18n")
    @Override
    public void onSuccessAddress(Address address) {
        this.invoiceAddress = address;

        reviewPageInvoiceAddressName.setText(address.getFirstName() + address.getLastName());
        reviewPageInvoiceAddressStreet.setText(address.getStreet());
        reviewPageInvoiceAddressPostcode.setText(address.getPostalCode() + " " + address.getCity() + " " + address.getCountryCode());
        reviewPageShippingAddressName.setText(address.getFirstName() + address.getLastName());
        reviewPageShippingAddressStreet.setText(address.getStreet());
        reviewPageShippingAddressPostcode.setText(address.getPostalCode() + " " + address.getCity() + " " + address.getCountryCode());

        progress.dismiss();
    }

    @SuppressWarnings("unused")
    @Override
    public void onAddressError() {
        progress.dismiss();
    }
}
