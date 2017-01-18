package be.fenego.android_spotshop.account;

/**
 * Created by Thijs on 1/11/2017.
 */

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import be.fenego.android_spotshop.R;
import be.fenego.android_spotshop.callbacks.CustomerCallback;
import be.fenego.android_spotshop.utilities.CustomerUtility;
import be.fenego.android_spotshop.utilities.LoginUtility;
import be.fenego.android_spotshop.login.LoginFragment;
import be.fenego.android_spotshop.menu.MenuActivity;
import be.fenego.android_spotshop.models.Customer;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by Thijs on 12/21/2016.
 */
public class AccountFragment extends android.support.v4.app.Fragment implements CustomerCallback {


    @BindView(R.id.account_header_mail)
    TextView accountMail;
    @BindView(R.id.account_header_name)
    TextView accountName;
    @BindView(R.id.account_link_accountdetails)
    TextView _accountDetails;

    @OnClick({R.id.account_link_accountdetails, R.id.account_link_logout, R.id.account_link_mail, R.id.account_link_orderhistory, R.id.account_link_password})
    public void linkToRightPage(TextView view) {
        Toast.makeText(getContext(), "Clicked on " + view.getText(), Toast.LENGTH_SHORT).show();

        switch(view.getText().toString()){
            case "Account Details": loadFragment(AccountDetailFragment.class);  break;
            case "Order History": break;
            case "Change Password": loadFragment(ChangePasswordFragment.class); break;
            case "Change Email": loadFragment(ChangeEmailFragment.class); break;
            case "Logout": LoginUtility.removeUserCredentials();
                Toast.makeText(getContext(), "Logged out succesfully.", Toast.LENGTH_SHORT).show();
                ((MenuActivity)getActivity()).changePersonalTabInMenu(LoginUtility.isUserLoggedIn());
                loadFragment(LoginFragment.class); break;
        }
    }

    private ProgressDialog progress;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        progress = new ProgressDialog(getActivity());
        progress.setTitle("Loading");
        progress.setMessage("Loading data...");
        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        progress.show();
        // Haal Fragment-layout op
        View fragmentView = inflater.inflate(R.layout.fragment_activity_account, container, false);
        ButterKnife.bind(this, fragmentView);

        getActivity().setTitle("Account");

        CustomerUtility.getCustomerData(this);

        return fragmentView;
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



    @Override
    public void onSuccessCustomer(Customer customer) {
        TextView headerName = (TextView) getView().findViewById(R.id.account_header_name);
        TextView headerMail = (TextView) getView().findViewById(R.id.account_header_mail);

        headerMail.setText(customer.getEmail());
        headerName.setText(customer.getFirstName() + " " + customer.getLastName());
        progress.dismiss();
    }

    @Override
    public void onError() {

    }
}




