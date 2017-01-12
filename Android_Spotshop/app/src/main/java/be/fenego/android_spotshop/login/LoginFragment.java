package be.fenego.android_spotshop.login;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import be.fenego.android_spotshop.R;
import be.fenego.android_spotshop.general.LoginUtility;
import be.fenego.android_spotshop.home.HomeFragment;
import be.fenego.android_spotshop.menu.MenuActivity;
import be.fenego.android_spotshop.signup.SignupFragment;
import butterknife.ButterKnife;
import butterknife.*;

/**
 * Created by Thijs on 02/01/2017.
 */


public class LoginFragment extends android.support.v4.app.Fragment  {

    private static final String TAG = "LoginFragment";
    private static final int REQUEST_SIGNUP = 0;

    @BindView(R.id.input_email) EditText _emailText;
    @BindView(R.id.input_password) EditText _passwordText;
    @BindView(R.id.btn_login) Button _loginButton;
    @BindView(R.id.link_signup) TextView _signupLink;
    @BindView(R.id.link_forgot_password) TextView _forgotPasswordLink;

    @OnTextChanged(value = { R.id.input_email, R.id.input_password },
            callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void fixValidationOnTextChanged() {
        validate();
    }


    @OnClick(R.id.btn_login)
    public void loginButton(Button view) {
        login();
    }
    @OnClick({R.id.link_signup, R.id.link_forgot_password})
    public void linkToRightPage(TextView view) {
        Toast.makeText(getContext(), "Clicked on " + view.getText(), Toast.LENGTH_SHORT).show();
        switch(view.getText().toString()){
            case "Forgot your password?": openForgotPasswordFragment(); break;
            case "Sign up": openSignupFragment(); break;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Haal Fragment-layout op
        //http://sourcey.com/beautiful-android-login-and-signup-screens-with-material-design/
        View fragmentView = inflater.inflate(R.layout.fragment_activity_login, container, false);

        ButterKnife.bind(this, fragmentView);
        getActivity().setTitle("Login");

        return fragmentView;
    }


    public void login() {
        Log.d(TAG, "Login");

        if (!validate()) {
            onLoginFailed();
            return;
        }

        _loginButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        //progressDialog.setIndeterminate(true);
        //progressDialog.getWindow().setGravity(Gravity.BOTTOM);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();


        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        LoginUtility.loginUser(this, email, password);

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        if(LoginUtility.isUserLoggedIn()){
                            onLoginSuccess();
                        }
                        else{
                            onLoginFailed();
                        }
                        progressDialog.dismiss();
                    }
                }, 3000);
    }

    public void openSignupFragment() {

        // Create new fragment and transaction
        Fragment newFragment = new SignupFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack
        transaction.replace(R.id.flContent, newFragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
    }

    public void openForgotPasswordFragment() {
        Toast.makeText(getActivity(), "Clicked on forgot password", Toast.LENGTH_LONG).show();

    }



    public void onLoginSuccess() {

        //Cannot login anymore for safety
        _loginButton.setEnabled(true);

        // Check if no view has focus:
        MenuActivity.hideKeyboard((MenuActivity)getActivity());

        // Create new fragment and transaction
        Fragment newFragment = new HomeFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack
        transaction.replace(R.id.flContent, newFragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
        ((MenuActivity)getActivity()).changePersonalTabInMenu(LoginUtility.isUserLoggedIn());
        Toast.makeText(getActivity(), "Login succeeded", Toast.LENGTH_LONG).show();
    }

    public void onLoginFailed() {
        Toast.makeText(getActivity(), "Incorrect login details. Try again.", Toast.LENGTH_LONG).show();

        _loginButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("Enter a valid email address");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 7 || password.length() > 20 ) {
            _passwordText.setError("Between 7 and 20 alphanumeric characters");
            valid = false;
        } else {
            _passwordText.setError(null);
        }
        return valid;
    }

    //To hide keyboard when going to different fragment
    @Override
    public void onDestroyView() {
        MenuActivity.hideKeyboard((MenuActivity)getActivity());
        super.onDestroyView();
    }
}
