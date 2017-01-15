package be.fenego.android_spotshop.signup;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import be.fenego.android_spotshop.R;
import be.fenego.android_spotshop.general.CustomerUtility;
import be.fenego.android_spotshop.general.QuestionCallback;
import be.fenego.android_spotshop.models.Question;
import butterknife.OnTextChanged;
import butterknife.*;

/**
 * Created by Thijs on 02/01/2017.
 */

public class SignupFragment extends android.support.v4.app.Fragment implements QuestionCallback {


    private List<Question> allQuestions;
    @BindView(R.id.register_btn_next) Button _nextButton;
    @BindView(R.id.register_title1) TextView titleText1;
    @BindView(R.id.register_title2) TextView titleText2;
    @BindView(R.id.register_input_email) EditText _emailText1;
    @BindView(R.id.register_input_email2) EditText _emailText2;
    @BindView(R.id.register_input_password) EditText _passwordText1;
    @BindView(R.id.register_input_password2) EditText _passwordText2;
    @BindView(R.id.register_input_answer) EditText _answerText;

    View fragmentView;
    LayoutInflater inflater;
    ViewGroup container;

    @OnClick(R.id.register_btn_next)
    public void loginButton(Button view) {
        nextFragment();
    }

    @OnTextChanged(value = { R.id.register_input_email, R.id.register_input_email2 , R.id.register_input_password , R.id.register_input_password2 , R.id.register_input_answer },
            callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void fixValidationOnTextChanged() {
        validate();
    }

    private ProgressDialog progress;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        progress = new ProgressDialog(getActivity());
        progress.setTitle("Loading");
        progress.setMessage("Loading data...");
        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        progress.show();
// To dismiss the dialog

        fragmentView = inflater.inflate(R.layout.fragment_activity_signup, container, false);
        ButterKnife.bind(this, fragmentView);

        getActivity().setTitle("Signup");
        // Haal Fragment-layout op
        this.inflater = inflater;
        this.container = container;

        CustomerUtility.getAllQuestions(this);

        titleText1.setTextColor(Color.parseColor("#df6162"));
        titleText2.setTextColor(Color.parseColor("#df6162"));


        return fragmentView;
    }

    public boolean validate() {
        boolean valid = true;

        String email1 = _emailText1.getText().toString();
        String email2 = _emailText2.getText().toString();
        String password1 = _passwordText1.getText().toString();
        String password2 = _passwordText2.getText().toString();
        String answer = _answerText.getText().toString();

        if (email1.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email1).matches()) {
            _emailText1.setError("Enter a valid email address");
            valid = false;
        } else {
            _emailText1.setError(null);
        }
        if (!email2.equals(email1)) {
            _emailText2.setError("Emails not identical");
            valid = false;
        } else {
            _emailText2.setError(null);
        }


        if (password1.isEmpty() || password1.length() < 7 || password1.length() > 20 || !password1.matches(".*\\d+.*") || !password1.matches(".*[A-Z].*")) {
            _passwordText1.setError("Between 7 and 20 alphanumeric characters, atleast one number and uppercase character");
            valid = false;
        } else {
            _passwordText1.setError(null);
        }
        if (!password2.equals(password1)) {
            _passwordText2.setError("Passwords not identical");
            valid = false;
        } else {
            _passwordText2.setError(null);
        }
        //.chars().allMatch(Character::isLetter);

        if (answer.isEmpty() || answer.length() < 3 || answer.length() > 20) {
            _answerText.setError("Must be between 3 and 20 letters long");
            valid = false;
        } else {
            _answerText.setError(null);
        }

        return valid;
    }
    private void nextFragment() {

        if(validate()){
            // Create new fragment and transaction
            Fragment newFragment = new SignupFragment2();
            Spinner spinner = (Spinner) getView().findViewById(R.id.register_input_security_questions);

            Bundle bundle = new Bundle();
            bundle.putString("email", _emailText1.getText().toString());
            bundle.putString("password", _passwordText1.getText().toString());
            bundle.putString("question", spinner.getSelectedItem().toString());
            bundle.putString("answer", _answerText.getText().toString());
            newFragment.setArguments(bundle);

            FragmentTransaction transaction = getFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack
            transaction.replace(R.id.flContent, newFragment);
            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
        }else{
            Toast.makeText(getActivity(), "Fill in the field correctly", Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    public void onSuccessQuestion(List<Question> questions) {
        allQuestions = questions;
        List<String> spinnerArrayQuestions = new ArrayList<String>();
        for (Question question : allQuestions) {
            spinnerArrayQuestions.add(question.getText());
        }
        Spinner spinnerQuestions = (Spinner) getView().findViewById(R.id.register_input_security_questions);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.signup_spinner_item, spinnerArrayQuestions);
        spinnerQuestions.setAdapter(adapter); // this will set list of values to spinner

        spinnerQuestions.setSelection(0);//set selected value in spinner
        progress.dismiss();
    }

    @Override
    public void onError() {

    }
}
