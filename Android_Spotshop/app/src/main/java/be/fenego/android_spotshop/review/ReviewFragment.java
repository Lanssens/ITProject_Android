package be.fenego.android_spotshop.review;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import be.fenego.android_spotshop.R;
import be.fenego.android_spotshop.home.HomeFragment;
import be.fenego.android_spotshop.login.LoginFragment;
import be.fenego.android_spotshop.utilities.CustomerUtility;
import be.fenego.android_spotshop.utilities.LoginUtility;
import butterknife.ButterKnife;

/**
 * Created by Thijs on 1/25/2017.
 */

public class ReviewFragment extends android.support.v4.app.Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(LoginUtility.isUserLoggedIn()){
            // Haal Fragment-layout op
            View fragmentView = inflater.inflate(R.layout.fragment_activity_account, container, false);
            ButterKnife.bind(this, fragmentView);



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
