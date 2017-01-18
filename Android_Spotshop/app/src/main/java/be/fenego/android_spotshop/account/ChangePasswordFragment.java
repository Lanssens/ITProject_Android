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
import be.fenego.android_spotshop.utilities.CustomerUtility;
import be.fenego.android_spotshop.callbacks.GeneralCallback;
import be.fenego.android_spotshop.models.PasswordChange;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

/**
 * Created by Thijs on 1/12/2017.
 */

public class ChangePasswordFragment extends android.support.v4.app.Fragment implements GeneralCallback {
    @BindView(R.id.change_password_input1)
    EditText _passwordText1;
    @BindView(R.id.change_password_input2)
    EditText _passwordText2;

    @OnClick(R.id.change_password_save)
    public void saveButton(Button view) {
        if(validate()){
            PasswordChange pw = new PasswordChange();
            pw.setPassword(_passwordText1.getText().toString());
            CustomerUtility.updatePassword(this, pw );
        }
    }

    @OnTextChanged(value = { R.id.change_password_input1 , R.id.change_password_input2 },
            callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void fixValidationOnTextChanged() {
        validate();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Haal Fragment-layout op
        View fragmentView = inflater.inflate(R.layout.fragment_activity_changepassword, container, false);
        ButterKnife.bind(this, fragmentView);

        getActivity().setTitle("Change password");

        return fragmentView;
    }

    public boolean validate() {
        boolean valid = true;

        String password1 = _passwordText1.getText().toString();
        String password2 = _passwordText2.getText().toString();


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

        return valid;
    }

    @Override
    public void onSuccess() {
        Toast.makeText(getActivity(), "Password changed", Toast.LENGTH_SHORT).show();

        Fragment newFragment = new AccountFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack
        transaction.replace(R.id.flContent, newFragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
    }

    @Override
    public void onError() {
        Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_SHORT).show();

    }
}
