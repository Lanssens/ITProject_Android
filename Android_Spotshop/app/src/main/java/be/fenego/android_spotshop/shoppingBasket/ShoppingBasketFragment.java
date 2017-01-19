package be.fenego.android_spotshop.shoppingBasket;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import be.fenego.android_spotshop.R;
import be.fenego.android_spotshop.callbacks.ShoppingBasketCallback;
import be.fenego.android_spotshop.models.LineItem;
import be.fenego.android_spotshop.models.ShoppingBasket;
import be.fenego.android_spotshop.models.ShoppingBasketPostReturn;
import butterknife.ButterKnife;
import retrofit2.Call;

/**
 * Created by Nick on 19/01/2017.
 */

public class ShoppingBasketFragment extends Fragment implements ShoppingBasketCallback {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_activity_shopping_basket,container, false);
        ButterKnife.bind(this, view);

        return view;
    }


    @Override
    public void onSuccessGetActiveBasket(ShoppingBasket shoppingBasket) {

    }

    @Override
    public void onErrorGetActiveBasket(Call<ShoppingBasket> call, Throwable t) {

    }

    @Override
    public void onSuccessCreateBasket(ShoppingBasketPostReturn shoppingBasketPostReturn) {

    }

    @Override
    public void onErrorCreateBasket(Call<ShoppingBasketPostReturn> call, Throwable t) {

    }

    @Override
    public void onSuccessPostProductToBasket(LineItem lineItem) {

    }

    @Override
    public void onErrorPostProductToBasket(Call<LineItem> call, Throwable t) {

    }
}
