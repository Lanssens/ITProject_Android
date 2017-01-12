package be.fenego.android_spotshop.productDetails;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import be.fenego.android_spotshop.R;
import be.fenego.android_spotshop.models.Attribute;
import be.fenego.android_spotshop.models.Image;
import be.fenego.android_spotshop.models.ProductDetails;
import be.fenego.android_spotshop.models.ResourceAttribute;
import be.fenego.android_spotshop.models.SalePrice;
import be.fenego.android_spotshop.services.ProductService;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetailsActivity extends AppCompatActivity {

    private static final String BASE_IMAGE_URL = "https://axesso.fenego.zone";
    private String imageUrl;

    ProductService productService;
    private String productSKU = null;
    private ProductDetails productDetails = null;
    private ArrayList<Attribute> productDetailsAttributes = null;

    Gson gson;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        ButterKnife.bind(this);

        //Voor ResourceAttribute te converten.
        gson = new Gson();

        //Service instantie aanmaken voor calls uit te voeren.
        productService = ProductService.retrofit.create(ProductService.class);

        //Intent data ophalen met productSKU
        productSKU = getIntent().getStringExtra("ProductURI");

        //Call uitvoeren & views vullen.
        setProductDetails(productSKU);
    }

    //Call uitvoeren & response opslaan
    private void setProductDetails(String SKU){
        try{
            productService.getProduct(SKU).enqueue(new Callback<ProductDetails>() {
                @Override
                public void onResponse(Call<ProductDetails> call, Response<ProductDetails> response) {
                    productDetails = response.body();
                    productDetailsAttributes =(ArrayList<Attribute>) productDetails.getAttributes();
                    setViews();
                }

                @Override
                public void onFailure(Call<ProductDetails> call, Throwable t) {
                    Toast.makeText(getApplicationContext(),"Could not display product!\nGetting details failed!",Toast.LENGTH_SHORT).show();
                    t.printStackTrace();
                }
            });
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),"Could not display product!",Toast.LENGTH_SHORT).show();
            productDetailsButton.setEnabled(false);
        }
    }

    //Views vullen met product data
    private void setViews(){
        try{
            productDetailsTitle.setText(productDetails.getProductName());
            productDetailsDescription.setText(Html.fromHtml(productDetails.getLongDescription()));
            productDetailsRatingBar.setRating(Float.valueOf((String) productDetails.getRoundedAverageRating()));
            setPriceView();
            setAvailabilityView();
            setImageView();
            setSpecsTable();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Could not display product!",Toast.LENGTH_SHORT).show();
            productDetailsButton.setEnabled(false);
            e.printStackTrace();
        }
    }

    //ProductPriceView vullen
    private void setPriceView(){
        try{
            SalePrice salePrice = productDetails.getSalePrice();
            productDetailsPrice.setText(" $ " + Float.toString(salePrice.getValue()));
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Price could not load!",Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    //ProductAvailabilityView vullen
    private void setAvailabilityView(){
        try{
            if(productDetails.getAvailability()){
                productDetailsAvailability.setText("In Stock");
            }else{
                productDetailsAvailability.setText("out of stock");
            }
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Availability could not load!",Toast.LENGTH_SHORT).show();
            productDetailsButton.setEnabled(false);
            e.printStackTrace();
        }
    }

    //Correcte image ophalen.
    private void setImageView(){
        try{
            Image image = null;
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
            Toast.makeText(getApplicationContext(),"Image could not load!",Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    //ProductImageView vullen via Picasso.
    private void loadImage(Image image){
        imageUrl = BASE_IMAGE_URL + image.getEffectiveUrl();
        Picasso.with(this)
                .load(imageUrl)
                .placeholder(R.drawable.ic_button_camera)
                .error(R.drawable.ic_button_camera)
                .into(productDetailsImage);
    }

    //Correcte product specificaties zoeken en in textViews steken.
    private void setSpecsTable(){
        try{
            for (Attribute attribute : productDetailsAttributes){
                TextView productDetailsSpecsName = new TextView(this);
                TextView productDetailsSpecsValue = new TextView(this);
                switch (attribute.getType()){
                    case "String":
                        productDetailsSpecsName.setText(attribute.getName());
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
            TableRow productDetailsSpecsRow = new TableRow(this);
            productDetailsSpecsRow.addView(name,params);
            productDetailsSpecsRow.addView(value,params);
            productDetailsSpecsTable.addView(productDetailsSpecsRow);
        }catch (Exception e){ //geen specs weergeven!
            Toast.makeText(getApplicationContext(),"Specifications could not load!",Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}
