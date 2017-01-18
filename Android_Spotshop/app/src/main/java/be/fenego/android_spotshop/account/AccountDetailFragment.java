package be.fenego.android_spotshop.account;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import be.fenego.android_spotshop.R;
import be.fenego.android_spotshop.callbacks.AddressCallback;
import be.fenego.android_spotshop.callbacks.CountryCallback;
import be.fenego.android_spotshop.utilities.CountryUtility;
import be.fenego.android_spotshop.callbacks.CustomerCallback;
import be.fenego.android_spotshop.utilities.CustomerUtility;
import be.fenego.android_spotshop.callbacks.GeneralCallback;
import be.fenego.android_spotshop.callbacks.StringCallback;
import be.fenego.android_spotshop.models.Address;
import be.fenego.android_spotshop.models.Country;
import be.fenego.android_spotshop.models.Customer;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Thijs on 1/13/2017.
 */

public class AccountDetailFragment extends android.support.v4.app.Fragment implements CountryCallback, CustomerCallback ,StringCallback, AddressCallback, GeneralCallback{

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

    private ProgressDialog progress;

    private List<Country> allCountries;

    @OnClick(R.id.account_detail_btn_save)
    public void saveButton(Button view) {
        if(validate()){
            customer.setFirstName(_firstName.getText().toString());
            customer.setLastName(_lastName.getText().toString());
            customer.setPhoneMobile(_phone.getText().toString());

            CustomerUtility.updateCustomerFull(this, customer);

            address.setStreet(_street.getText().toString());
            address.setPostalCode(_postal.getText().toString());
            address.setCity(_city.getText().toString());
            address.setCountryCode(allCountries.get(spinnerCountries.getSelectedItemPosition()).getAlpha2Code());

            CustomerUtility.updateCustomerAddress(this, uri, address);

            Toast.makeText(getActivity(), "Data saved!", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean validate() {
        boolean valid = true;

        String firstname = _firstName.getText().toString();
        String lastname = _lastName.getText().toString();
        String phone = _phone.getText().toString();
        String postal = _postal.getText().toString();
        String city = _city.getText().toString();
        String address = _street.getText().toString();


        //Check the rest
        if (firstname.isEmpty() || firstname.length() < 1 || firstname.length() > 20) {
            _firstName.setError("Cannot be empty");
            valid = false;
        } else {
            _firstName.setError(null);
        }

        if (lastname.isEmpty() || lastname.length() < 1 || lastname.length() > 20) {
            _lastName.setError("Cannot be empty");
            valid = false;
        } else {
            _lastName.setError(null);
        }

        if (phone.isEmpty() || phone.length() < 1 || phone.length() > 20) {
            _phone.setError("Cannot be empty");
            valid = false;
        } else {
            _phone.setError(null);
        }

        if (address.isEmpty() || address.length() < 1 || address.length() > 20) {
            _street.setError("Cannot be empty");
            valid = false;
        } else {
            _street.setError(null);
        }

        if (postal.isEmpty() || postal.length() < 1 || postal.length() > 20) {
            _postal.setError("Cannot be empty");
            valid = false;
        } else {
            _postal.setError(null);
        }

        if (city.isEmpty() || city.length() < 1 || city.length() > 20) {
            _city.setError("Cannot be empty");
            valid = false;
        } else {
            _city.setError(null);
        }


        return valid;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Haal Fragment-layout op
        View fragmentView = inflater.inflate(R.layout.fragment_activity_accountdetails, container, false);
        ButterKnife.bind(this, fragmentView);


        progress = new ProgressDialog(getActivity());
        progress.setTitle("Loading");
        progress.setMessage("Loading data...");
        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        progress.show();

        CustomerUtility.getCustomerData(this);

        CountryUtility.getAllCountries(this);
        getActivity().setTitle("Account Detail");



        return fragmentView;
    }

    Spinner spinnerCountries;
    @Override
    public void onSuccessCountry(List<Country> countries) {
        allCountries = countries;
        List<String> spinnerArrayCountries = new ArrayList<String>();


        for (Country country : allCountries) {
            spinnerArrayCountries.add(country.getName());

        }
        spinnerCountries = (Spinner) getView().findViewById(R.id.account_detail_countries);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.signup_spinner_item, spinnerArrayCountries);
        spinnerCountries.setAdapter(adapter); // this will set list of values to spinner

        //spinnerCountries.setSelection(0);//set selected value in spinner

        CustomerUtility.getCustomerAddressUri( this);
    }

    @Override
    public void onCountryError() {

    }

    private Customer customer;
    @Override
    public void onSuccessCustomer(Customer customer) {
        this.customer = customer;
        _firstName.setText(customer.getFirstName());
        _lastName.setText(customer.getLastName());

        _phone.setText(customer.getPhoneMobile());


        //_countries.setText(customer.getFirstName());
       // Toast.makeText(getActivity(), customer.getAddress().getStreet(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onError() {

    }

    private String uri;
    @Override
    public void onSuccessString(String text) {
        this.uri = text;
        //Toast.makeText(getActivity(), "textyes", Toast.LENGTH_SHORT).show();
        CustomerUtility.getCustomerAddress(this, text);

    }

    @Override
    public void onErrorString() {
        //Toast.makeText(getActivity(), "textno", Toast.LENGTH_SHORT).show();
    }

    private Address address;
    @Override
    public void onSuccessAddress(Address address) {
        this.address = address;
        Toast.makeText(getActivity(), address.getCountryCode(), Toast.LENGTH_SHORT).show();
        _postal.setText(address.getPostalCode());
        _city.setText(address.getCity());
        _street.setText(address.getStreet());

        int selectionNumber = 0;
        System.out.println("--");
        System.out.println(address.getCountryCode());
        System.out.println("--");
        for(int i = 0; i < allCountries.size(); i++){
            if(allCountries.get(i).getAlpha2Code().equals(address.getCountryCode())){
                System.out.println("Were in: " + allCountries.get(i).getAlpha2Code() + " " + address.getCountryCode());
                selectionNumber=i;
            }

        }
        System.out.println(selectionNumber + "");
        spinnerCountries.setSelection(selectionNumber);

        progress.dismiss();

    }

    @Override
    public void onAddressError() {
       // Toast.makeText(getActivity(), "addressno", Toast.LENGTH_SHORT).show();
    }
}
