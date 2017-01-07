package be.fenego.android_spotshop.signup;

import android.graphics.Color;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.util.TimeUtils;
import android.text.InputFilter;
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

import be.fenego.android_spotshop.R;
import be.fenego.android_spotshop.general.CountryCallback;
import be.fenego.android_spotshop.general.CountryUtility;
import be.fenego.android_spotshop.general.CustomerUtility;
import be.fenego.android_spotshop.general.InputFilterMinMax;
import be.fenego.android_spotshop.general.QuestionCallback;
import be.fenego.android_spotshop.models.Country;
import be.fenego.android_spotshop.models.Question;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnTextChanged;

import static android.R.attr.value;

/**
 * Created by Thijs on 02/01/2017.
 */

public class SignupActivity2 extends android.support.v4.app.Fragment implements CountryCallback {

    private List<Country> allCountries;
    private List<String> allMonths;

    @InjectView(R.id.register_btn_complete)
    Button _nextButton;
    @InjectView(R.id.register_title3)
    TextView titleText3;
    @InjectView(R.id.register_title4)
    TextView titleText4;
    @InjectView(R.id.register_input_firstname)
    EditText _firstnameText;
    @InjectView(R.id.register_input_lastname)
    EditText _lastnameText;
    @InjectView(R.id.register_input_phone)
    EditText _phoneText;
    @InjectView(R.id.register_input_day)
    EditText _dayText;
    @InjectView(R.id.register_input_year)
    EditText _yearText;
    @InjectView(R.id.register_input_address)
    EditText _addressText;
    @InjectView(R.id.register_input_postalcode)
    EditText _postalcodeText;
    @InjectView(R.id.register_input_city)
    EditText _cityText;

    View fragmentView;

    @OnTextChanged(value = {R.id.register_input_firstname, R.id.register_input_lastname, R.id.register_input_phone, R.id.register_input_day, R.id.register_input_year, R.id.register_input_address, R.id.register_input_postalcode, R.id.register_input_city},
            callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void fixValidationOnTextChanged() {
        validate();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.fragment_activity_signup2, container, false);

        ButterKnife.inject(this, fragmentView);

        getActivity().setTitle("Signup");

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
    }

    private void nextFragment() {
        Fragment newFragment = new SignupActivity2();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack
        transaction.replace(R.id.flContent, newFragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
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
