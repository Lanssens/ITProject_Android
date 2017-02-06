package be.fenego.android_spotshop.review;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import be.fenego.android_spotshop.R;
import be.fenego.android_spotshop.models.shoppingBasketModels.Element;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Thijs on 1/27/2017.
 */

@SuppressWarnings("DefaultFileTemplate")
class ReviewPageAdapter extends ArrayAdapter<Element> {
    private final Context context;
    private final ArrayList<Element> elementList;
    private ViewHolder holder;

    public ReviewPageAdapter(Context context, ArrayList<Element> elements) {
        super(context, -1, elements);
        this.context = context;
        this.elementList = elements;
    }

    //View aanamaken met sepciale layout voor inladen van basket item data in views.
    @NonNull
    @SuppressWarnings("ConstantConditions")
    @Override
    public View getView(int position, View view, @NonNull ViewGroup parent) {
        try{
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            if (view != null) {
                holder = (ReviewPageAdapter.ViewHolder) view.getTag();
            } else {
                view = inflater.inflate(R.layout.review_page_list_item, parent, false);
                holder = new ReviewPageAdapter.ViewHolder(view);
                view.setTag(holder);
            }

            setViews(position);


            return view;
        }catch (Exception e){
            Toast.makeText(context.getApplicationContext(),"Could not display list of LineItems!",Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
        return view;
    }

    //Views vullen met data van een bepaald basket item.
    @SuppressLint("SetTextI18n")
    private void setViews(int position){
            try{
                holder.tvAmount.setText(elementList.get(position).getQuantity().getValue() + " x");
                holder.tvName.setText(elementList.get(position).getProduct().getDescription());
                holder.tvPrice.setText(elementList.get(position).getPrice().getValue() + " USD");


            }catch (Exception e){
            Toast.makeText(context.getApplicationContext(),"Could not display certain products!",Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }


    //Bind views voor basketdata in te stellen.
    static class ViewHolder{

        @SuppressWarnings("unused")
        @BindView(R.id.reviewPageListItemAmount)
        TextView tvAmount;
        @SuppressWarnings("unused")
        @BindView(R.id.reviewPageListItemName)
        TextView tvName;
        @SuppressWarnings("unused")
        @BindView(R.id.reviewPageListItemPrice)
        TextView tvPrice;


        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}

