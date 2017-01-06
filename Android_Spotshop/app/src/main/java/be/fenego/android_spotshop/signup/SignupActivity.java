package be.fenego.android_spotshop.signup;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import be.fenego.android_spotshop.R;
import be.fenego.android_spotshop.general.CountryCallback;
import be.fenego.android_spotshop.general.CountryUtility;
import be.fenego.android_spotshop.general.CustomerUtility;
import be.fenego.android_spotshop.general.QuestionCallback;
import be.fenego.android_spotshop.models.Country;
import be.fenego.android_spotshop.models.Question;
import butterknife.InjectView;

import static android.R.attr.value;

/**
 * Created by Thijs on 02/01/2017.
 */

public class SignupActivity extends  android.support.v4.app.Fragment implements CountryCallback, QuestionCallback {

    private List<Country> allCountries;
    private List<Question> allQuestions;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Haal Fragment-layout op


        View fragmentView = inflater.inflate(R.layout.fragment_activity_signup, container, false);
        getActivity().setTitle("Signup");

        CountryUtility.getAllCountries(this);
        CustomerUtility.getAllQuestions(this);


        fragmentView = inflater.inflate(R.layout.fragment_activity_signup2, container, false);


        return fragmentView;
    }



    @Override
    public void onSuccessCountry(List<Country> countries) {
        allCountries = countries;
        List<String> spinnerArrayCountries =  new ArrayList<String>();

    }

    @Override
    public void onSuccessQuestion(List<Question> questions) {
        allQuestions = questions;
        List<String> spinnerArrayQuestions =  new ArrayList<String>();
        for(Question question : allQuestions){
            spinnerArrayQuestions.add(question.getText());
            System.out.println(question.getText());
        }
        Spinner spinnerQuestions = (Spinner)getView().findViewById(R.id.register_input_security_questions);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.signup_spinner_item,spinnerArrayQuestions);
        spinnerQuestions.setAdapter(adapter); // this will set list of values to spinner

        spinnerQuestions.setSelection(0);//set selected value in spinner
    }

    @Override
    public void onError() {

    }
}
