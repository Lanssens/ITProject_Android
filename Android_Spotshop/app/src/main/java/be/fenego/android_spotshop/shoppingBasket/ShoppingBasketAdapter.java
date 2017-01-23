package be.fenego.android_spotshop.shoppingBasket;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.api.services.vision.v1.model.Position;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import be.fenego.android_spotshop.R;
import be.fenego.android_spotshop.callbacks.ShoppingBasketCallback;
import be.fenego.android_spotshop.menu.MenuActivity;
import be.fenego.android_spotshop.models.LineItem;
import be.fenego.android_spotshop.models.SalePrice;
import be.fenego.android_spotshop.models.ShoppingBasket;
import be.fenego.android_spotshop.models.ShoppingBasketElementList;
import be.fenego.android_spotshop.models.ShoppingBasketPostReturn;
import be.fenego.android_spotshop.models.shoppingBasketModels.Element;
import be.fenego.android_spotshop.models.shoppingBasketModels.ElementList;
import be.fenego.android_spotshop.utilities.ShoppingBasketUtility;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTouch;
import retrofit2.Call;

/**
 * Created by Nick on 19/01/2017.
 */

public class ShoppingBasketAdapter extends ArrayAdapter<Element> {
    private final Context context;
    private final ArrayList<Element> elementList;
    private static final String BASE_IMAGE_URL = "https://axesso.fenego.zone";
    private ViewHolder holder;
    private ShoppingBasketFragment fragment;

    public ShoppingBasketAdapter(Context context, ArrayList<Element> elements, ShoppingBasketFragment fragment) {
        super(context, -1, elements);
        this.context = context;
        this.elementList = elements;
        this.fragment = fragment;
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
                view = inflater.inflate(R.layout.shopping_basket_list_item, parent, false);
                holder = new ViewHolder(view);
                view.setTag(holder);
            }

            setViews(position);


            return view;
        }catch (Exception e){
            Toast.makeText(context.getApplicationContext(),"Could not display list of basketItems!",Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
        return view;
    }

    //Views vullen met data van een bepaald product.
    private void setViews(int position){
        try{
            setImageView(position);
            setPriceView(position);

            holder.sbTitle.setText(elementList.get(position).getProduct().getDescription());
            holder.sbQuantity.setText(elementList.get(position).getQuantity().getValue().toString());
            holder.deleteImageView.setContentDescription(elementList.get(position).getId());

            holder.deleteImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fragment.deleteShoppingBasketItemClicked(v);
                }
            });

        }catch (Resources.NotFoundException e){
            e.printStackTrace();
            Toast.makeText(context.getApplicationContext(),"Could not display availability / price of certain products!",Toast.LENGTH_SHORT).show();

        }catch (Exception e){
            Toast.makeText(context.getApplicationContext(),"Could not display certain products!",Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    //correcte imageURL samenstellen en shoppingbasketImageView vullen via Picasso.
    private void setImageView(int position){
        String imageUrl = BASE_IMAGE_URL + elementList.get(position).getImageURL();
        Picasso.with(context)
                .load(imageUrl)
                .placeholder(R.drawable.ic_button_camera)
                .error(R.drawable.ic_button_camera)
                .into(holder.sbImage);
    }

    //sbPriceView vullen
    @SuppressLint("SetTextI18n")
    private void setPriceView(int position){
        try {
            //SalePrice salePrice = gson.fromJson(lineItemArrayList.get(position).getAttributeValueByName("salePrice").toString(), SalePrice.class);
            holder.sbPrice.setText(elementList.get(position).getPrice().getValue().toString() + " USD");
        }catch (Exception e){
            e.printStackTrace();
            throw new Resources.NotFoundException();
        }
    }

    //Bind views voor basketdata in te stellen.
    static class ViewHolder{
        Context mcontext;

        @BindView(R.id.shoppingBasketListItemImageView)
        ImageView sbImage;

        @BindView(R.id.shoppingBasketListItemTitleTextView)
        TextView sbTitle;

        @BindView(R.id.shoppingBasketListPriceTitleTextView)
        TextView sbPrice;

        @BindView(R.id.shoppingBasketQuantityTextView)
        TextView sbQuantity;

        @BindView(R.id.shoppingBasketListItemDeleteImageView)
        ImageView deleteImageView;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
