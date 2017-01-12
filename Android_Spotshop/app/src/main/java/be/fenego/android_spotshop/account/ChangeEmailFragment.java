package be.fenego.android_spotshop.account;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import be.fenego.android_spotshop.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

/**
 * Created by Thijs on 1/12/2017.
 */

public class ChangeEmailFragment extends android.support.v4.app.Fragment {
    @BindView(R.id.change_email_input1)
    EditText _emailText1;
    @BindView(R.id.change_email_input2)
    EditText _emailText2;

    @OnClick(R.id.change_email_save)
    public void loginButton(Button view) {
        if(validate()){
            //TODO: put new password
        }
    }

    @OnTextChanged(value = { R.id.change_email_input1 , R.id.change_email_input2 },
            callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void fixValidationOnTextChanged() {
        validate();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Haal Fragment-layout op
        View fragmentView = inflater.inflate(R.layout.fragment_activity_changepassword, container, false);
        ButterKnife.bind(this, fragmentView);

        getActivity().setTitle("Change email");

        return fragmentView;
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
}
