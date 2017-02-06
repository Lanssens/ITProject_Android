package be.fenego.android_spotshop.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.view.*;
import android.widget.*;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import be.fenego.android_spotshop.R;
import be.fenego.android_spotshop.models.Element;
import be.fenego.android_spotshop.models.SalePrice;
import butterknife.*;

/**
 * Created by Nick on 20/12/2016.
 * ProductAdapter voor de ProductList te vullen met producten met een speciale layout.
 */

class ProductAdapter extends ArrayAdapter<Element> {
    private final Context context;
    private final ArrayList<Element> elements;
    private static final String BASE_IMAGE_URL = "https://axesso.fenego.zone";
    private ViewHolder holder;
    private final Gson gson;

    public ProductAdapter(Context context, ArrayList<Element> elements) {
        super(context, -1, elements);
        this.context = context;
        this.elements = elements;
        //Voor SalePrice te converten.
        gson = new Gson();
    }

    //View aanamaken met sepciale layout voor inladen van productdata in views.
    @NonNull
    @SuppressWarnings("ConstantConditions")
    @Override
    public View getView(int position, View view, @NonNull ViewGroup parent) {
        try{
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            if (view != null) {
                holder = (ViewHolder) view.getTag();
            } else {
                view = inflater.inflate(R.layout.homelistview_list_item, parent, false);
                holder = new ViewHolder(view);
                view.setTag(holder);
            }

            setViews(position);

            return view;
        }catch (Exception e){
            Toast.makeText(context.getApplicationContext(),"Could not display list of products!",Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
        return view;
    }

    //Views vullen met data van een bepaald product.
    private void setViews(int position){
        try{
            setImageView(position);
            setAvailabilityView(position);
            setPriceView(position);

            holder.productTitle.setText(elements.get(position).getTitle());
            holder.productRating.setRating(Float.valueOf((String) elements.get(position).getAttributeValueByName("roundedAverageRating")));
        }catch (Resources.NotFoundException e){
            e.printStackTrace();
            Toast.makeText(context.getApplicationContext(),"Could not display availability / price of certain products!",Toast.LENGTH_SHORT).show();

        }catch (Exception e){
            Toast.makeText(context.getApplicationContext(),"Could not display certain products!",Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    //correcte imageURL samenstellen en productImageView vullen via Picasso.
    private void setImageView(int position){
        String imageUrl = BASE_IMAGE_URL + elements.get(position).getAttributeValueByName("image");
        Picasso.with(context)
                .load(imageUrl)
                .placeholder(R.drawable.ic_button_camera)
                .error(R.drawable.ic_button_camera)
                .into(holder.productImage);
    }

    //ProductAvailabilityView vullen
    @SuppressLint("SetTextI18n")
    private void setAvailabilityView(int position){
        try{
            if((Boolean) elements.get(position).getAttributeValueByName("availability")){
                holder.productAvailability.setText("In Stock");
            }else{
                holder.productAvailability.setText("out of stock");
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new Resources.NotFoundException();
        }
    }

    //ProductPriceView vullen
    @SuppressLint("SetTextI18n")
    private void setPriceView(int position){
        try {
            SalePrice salePrice = gson.fromJson(elements.get(position).getAttributeValueByName("salePrice").toString(), SalePrice.class);
            holder.productPrice.setText("$ " + Float.toString(salePrice.getValue()));
        }catch (Exception e){
            e.printStackTrace();
            throw new Resources.NotFoundException();
        }
    }

    //Bind views voor productdata in te stellen.
    static class ViewHolder {
        @SuppressWarnings("unused")
        @BindView(R.id.productImageImageView)
        ImageView productImage;

        @SuppressWarnings("unused")
        @BindView(R.id.productTitleTextView)
        TextView productTitle;

        @SuppressWarnings("unused")
        @BindView(R.id.productRatingBar)
        RatingBar productRating;

        @SuppressWarnings("unused")
        @BindView(R.id.productPriceTextView)
        TextView productPrice;

        @SuppressWarnings("unused")
        @BindView(R.id.productAvailabilityTextView)
        TextView productAvailability;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
