package be.fenego.android_spotshop.home;

import android.content.Context;
import android.util.Log;
import android.view.*;
import android.widget.*;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Objects;

import be.fenego.android_spotshop.R;
import be.fenego.android_spotshop.model.Element;
import be.fenego.android_spotshop.model.SalesPrice;
import be.fenego.android_spotshop.service.ProductService;
import butterknife.*;

/**
 * Created by Nick on 20/12/2016.
 */

public class ProductAdapter extends ArrayAdapter<Element> {
    private final Context context;
    private final ArrayList<Element> elements;
    private static final String BASE_IMAGE_URL = "https://axesso.fenego.zone";
    private ViewHolder holder;
    private String imageUrl;
    Gson gson;

    public ProductAdapter(Context context, ArrayList<Element> elements) {
        super(context, -1, elements);
        this.context = context;
        this.elements = elements;
        gson = new Gson();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

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
    }

    private void setViews(int position){
        setImageView(position);
        setAvailabilityView(position);
        setPriceView(position);

        holder.productTitle.setText(elements.get(position).getTitle());
        holder.productRating.setRating(Float.valueOf((String) elements.get(position).getAttibuteValueByName("roundedAverageRating")));
    }

    private void setImageView(int position){
        imageUrl = BASE_IMAGE_URL + (String) elements.get(position).getAttibuteValueByName("image");
        Picasso.with(context)
                .load(imageUrl)
                .placeholder(R.drawable.ic_button_camera)
                .error(R.drawable.ic_button_camera)
                .into(holder.productImage);
    }

    private void setAvailabilityView(int position){
        if((Boolean) elements.get(position).getAttibuteValueByName("availability")){
            holder.productAvailability.setText("In Stock");
        }else{
            holder.productAvailability.setText("out of stock");
        }
    }

    private void setPriceView(int position){
        SalesPrice salesPrice = gson.fromJson(elements.get(position).getAttibuteValueByName("salePrice").toString(), SalesPrice.class);
        holder.productPrice.setText(Float.toString(salesPrice.getValue()) + " $");
    }

    static class ViewHolder {
        @BindView(R.id.productImageImageView)
        ImageView productImage;

        @BindView(R.id.productTitleTextView)
        TextView productTitle;

        @BindView(R.id.productRatingBar)
        RatingBar productRating;

        @BindView(R.id.productPriceTextView)
        TextView productPrice;

        @BindView(R.id.productAvailabilityTextView)
        TextView productAvailability;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
