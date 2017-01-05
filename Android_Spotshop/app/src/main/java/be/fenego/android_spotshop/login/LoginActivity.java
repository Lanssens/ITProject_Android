package be.fenego.android_spotshop.login;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import be.fenego.android_spotshop.R;
import be.fenego.android_spotshop.general.UserUtility;
import be.fenego.android_spotshop.home.HomeActivity;
import be.fenego.android_spotshop.menu.MenuActivity;
import be.fenego.android_spotshop.signup.SignupActivity;
import be.fenego.android_spotshop.test.TestActivity;
import butterknife.ButterKnife;
import butterknife.*;

import static android.app.Activity.RESULT_OK;

/**
 * Created by Thijs on 02/01/2017.
 */


public class LoginActivity extends android.support.v4.app.Fragment  {

    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;

    @InjectView(R.id.input_email) EditText _emailText;
    @InjectView(R.id.input_password) EditText _passwordText;
    @InjectView(R.id.btn_login) Button _loginButton;
    @InjectView(R.id.link_signup) TextView _signupLink;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Haal Fragment-layout op
        //http://sourcey.com/beautiful-android-login-and-signup-screens-with-material-design/
        View fragmentView = inflater.inflate(R.layout.fragment_activity_login, container, false);

        ButterKnife.inject(this, fragmentView);

        _loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        _signupLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignupFragment();
            }
        });
        return fragmentView;
    }


    public void login() {
        Log.d(TAG, "Login");

        if (!validate()) {
            onLoginFailed();
            return;
        }

        _loginButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(getActivity(),
                R.style.AppTheme);
        progressDialog.setIndeterminate(true);
        progressDialog.getWindow().setGravity(Gravity.BOTTOM);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();


        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        UserUtility.loginUser(this, email, password);

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        if(UserUtility.isUserLoggedIn()){
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
        Toast.makeText(getActivity(), "Clicked on signup", Toast.LENGTH_LONG).show();

        // Create new fragment and transaction
        Fragment newFragment = new SignupActivity();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack
        transaction.replace(R.id.flContent, newFragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
    }

 /*   @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {

                //  Implement successful signup logic here
                // By default we just finish the Activity and log them in automatically
                //this.finish();
            }
        }
    }*/

    public void onLoginSuccess() {
        //Remove login option and add other options to drawermenu


        //Cannot login anymore for safety
        _loginButton.setEnabled(false);

        // Check if no view has focus:
        MenuActivity.hideKeyboard((MenuActivity)getActivity());


        // Create new fragment and transaction
        Fragment newFragment = new TestActivity();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack
        transaction.replace(R.id.flContent, newFragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
        ((MenuActivity)getActivity()).changePersonalTabInMenu(UserUtility.isUserLoggedIn());
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

        if (password.isEmpty() || password.length() < 4 || password.length() > 20) {
            _passwordText.setError("Between 4 and 20 alphanumeric characters");
            valid = false;
        } else {
            _passwordText.setError(null);
        }
        return valid;
    }
}
