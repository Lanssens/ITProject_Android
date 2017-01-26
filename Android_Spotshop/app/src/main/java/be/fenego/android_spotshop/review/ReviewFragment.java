package be.fenego.android_spotshop.review;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import be.fenego.android_spotshop.R;
import be.fenego.android_spotshop.home.HomeFragment;
import be.fenego.android_spotshop.login.LoginFragment;
import be.fenego.android_spotshop.models.Attribute;
import be.fenego.android_spotshop.models.ProductDetails;
import be.fenego.android_spotshop.models.ShoppingBasket;
import be.fenego.android_spotshop.utilities.CustomerUtility;
import be.fenego.android_spotshop.utilities.LoginUtility;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Thijs on 1/25/2017.
 */

public class ReviewFragment extends android.support.v4.app.Fragment {
    private ShoppingBasket shoppingBasket;

    @BindView(R.id.reviewPageListView) ListView lv;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(LoginUtility.isUserLoggedIn()){
            // Haal Fragment-layout op
            View fragmentView = inflater.inflate(R.layout.fragment_activity_review_page, container, false);
            ButterKnife.bind(this, fragmentView);


            Bundle bundle = getArguments();
            if(bundle != null){

                this.shoppingBasket = (ShoppingBasket) bundle.get("shoppingBasket");
                Toast.makeText(getActivity(), shoppingBasket.getName(), Toast.LENGTH_SHORT).show();
            }


            // Instanciating an array list (you don't need to do this,
            // you already have yours).
            List<String> your_array_list = new ArrayList<String>();
            your_array_list.add("foo");
            your_array_list.add("bar");
            your_array_list.add("shiet");
            // This is the array adapter, it takes the context of the activity as a
            // first parameter, the type of list view as a second parameter and your
            // array as a third parameter.
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>( getActivity(),
                    android.R.layout.simple_list_item_1,
                    your_array_list );

            lv.setAdapter(arrayAdapter);


            return fragmentView;
        }else{
            loadFragment(LoginFragment.class);
        }
        return null;
    }

    public void loadFragment(Class fragmentClass) {

        // Create new fragment and transaction
        Fragment fragment = null;
        try {
            fragment = (Fragment) fragmentClass.newInstance();

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (fragment != null) {
            FragmentTransaction transaction = getFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack
            transaction.replace(R.id.flContent, fragment);
            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
        }

    }
}
