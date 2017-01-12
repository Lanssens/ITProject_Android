package be.fenego.android_spotshop.signup;

import android.graphics.Color;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.util.TimeUtils;
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
import java.util.Date;
import java.util.List;
import java.util.UUID;

import be.fenego.android_spotshop.R;
import be.fenego.android_spotshop.general.CountryCallback;
import be.fenego.android_spotshop.general.CountryUtility;
import be.fenego.android_spotshop.general.CustomerUtility;
import be.fenego.android_spotshop.general.InputFilterMinMax;
import be.fenego.android_spotshop.general.QuestionCallback;
import be.fenego.android_spotshop.login.LoginActivity;
import be.fenego.android_spotshop.models.Address;
import be.fenego.android_spotshop.models.Country;
import be.fenego.android_spotshop.models.Credentials;
import be.fenego.android_spotshop.models.Customer;
import be.fenego.android_spotshop.models.Question;
import be.fenego.android_spotshop.services.CustomerService;
import be.fenego.android_spotshop.services.ServiceGenerator;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.R.attr.value;

/**
 * Created by Thijs on 02/01/2017.
 */

public class SignupActivity2 extends android.support.v4.app.Fragment implements CountryCallback {

    private List<Country> allCountries;
    private List<String> allMonths;

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

    View fragmentView;

    @OnTextChanged(value = {R.id.register_input_firstname, R.id.register_input_lastname, R.id.register_input_phone, R.id.register_input_day, R.id.register_input_year, R.id.register_input_address, R.id.register_input_postalcode, R.id.register_input_city},
            callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void fixValidationOnTextChanged() {
        validate();
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

        _nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextFragment();
            }
        });

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
    }

    private void nextFragment() {
        if(validate()){
            Spinner spinnerMonths = (Spinner) getView().findViewById(R.id.register_input_month);
            int month= spinnerMonths.getSelectedItemPosition()+1;

            Spinner spinnerCountry = (Spinner) getView().findViewById(R.id.register_input_countries);


            postDate = _yearText.getText().toString() + "-" + month + "-" +  _dayText.getText().toString();
            postFirstname = _firstnameText.getText().toString();
            postLastname = _lastnameText.getText().toString();
            postPhone = _postalcodeText.getText().toString();
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
            creds.setPassword(postPassword);
            creds.setSecurityQuestion(postQuestion);
            creds.setSecurityQuestionAnswer(postAnswer);

            Address add = new Address();
            add.setAddressName("FirstAddress");
            add.setEmail(postEmail);
            add.setFirstName(postFirstname);
            add.setLastName(postLastname);
            add.setCountryCode(postCountrycode);
            add.setPostalCode(postPostal);
            add.setCity(postCity);
            add.setStreet(postAddress);

            Customer customer = new Customer();
            customer.setCustomerNo(UUID.randomUUID().toString());
            customer.setTitle("Mr");
            customer.setFirstName(postFirstname);
            customer.setLastName(postLastname);
            customer.setBirthday(postDate);
            customer.setPhoneHome(postPhone);
            customer.setPhoneMobile(postPhone);
            customer.setFax(postPhone);
            customer.setEmail(postEmail);
            customer.setPreferredLanguage("de_DE");

            customer.setCredentials(creds);
            customer.setAddress(add);


            Toast.makeText(getActivity(), postCountry + " " + postCountrycode, Toast.LENGTH_SHORT).show();
            Toast.makeText(getActivity(), postDate, Toast.LENGTH_SHORT).show();
            CustomerService customerService =
                    ServiceGenerator.createService(CustomerService.class);
            Call<Customer> call = customerService.createCustomer(customer);

            call.enqueue(new Callback<Customer>() {
                @Override
                public void onResponse(Call<Customer> call, Response<Customer> response) {

                    if (response.isSuccessful()) {

                        Toast.makeText(getActivity(), "Registration successful", Toast.LENGTH_SHORT).show();

                        Fragment newFragment = new LoginActivity();
                        FragmentTransaction transaction = getFragmentManager().beginTransaction();

                        // Replace whatever is in the fragment_container view with this fragment,
                        // and add the transaction to the back stack
                        transaction.replace(R.id.flContent, newFragment);
                        transaction.addToBackStack(null);

                        // Commit the transaction
                        transaction.commit();

                    } else {
                        // Error response (kan unauthorized zijn)

                        Toast.makeText(getActivity(), response.message(), Toast.LENGTH_SHORT).show();
                        Toast.makeText(getActivity(), response.errorBody().toString(), Toast.LENGTH_SHORT).show();

                    }
                }
                @Override
                public void onFailure(Call<Customer> call, Throwable t) {
                    // Something went seriously wrong
                    Log.d("Error", t.getMessage());
                }
            });

        }else{
            Toast.makeText(getActivity(), "Fill in the field correctly", Toast.LENGTH_SHORT).show();
        }

    }

    final static String DATE_FORMAT = "dd-MM-yyyy";

    public static boolean isDateValid(String date)
    {
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
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

    @Override
    public void onError() {

    }
}
