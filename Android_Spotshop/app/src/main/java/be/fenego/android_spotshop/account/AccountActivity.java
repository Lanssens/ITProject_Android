package be.fenego.android_spotshop.account;

/**
 * Created by Thijs on 1/11/2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.UUID;

import be.fenego.android_spotshop.R;
import be.fenego.android_spotshop.login.LoginActivity;
import be.fenego.android_spotshop.models.Address;
import be.fenego.android_spotshop.models.Credentials;
import be.fenego.android_spotshop.models.Customer;
import be.fenego.android_spotshop.services.CustomerService;
import be.fenego.android_spotshop.services.ServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Thijs on 12/21/2016.
 */
public class AccountActivity extends android.support.v4.app.Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Haal Fragment-layout op
        View fragmentView = inflater.inflate(R.layout.fragment_activity_test, container, false);
        //testPostCustomer();

        return fragmentView;
    }


}

