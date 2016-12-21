package be.fenego.android_spotshop.home;

import android.content.Context;
import android.view.*;
import android.widget.*;
import java.util.ArrayList;

import be.fenego.android_spotshop.R;
import be.fenego.android_spotshop.model.Product;
import butterknife.*;

/**
 * Created by Nick on 20/12/2016.
 */

public class ProductAdapter extends ArrayAdapter<Product> {
    private final Context context;
    private final ArrayList<Product> products;

    public ProductAdapter(Context context, ArrayList<Product> products) {
        super(context, -1, products);
        this.context = context;
        this.products = products;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ViewHolder holder;
        if (view != null) {
            holder = (ViewHolder) view.getTag();
        } else {
            view = inflater.inflate(R.layout.homelistview_list_item, parent, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }

        //holder.productImage =
        holder.productTitle.setText(products.get(position).getProductName());
        holder.productRating.setRating(Float.valueOf(products.get(position).getRoundedAverageRating()));
        holder.productPrice.setText(products.get(position).getPrice());

        if(products.get(position).getAvailability()){
            holder.productAvailability.setText("In Stock");
        }else{
            holder.productAvailability.setText("out of stock");
        }

        return view;
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