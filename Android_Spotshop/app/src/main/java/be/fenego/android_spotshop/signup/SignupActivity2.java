package be.fenego.android_spotshop.signup;

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

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import be.fenego.android_spotshop.R;
import be.fenego.android_spotshop.general.CountryCallback;
import be.fenego.android_spotshop.general.CountryUtility;
import be.fenego.android_spotshop.general.CustomerUtility;
import be.fenego.android_spotshop.general.InputFilterMinMax;
import be.fenego.android_spotshop.general.QuestionCallback;
import be.fenego.android_spotshop.models.Country;
import be.fenego.android_spotshop.models.Question;
import butterknife.InjectView;

import static android.R.attr.value;

/**
 * Created by Thijs on 02/01/2017.
 */

public class SignupActivity2 extends  android.support.v4.app.Fragment implements CountryCallback {

    private List<Country> allCountries;
    private List<String> allMonths;

    View fragmentView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.fragment_activity_signup2, container, false);

        getActivity().setTitle("Signup");

        CountryUtility.getAllCountries(this);

        return fragmentView;
    }

    private void loadMonths() {
        String[] months = new DateFormatSymbols().getMonths();
        List<String> allMonths = Arrays.asList(months);

        EditText et = (EditText)getView().findViewById(R.id.register_input_day);
        et.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "31")});

        et = (EditText)getView().findViewById(R.id.register_input_year);
        et.setFilters(new InputFilter[]{ new InputFilterMinMax("1", Integer.toString(Calendar.getInstance().get(Calendar.YEAR)))});

        Spinner spinnerMonths = (Spinner)getView().findViewById(R.id.register_input_month);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.signup_spinner_item,allMonths);
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


    @Override
    public void onSuccessCountry(List<Country> countries) {
        allCountries = countries;
        List<String> spinnerArrayCountries =  new ArrayList<String>();

        for(Country country : allCountries){
            spinnerArrayCountries.add(country.getName());

        }
        Spinner spinnerCountries = (Spinner)getView().findViewById(R.id.register_input_countries);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.signup_spinner_item,spinnerArrayCountries);
        spinnerCountries.setAdapter(adapter); // this will set list of values to spinner

        spinnerCountries.setSelection(0);//set selected value in spinner

        loadMonths();
    }

    @Override
    public void onError() {

    }
}
