package be.fenego.android_spotshop.account;

/**
 * Created by Thijs on 1/11/2017.
 */

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import be.fenego.android_spotshop.R;
import be.fenego.android_spotshop.general.CustomerCallback;
import be.fenego.android_spotshop.general.CustomerUtility;
import be.fenego.android_spotshop.models.Customer;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by Thijs on 12/21/2016.
 */
public class AccountActivity extends android.support.v4.app.Fragment implements CustomerCallback {


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
            case "Account Details": break;
            case "Order History": break;
            case "Change Password": break;
            case "Change Email": break;
            case "Logout": break;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Haal Fragment-layout op
        View fragmentView = inflater.inflate(R.layout.fragment_activity_account, container, false);
        ButterKnife.bind(this, fragmentView);



        CustomerUtility.getCustomerData(this);

        return fragmentView;
    }




    @Override
    public void onSuccessCustomer(Customer customer) {
        TextView headerName = (TextView) getView().findViewById(R.id.account_header_name);
        TextView headerMail = (TextView) getView().findViewById(R.id.account_header_mail);

        headerMail.setText(customer.getEmail());
        headerName.setText(customer.getFirstName() + " " + customer.getLastName());

    }

    @Override
    public void onError() {

    }
}




