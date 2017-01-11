package be.fenego.android_spotshop.home;

import android.content.Context;
import android.content.res.Resources;
import android.view.*;
import android.widget.*;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import be.fenego.android_spotshop.R;
import be.fenego.android_spotshop.model.Element;
import be.fenego.android_spotshop.model.SalePrice;
import butterknife.*;

/**
 * Created by Nick on 20/12/2016.
 * ProductAdapter voor de ProductList te vullen met producten met een speciale layout.
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
        //Voor SalePrice te converten.
        gson = new Gson();
    }

    //View aanamaken met sepciale layout voor inladen van productdata in views.
    @Override
    public View getView(int position, View view, ViewGroup parent) {
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
            holder.productRating.setRating(Float.valueOf((String) elements.get(position).getAttibuteValueByName("roundedAverageRating")));
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
        imageUrl = BASE_IMAGE_URL + (String) elements.get(position).getAttibuteValueByName("image");
        Picasso.with(context)
                .load(imageUrl)
                .placeholder(R.drawable.ic_button_camera)
                .error(R.drawable.ic_button_camera)
                .into(holder.productImage);
    }

    //ProductAvailabilityView vullen
    private void setAvailabilityView(int position){
        try{
            if((Boolean) elements.get(position).getAttibuteValueByName("availability")){
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
    private void setPriceView(int position){
        try {
            SalePrice salePrice = gson.fromJson(elements.get(position).getAttibuteValueByName("salePrice").toString(), SalePrice.class);
            holder.productPrice.setText("$ " + Float.toString(salePrice.getValue()));
        }catch (Exception e){
            e.printStackTrace();
            throw new Resources.NotFoundException();
        }
    }

    //Bind views voor productdata in te stellen.
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
