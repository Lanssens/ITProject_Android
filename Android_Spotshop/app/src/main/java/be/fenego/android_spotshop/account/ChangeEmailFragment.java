package be.fenego.android_spotshop.account;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import be.fenego.android_spotshop.R;
import be.fenego.android_spotshop.callbacks.CustomerCallback;
import be.fenego.android_spotshop.home.HomeFragment;
import be.fenego.android_spotshop.utilities.CustomerUtility;
import be.fenego.android_spotshop.callbacks.GeneralCallback;
import be.fenego.android_spotshop.utilities.LoginUtility;
import be.fenego.android_spotshop.login.LoginFragment;
import be.fenego.android_spotshop.models.Customer;
import be.fenego.android_spotshop.models.CustomerFew;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

/**
 * Created by Thijs on 1/12/2017.
 */

public class ChangeEmailFragment extends android.support.v4.app.Fragment implements GeneralCallback, CustomerCallback {
    @BindView(R.id.change_email_input1)
    EditText _emailText1;
    @BindView(R.id.change_email_input2)
    EditText _emailText2;

    private CustomerFew newCustomer;
    private Customer customer;

    @OnClick(R.id.change_email_save)
    public void saveButton(Button view) {
        if (validate()) {
            if (!customer.equals(null)) {
               /* newCustomer = new CustomerFew();
                newCustomer.setCustomerNo(UUID.randomUUID().toString());
                newCustomer.setPreferredLanguage("de_DE");
                newCustomer.setFirstName(customer.getFirstName());
                newCustomer.setLastName(customer.getLastName());
                newCustomer.setPhoneMobile(customer.getPhoneMobile());
                newCustomer.setEmail(_emailText1.getText().toString());
                CustomerUtility.updateCustomerFew(this, newCustomer);*/

                customer.setEmail(_emailText1.getText().toString());
                CustomerUtility.updateCustomerFull(this, customer);

            }


        }
    }

    @OnTextChanged(value = {R.id.change_email_input1, R.id.change_email_input2},
            callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void fixValidationOnTextChanged() {
        validate();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (LoginUtility.isUserLoggedIn()) {
            // Haal Fragment-layout op
            View fragmentView = inflater.inflate(R.layout.fragment_activity_changemail, container, false);
            ButterKnife.bind(this, fragmentView);

            CustomerUtility.getCustomerData(this);

            getActivity().setTitle("Change email");

            return fragmentView;
        } else {
            Fragment newFragment = new HomeFragment();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack
            transaction.replace(R.id.flContent, newFragment);
            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
        }
        return null;
    }

    public boolean validate() {
        boolean valid = true;

        String email1 = _emailText1.getText().toString();
        String email2 = _emailText1.getText().toString();


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

        return valid;
    }

    @Override
    public void onSuccess() {
        Toast.makeText(getActivity(), "Email Changed", Toast.LENGTH_SHORT).show();

        LoginUtility.removeUserCredentials();
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
    public void onSuccessCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void onError() {
        Toast.makeText(getActivity(), "Email already in use", Toast.LENGTH_SHORT).show();
    }
}
