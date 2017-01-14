package be.fenego.android_spotshop.test;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.UUID;

import be.fenego.android_spotshop.R;
import be.fenego.android_spotshop.login.LoginActivity;
import be.fenego.android_spotshop.models.Address;
import be.fenego.android_spotshop.models.Credentials;
import be.fenego.android_spotshop.models.Customer;
import be.fenego.android_spotshop.services.CustomerService;
import be.fenego.android_spotshop.services.ServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Thijs on 12/21/2016.
 */
@SuppressWarnings("DefaultFileTemplate")
public class TestActivity extends android.support.v4.app.Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Haal Fragment-layout op
        View fragmentView = inflater.inflate(R.layout.fragment_activity_home, container, false);
        //testPostCustomer();

        return fragmentView;
    }

    public void testPostCustomer(){
        Credentials creds = new Credentials();
        creds.setLogin("aaaeee6565@gmail.com");
        creds.setPassword("Testie123");
        creds.setSecurityQuestion("What is");
        creds.setSecurityQuestionAnswer("Test123");

        Address add = new Address();
        add.setAddressName("FirstAddress");
        add.setEmail("aaaeee6562@gmail.com");
        add.setFirstName("test");
        add.setLastName("teste");
        add.setCountryCode("DE");
        add.setPostalCode("3500");
        add.setCity("hasselt");
        add.setStreet("qsdqsdqs");

        Customer customer = new Customer();
        customer.setCustomerNo(UUID.randomUUID().toString());
        customer.setTitle("Mr");
        customer.setFirstName("test");
        customer.setLastName("teste");
        customer.setBirthday("1996-12-12");
        customer.setPhoneHome("51151515");
        customer.setPhoneMobile("51151515");
        customer.setFax("51151515");
        customer.setEmail("aaaeee6562@gmail.com");
        customer.setPreferredLanguage("de_DE");

        customer.setCredentials(creds);
        customer.setAddress(add);

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
    }
}
