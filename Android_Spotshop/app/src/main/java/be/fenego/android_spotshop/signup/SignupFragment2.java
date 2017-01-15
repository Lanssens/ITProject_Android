package be.fenego.android_spotshop.signup;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.InputFilter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import be.fenego.android_spotshop.R;
import be.fenego.android_spotshop.general.CountryCallback;
import be.fenego.android_spotshop.general.CountryUtility;
import be.fenego.android_spotshop.general.CustomerCreationCallback;
import be.fenego.android_spotshop.general.CustomerUtility;
import be.fenego.android_spotshop.general.InputFilterMinMax;
import be.fenego.android_spotshop.login.LoginFragment;
import be.fenego.android_spotshop.models.Address;
import be.fenego.android_spotshop.models.Country;
import be.fenego.android_spotshop.models.Credentials;
import be.fenego.android_spotshop.models.Customer;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

/**
 * Created by Thijs on 02/01/2017.
 */

public class SignupFragment2 extends android.support.v4.app.Fragment implements CustomerCreationCallback, CountryCallback {

    private List<Country> allCountries;
    private List<String> allMonths;
    private ProgressDialog progress;

    @BindView(R.id.register_btn_complete)
    Button _nextButton;
    @BindView(R.id.register_title3)
    TextView titleText3;
    @BindView(R.id.register_title4)
    TextView titleText4;
    @BindView(R.id.register_input_firstname)
    EditText _firstnameText;
    @BindView(R.id.register_input_lastname)
    EditText _lastnameText;
    @BindView(R.id.register_input_phone)
    EditText _phoneText;
    @BindView(R.id.register_input_day)
    EditText _dayText;
    @BindView(R.id.register_input_year)
    EditText _yearText;
    @BindView(R.id.register_input_address)
    EditText _addressText;
    @BindView(R.id.register_input_postalcode)
    EditText _postalcodeText;
    @BindView(R.id.register_input_city)
    EditText _cityText;
    @BindView(R.id.register_input_countries)
    Spinner _allCountriesSpinner;

    View fragmentView;

    @OnTextChanged(value = {R.id.register_input_firstname, R.id.register_input_lastname, R.id.register_input_phone, R.id.register_input_day, R.id.register_input_year, R.id.register_input_address, R.id.register_input_postalcode, R.id.register_input_city},
            callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void fixValidationOnTextChanged() {
        validate();
    }


    @OnClick(R.id.register_btn_complete)
    public void loginButton(Button view) {
        nextFragment();
    }

    private String postEmail;
    private String postPassword;
    private String postQuestion;
    private String postAnswer;
    private String postFirstname;
    private String postLastname;
    private String postPhone;
    private String postDate;
    private String postCountry;
    private String postAddress;
    private String postPostal;
    private String postCity;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.fragment_activity_signup2, container, false);

        progress = new ProgressDialog(getActivity());
        progress.setTitle("Loading");
        progress.setMessage("Loading data...");
        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        progress.show();

        ButterKnife.bind(this, fragmentView);

        getActivity().setTitle("Signup");

        if(getArguments() != null){
            postEmail = getArguments().getString("email");
            postPassword = getArguments().getString("password");
            postQuestion = getArguments().getString("question");
            postAnswer = getArguments().getString("answer");
        }


        Toast.makeText(getActivity(), postEmail + postPassword + postQuestion + postAnswer, Toast.LENGTH_SHORT).show();


        titleText3.setTextColor(Color.parseColor("#df6162"));
        titleText4.setTextColor(Color.parseColor("#df6162"));

        CountryUtility.getAllCountries(this);


        return fragmentView;
    }

    private void loadMonths() {
        String[] months = new DateFormatSymbols().getMonths();
        List<String> allMonths = Arrays.asList(months);

        EditText et = (EditText) getView().findViewById(R.id.register_input_day);
        et.setFilters(new InputFilter[]{new InputFilterMinMax("1", "31")});

        et = (EditText) getView().findViewById(R.id.register_input_year);
        et.setFilters(new InputFilter[]{new InputFilterMinMax("1", Integer.toString(Calendar.getInstance().get(Calendar.YEAR)))});

        Spinner spinnerMonths = (Spinner) getView().findViewById(R.id.register_input_month);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.signup_spinner_item, allMonths);
        spinnerMonths.setAdapter(adapter); // this will set list of values to spinner

        spinnerMonths.setSelection(0);
        progress.dismiss();
    }

    private void nextFragment() {
        if(validate()){
            Spinner spinnerMonths = (Spinner) getView().findViewById(R.id.register_input_month);
            int month= spinnerMonths.getSelectedItemPosition()+1;

            Spinner spinnerCountry = (Spinner) getView().findViewById(R.id.register_input_countries);


            postDate = _yearText.getText().toString() + "-" + month + "-" +  _dayText.getText().toString();
            postFirstname = _firstnameText.getText().toString();
            postLastname = _lastnameText.getText().toString();
            postPhone = _phoneText.getText().toString();
            postCountry = spinnerCountry.getSelectedItem().toString();
            postAddress = _addressText.getText().toString();
            postPostal = _postalcodeText.getText().toString();
            postCity = _cityText.getText().toString();


            String postCountrycode = "";
            for(Country coun : allCountries){
                if(coun.getName().equals(postCountry)){
                    postCountrycode = coun.getAlpha2Code();
                }
            }


            Credentials creds = new Credentials();
            creds.setLogin(postEmail);
            Log.v("test", postEmail);
            creds.setPassword(postPassword);
            Log.v("test", postPassword);
            creds.setSecurityQuestion(postQuestion);
            Log.v("test", postQuestion);
            creds.setSecurityQuestionAnswer(postAnswer);
            Log.v("test", postAnswer);

            Address add = new Address();
            add.setAddressName("FirstAddress");
            add.setEmail(postEmail);
            Log.v("test", postEmail);
            add.setFirstName(postFirstname);
            Log.v("test", postFirstname);
            add.setLastName(postLastname);
            Log.v("test", postLastname);
            add.setCountryCode(postCountrycode);
            Log.v("test", postCountrycode);
            add.setPostalCode(postPostal);
            Log.v("test", postPostal);
            add.setCity(postCity);
            Log.v("test", postCity);
            add.setStreet(postAddress);
            Log.v("test", postAddress);

            Customer customer = new Customer();
            customer.setCustomerNo(UUID.randomUUID().toString());
            customer.setTitle("Mr");
            customer.setFirstName(postFirstname);
            Log.v("test", postFirstname);
            customer.setLastName(postLastname);
            Log.v("test", postLastname);
            customer.setBirthday(postDate);
            Log.v("test", postDate);
            customer.setPhoneHome(postPhone);
            Log.v("test", postPhone);
            customer.setPhoneMobile(postPhone);
            Log.v("test", postPhone);
            customer.setFax(postPhone);
            Log.v("test", postPhone);
            customer.setEmail(postEmail);
            Log.v("test", postEmail);
            customer.setPreferredLanguage("de_DE");


            customer.setCredentials(creds);
            customer.setAddress(add);



            CustomerUtility.createCustomer(this, customer);
        }else{
            Toast.makeText(getActivity(), "Fill in the field correctly", Toast.LENGTH_SHORT).show();
        }
    }

    final static String DATE_FORMAT = "dd-MM-yyyy";

    public static boolean isDateValid(String date)
    {
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            //DateFormat df = DateFormat.getDateInstance();
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    private boolean validate() {
        boolean valid = true;
       
        String firstname = _firstnameText.getText().toString();
        String lastname = _lastnameText.getText().toString();
        String phone = _phoneText.getText().toString();
        String day = _dayText.getText().toString();
        String year = _yearText.getText().toString();
        String address = _addressText.getText().toString();
        String postal = _postalcodeText.getText().toString();
        String city = _cityText.getText().toString();

        //Check if date is valid
        if (isInteger(year) && isInteger(day)) {
            Spinner spinnerMonths = (Spinner) getView().findViewById(R.id.register_input_month);
            int month= spinnerMonths.getSelectedItemPosition()+1;

            if(!isDateValid( day + "-" + month + "-" + year )){
                _dayText.setError("Invalid date");
                _yearText.setError("Invalid date");
                valid = false;
            }else{
                _dayText.setError(null);
                _yearText.setError(null);
            }

        } else {
            _dayText.setError("Invalid date");
            _yearText.setError("Invalid date");
            valid = false;
        }

        System.out.print("out");


        //Check the rest
        if (firstname.isEmpty() || firstname.length() < 1 || firstname.length() > 20) {
            _firstnameText.setError("Cannot be empty");
            valid = false;
        } else {
            _firstnameText.setError(null);
        }

        if (lastname.isEmpty() || lastname.length() < 1 || lastname.length() > 20) {
            _lastnameText.setError("Cannot be empty");
            valid = false;
        } else {
            _lastnameText.setError(null);
        }

        if (phone.isEmpty() || phone.length() < 1 || phone.length() > 20) {
            _phoneText.setError("Cannot be empty");
            valid = false;
        } else {
            _phoneText.setError(null);
        }

        if (address.isEmpty() || address.length() < 1 || address.length() > 20) {
            _addressText.setError("Cannot be empty");
            valid = false;
        } else {
            _addressText.setError(null);
        }

        if (postal.isEmpty() || postal.length() < 1 || postal.length() > 20) {
            _postalcodeText.setError("Cannot be empty");
            valid = false;
        } else {
            _postalcodeText.setError(null);
        }

        if (city.isEmpty() || city.length() < 1 || city.length() > 20) {
            _cityText.setError("Cannot be empty");
            valid = false;
        } else {
            _cityText.setError(null);
        }

        return valid;
    }

    public boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        // Only got here if we didn't return false
        return true;
    }

    @Override
    public void onSuccessCountry(List<Country> countries) {
        allCountries = countries;
        List<String> spinnerArrayCountries = new ArrayList<String>();

        loadMonths();

        for (Country country : allCountries) {
            spinnerArrayCountries.add(country.getName());

        }
        Spinner spinnerCountries = (Spinner) getView().findViewById(R.id.register_input_countries);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.signup_spinner_item, spinnerArrayCountries);
        spinnerCountries.setAdapter(adapter); // this will set list of values to spinner

        spinnerCountries.setSelection(0);//set selected value in spinner


    }


    public void loadCountriesWhenAPIDown() {
        allCountries = new ArrayList<>();

        Country belgium = new Country();
        belgium.setName("Belgium");
        belgium.setAlpha2Code("BE");
        Country nederland = new Country();
        nederland.setName("Netherlands");
        nederland.setAlpha2Code("NL");
        Country duitsland = new Country();
        duitsland.setName("Germany");
        duitsland.setAlpha2Code("DE");
        Country luxemburg = new Country();
        luxemburg.setName("Luxemburg");
        luxemburg.setAlpha2Code("LU");

        allCountries.add(belgium);
        allCountries.add(nederland);
        allCountries.add(duitsland);
        allCountries.add(luxemburg);

        List<String> spinnerArrayCountries = new ArrayList<String>();


        for (Country country : allCountries) {
            spinnerArrayCountries.add(country.getName());

        }
        Spinner spinnerCountries = (Spinner) getView().findViewById(R.id.register_input_countries);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.signup_spinner_item, spinnerArrayCountries);
        spinnerCountries.setAdapter(adapter); // this will set list of values to spinner

        spinnerCountries.setSelection(0);//set selected value in spinner


    }

    @Override
    public void onCountryError() {
        loadMonths();

        loadCountriesWhenAPIDown();


        Toast.makeText(getActivity(), "Couldn't load countries", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onSuccessCreationCustomer() {
        Toast.makeText(getActivity(), "Registration successful", Toast.LENGTH_SHORT).show();
        Fragment newFragment = new LoginFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack
        transaction.replace(R.id.flContent, newFragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
    }

    @Override
    public void onErrorCreationCustomer() {
        Toast.makeText(getActivity(), "Email is already in use, choose a different one", Toast.LENGTH_SHORT).show();
        Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_SHORT).show();
    }
}