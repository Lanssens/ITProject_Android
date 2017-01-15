package be.fenego.android_spotshop.account;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

import be.fenego.android_spotshop.R;
import be.fenego.android_spotshop.general.CountryCallback;
import be.fenego.android_spotshop.general.CustomerCallback;
import be.fenego.android_spotshop.general.CustomerUtility;
import be.fenego.android_spotshop.models.Country;
import be.fenego.android_spotshop.models.Customer;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Thijs on 1/13/2017.
 */

public class AccountDetailFragment extends android.support.v4.app.Fragment implements CountryCallback, CustomerCallback {

    @BindView(R.id.account_detail_firstname)
    EditText _firstName;
    @BindView(R.id.account_detail_lastname)
    EditText _lastName;
    @BindView(R.id.account_detail_phone)
    EditText _phone;
    @BindView(R.id.account_detail_countries)
    Spinner _countries;
    @BindView(R.id.account_detail_postal)
    EditText _postal;
    @BindView(R.id.account_detail_city)
    EditText _city;
    @BindView(R.id.account_detail_street)
    EditText _street;
    

    @OnClick(R.id.account_detail_btn_save)
    public void saveButton(Button view) {
        if(validate()){

        }
    }

    private boolean validate() {
        return true;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Haal Fragment-layout op
        View fragmentView = inflater.inflate(R.layout.fragment_activity_accountdetails, container, false);
        ButterKnife.bind(this, fragmentView);

        getActivity().setTitle("Account Detail");

        CustomerUtility.getCustomerData(this);

        return fragmentView;
    }

    @Override
    public void onSuccessCountry(List<Country> countries) {

    }

    @Override
    public void onCountryError() {

    }

    @Override
    public void onSuccessCustomer(Customer customer) {
        _firstName.setText(customer.getFirstName());
        _lastName.setText(customer.getLastName());

        _phone.setText(customer.getPhoneMobile());
        //_countries.setText(customer.getFirstName());

    }

    @Override
    public void onError() {

    }
}
