package be.fenego.android_spotshop.account;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import be.fenego.android_spotshop.R;
import be.fenego.android_spotshop.general.CustomerUtility;
import butterknife.ButterKnife;

/**
 * Created by Thijs on 1/13/2017.
 */

public class AccountDetailFragment extends android.support.v4.app.Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Haal Fragment-layout op
        View fragmentView = inflater.inflate(R.layout.fragment_activity_accountdetails, container, false);
        ButterKnife.bind(this, fragmentView);

        getActivity().setTitle("Account Detail");

        //CustomerUtility.getCustomerData();

        return fragmentView;
    }
}
