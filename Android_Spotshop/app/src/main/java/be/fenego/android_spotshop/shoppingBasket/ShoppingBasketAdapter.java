package be.fenego.android_spotshop.shoppingBasket;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import be.fenego.android_spotshop.R;
import be.fenego.android_spotshop.models.shoppingBasketModels.Element;
import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Nick on 19/01/2017.
 * adapter voor de shopping basket item lijst te vullen.
 */

@SuppressWarnings("ALL")
class ShoppingBasketAdapter extends ArrayAdapter<Element> {
    @SuppressWarnings("unused")
    private final Context context;
    @SuppressWarnings("unused")
    private final ArrayList<Element> elementList;
    @SuppressWarnings("unused")
    private static final String BASE_IMAGE_URL = "https://axesso.fenego.zone";
    @SuppressWarnings("unused")
    private ViewHolder holder;
    @SuppressWarnings("unused")
    private final ShoppingBasketFragment fragment;

    @SuppressWarnings("unused")
    public ShoppingBasketAdapter(Context context, ArrayList<Element> elements, ShoppingBasketFragment fragment) {
        super(context, -1, elements);
        this.context = context;
        this.elementList = elements;
        this.fragment = fragment;
    }

    //View aanamaken met sepciale layout voor inladen van basket item data in views.
    @NonNull
    @SuppressWarnings({"ConstantConditions", "unused"})
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

    //Views vullen met data van een bepaald basket item.
    @SuppressLint("SetTextI18n")
    private void setViews(int position){
        try{
            setImageView(position);
            setPriceView(position);

            holder.sbTitle.setText(elementList.get(position).getProduct().getDescription());
            holder.sbQuantity.setText(elementList.get(position).getQuantity().getValue().toString());
            holder.deleteImageView.setContentDescription(elementList.get(position).getId());
            holder.sbMinusButton.setContentDescription(elementList.get(position).getId());
            holder.sbPlusButton.setContentDescription(elementList.get(position).getId());

            holder.deleteImageView.setOnClickListener(new View.OnClickListener() {
                @SuppressWarnings("unused")
                @Override
                public void onClick(View v) {
                    fragment.deleteShoppingBasketItem(v);
                }
            });

            holder.sbMinusButton.setOnClickListener(new View.OnClickListener() {
                @SuppressWarnings("unused")
                @Override
                public void onClick(View v) {
                    fragment.updateShoppingBasketItem(v);
                }
            });

            holder.sbPlusButton.setOnClickListener(new View.OnClickListener() {
                @SuppressWarnings("unused")
                @Override
                public void onClick(View v) {
                    fragment.updateShoppingBasketItem(v);
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
    @SuppressWarnings("unused")
    private void setImageView(int position){
        String imageUrl = BASE_IMAGE_URL + elementList.get(position).getImageURL();
        Picasso.with(context)
                .load(imageUrl)
                .placeholder(R.drawable.ic_button_camera)
                .error(R.drawable.ic_button_camera)
                .into(holder.sbImage);
    }

    //sbPriceView vullen
    @SuppressWarnings("unused")
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
        @SuppressWarnings("unused")
        Context mcontext;

        @SuppressWarnings("unused")
        @BindView(R.id.shoppingBasketListItemImageView)
        ImageView sbImage;

        @SuppressWarnings("unused")
        @BindView(R.id.shoppingBasketListItemTitleTextView)
        TextView sbTitle;

        @SuppressWarnings("unused")
        @BindView(R.id.shoppingBasketListPriceTitleTextView)
        TextView sbPrice;

        @SuppressWarnings("unused")
        @BindView(R.id.shoppingBasketQuantityTextView)
        TextView sbQuantity;

        @SuppressWarnings("unused")
        @BindView(R.id.shoppingBasketListItemDeleteImageView)
        ImageView deleteImageView;

        @SuppressWarnings("unused")
        @BindView(R.id.shoppingBasketMinusButton)
        Button sbMinusButton;

        @SuppressWarnings("unused")
        @BindView(R.id.shoppingBasketPlusButton)
        Button sbPlusButton;

        @SuppressWarnings("unused")
        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
