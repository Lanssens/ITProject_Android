package be.fenego.android_spotshop.productDetails;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.*;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.junit.Before;

import java.util.ArrayList;
import java.util.Arrays;

import be.fenego.android_spotshop.R;
import be.fenego.android_spotshop.callbacks.ShoppingBasketCallback;
import be.fenego.android_spotshop.models.Attribute;
import be.fenego.android_spotshop.models.Image;
import be.fenego.android_spotshop.models.ProductDetails;
import be.fenego.android_spotshop.models.Quantity;
import be.fenego.android_spotshop.models.ResourceAttribute;
import be.fenego.android_spotshop.models.SalePrice;
import be.fenego.android_spotshop.models.ShoppingBasket;
import be.fenego.android_spotshop.models.ShoppingBasketElement;
import be.fenego.android_spotshop.models.ShoppingBasketElementList;
import be.fenego.android_spotshop.models.ShoppingBasketPostReturn;
import be.fenego.android_spotshop.models.shoppingBasketModels.ElementList;
import be.fenego.android_spotshop.utilities.LoginUtility;
import be.fenego.android_spotshop.utilities.ShoppingBasketUtility;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;

/**
 * Created by Nick on 13/01/2017.
 */

@SuppressWarnings({"WeakerAccess", "DefaultFileTemplate"})
public class ProductDetailsFragment extends Fragment implements ShoppingBasketCallback{

    private ProductDetails productDetails = null;
    private ArrayList<Attribute> productDetailsAttributes = null;

    ShoppingBasketElement shoppingBasketElement;
    ShoppingBasketElementList shoppingBasketElementList;

    private static final String BASE_IMAGE_URL = "https://axesso.fenego.zone";

    @SuppressWarnings("unused")
    private Gson gson;

    @BindView(R.id.productDetailsTitleTextView)
    TextView productDetailsTitle;
    @BindView(R.id.productDetailsDescriptionTextView)
    TextView productDetailsDescription;
    @BindView(R.id.productDetailsPriceTextView)
    TextView productDetailsPrice;
    @BindView(R.id.productDetailsAvailabilityTextView)
    TextView productDetailsAvailability;
    @BindView(R.id.productDetailsImageView)
    ImageView productDetailsImage;
    @BindView(R.id.productDetailsRatingBar)
    RatingBar productDetailsRatingBar;
    @BindView(R.id.productDetailsSpecsTable)
    TableLayout productDetailsSpecsTable;
    @BindView(R.id.productDetailsAddToCartButton)
    ImageButton productDetailsButton;
    @BindView(R.id.productDetailsQuantityEditText)
    EditText productDetailsQuantityEditText;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_activity_product_details,container, false);

        ButterKnife.bind(this, view);

        //getting product details & attributes from home.
        Bundle bundle = getArguments();
        productDetails = (ProductDetails) bundle.get("productDetails");
        productDetailsAttributes =(ArrayList<Attribute>) (productDetails != null ? productDetails.getAttributes() : null);

        setViews();

        return view;
    }

    //zal add_To_cart click afhandelen
    @OnClick(R.id.productDetailsAddToCartButton)
    void addToCart(View view){
        shoppingBasketElement = new ShoppingBasketElement(productDetails.getSku(), new Quantity(Integer.parseInt(productDetailsQuantityEditText.getText().toString())));
        ArrayList<ShoppingBasketElement> shoppingBasketElementArrayList = new ArrayList<>();
        shoppingBasketElementArrayList.add(shoppingBasketElement);
        shoppingBasketElementList = new ShoppingBasketElementList(shoppingBasketElementArrayList);
        if(LoginUtility.isUserLoggedIn()){
            ShoppingBasketUtility.getActiveShoppingBasket(this);
        }else if(LoginUtility.retrieveAnonToken().equals("")){
            ShoppingBasketUtility.createShoppingBasket(this);
        }else{
            ShoppingBasketUtility.postProductToBasket(this, LoginUtility.retrieveAnonToken(), shoppingBasketElementList);
        }
    }

    //Views vullen met product data
    private void setViews(){
        try{
            productDetailsTitle.setText(productDetails.getProductName());
            //noinspection deprecation
            productDetailsDescription.setText(Html.fromHtml(productDetails.getLongDescription()));
            productDetailsRatingBar.setRating(Float.valueOf(productDetails.getRoundedAverageRating()));
            setPriceView();
            setAvailabilityView();
            setImageView();
            setSpecsTable();
        }catch (Exception e){
            Toast.makeText(getContext(),"Could not display product!",Toast.LENGTH_SHORT).show();
            productDetailsButton.setEnabled(false);
            e.printStackTrace();
        }
    }

    //ProductPriceView vullen
    @SuppressLint("SetTextI18n")
    private void setPriceView(){
        try{
            SalePrice salePrice = productDetails.getSalePrice();
            productDetailsPrice.setText(" $ " + Float.toString(salePrice.getValue()));
        }catch (Exception e){
            Toast.makeText(getContext(),"Price could not load!",Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    //ProductAvailabilityView vullen
    @SuppressLint("SetTextI18n")
    private void setAvailabilityView(){
        try{
            if(productDetails.getAvailability()){
                productDetailsAvailability.setText("In Stock");
            }else{
                productDetailsAvailability.setText("out of stock");
            }
        }catch (Exception e){
            Toast.makeText(getContext(),"Availability could not load!",Toast.LENGTH_SHORT).show();
            productDetailsButton.setEnabled(false);
            e.printStackTrace();
        }
    }

    //Correcte image ophalen.
    @SuppressWarnings("UnusedAssignment")
    private void setImageView(){
        try{
            Image image;
            image = productDetails.getImageURLByName("front M");

            if(image == null){
                image = productDetails.getImageURLByName("front S");
                if(image == null){
                    image = productDetails.getImageURLByName("front L");
                }else{
                    loadImage(image);
                }
            }else{
                loadImage(image);
            }
        }catch (Exception e){
            Toast.makeText(getContext(),"Image could not load!",Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    //ProductImageView vullen via Picasso.
    private void loadImage(Image image){
        String imageUrl = BASE_IMAGE_URL + image.getEffectiveUrl();
        Picasso.with(getContext())
                .load(imageUrl)
                .placeholder(R.drawable.ic_button_camera)
                .error(R.drawable.ic_button_camera)
                .into(productDetailsImage);
    }

    //Correcte product specificaties zoeken en in textViews steken.
    @SuppressWarnings("TryWithIdenticalCatches")
    @SuppressLint("SetTextI18n")
    private void setSpecsTable(){
        try{
            for (Attribute attribute : productDetailsAttributes){
                TextView productDetailsSpecsName = new TextView(getContext());
                TextView productDetailsSpecsValue = new TextView(getContext());
                switch (attribute.getType()){
                    case "String":
                        productDetailsSpecsName.setText(attribute.getName());
                        //noinspection deprecation
                        productDetailsSpecsValue.setText(Html.fromHtml((String) attribute.getValue()));
                        addRow(productDetailsSpecsName, productDetailsSpecsValue);
                        break;
                    case "Integer":
                        productDetailsSpecsName.setText(attribute.getName());
                        productDetailsSpecsValue.setText(Double.toString((Double) attribute.getValue()));
                        addRow(productDetailsSpecsName, productDetailsSpecsValue);
                        break;
                    case "ResourceAttribute":
                        ResourceAttribute resourceAttribute = gson.fromJson(attribute.getValue().toString(), ResourceAttribute.class);
                        productDetailsSpecsName.setText(attribute.getName());
                        productDetailsSpecsValue.setText(Double.toString(Math.round((resourceAttribute.getValue() *100)) /100) + " "  + resourceAttribute.getUnit());
                        addRow(productDetailsSpecsName, productDetailsSpecsValue);
                        break;
                    default:
                        //Geef lege specs weer.
                        throw new Resources.NotFoundException();
                }
            }
        }catch (NullPointerException e){  //geen specs weergeven!
            e.printStackTrace();
        }catch (Resources.NotFoundException e){  //geen specs weergeven!
            e.printStackTrace();
        }
    }

    //Textviews in row toevoegen en aan tabel toevoegen.
    private void addRow(TextView name, TextView value){
        try{
            TableRow.LayoutParams params = new TableRow.LayoutParams();
            params.setMargins(5, 2, 5, 2);
            TableRow productDetailsSpecsRow = new TableRow(getContext());
            productDetailsSpecsRow.addView(name,params);
            productDetailsSpecsRow.addView(value,params);
            productDetailsSpecsTable.addView(productDetailsSpecsRow);
        }catch (Exception e){ //geen specs weergeven!
            Toast.makeText(getContext(),"Specifications could not load!",Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    @Override
    public void onSuccessGetActiveBasket(ShoppingBasket shoppingBasket) {
        Log.v("Get basket:", "success get active basket!\n" + shoppingBasket.getId() + "With AUTH token: " + LoginUtility.retrieveAuthToken());
        Log.v("Post item aftrGETactv: ", shoppingBasketElement.getSku());
        ShoppingBasketUtility.postProductToBasket(this, shoppingBasket.getId(), shoppingBasketElementList);
    }

    @Override
    public void onErrorGetActiveBasket(Call<ShoppingBasket> call, Throwable t) {
        t.printStackTrace();
        Toast.makeText(getContext(),"Could not find your shopping cart!\nTry to login / logout!",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccessCreateBasket(ShoppingBasketPostReturn shoppingBasketPostReturn, String token) {
        if(LoginUtility.isUserLoggedIn()){
            LoginUtility.storeAuthToken(token);
            Log.v("Auth token stored: ", token);
        }else{
            LoginUtility.storeAnonToken(token);
            Log.v("Anon token stored: ", token);
        }

        Log.v("created basket worked: ", shoppingBasketPostReturn.getTitle());
        Log.v("Post item aftrCreate: ", shoppingBasketElement.getSku());
        ShoppingBasketUtility.postProductToBasket(this, shoppingBasketPostReturn.getTitle(), shoppingBasketElementList);
    }

    @Override
    public void onErrorCreateBasket(Call<ShoppingBasketPostReturn> call, Throwable t) {
        t.printStackTrace();
        Toast.makeText(getContext(),"Could not find your shopping cart!\nTry to login / logout!",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccessPostProductToBasket(ShoppingBasketElementList ShoppingBasketElementList) {
        Toast.makeText(getActivity(), "Product added to basket!" ,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onErrorPostProductToBasket(Call<ShoppingBasketElementList> call, Throwable t) {
        t.printStackTrace();
        Toast.makeText(getContext(),"Could not add product to your shopping cart!\nTry to login / logout!\n" + t.getMessage(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccessGetActiveBasketLineItems(ElementList elementList) {

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
}