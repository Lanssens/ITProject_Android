package be.fenego.android_spotshop.general;

import android.util.Log;

import java.util.List;

import be.fenego.android_spotshop.models.Customer;
import be.fenego.android_spotshop.models.CustomerFew;
import be.fenego.android_spotshop.models.PasswordChange;
import be.fenego.android_spotshop.models.QuestionWrapper;
import be.fenego.android_spotshop.services.CustomerService;
import be.fenego.android_spotshop.services.SecurityService;
import be.fenego.android_spotshop.services.ServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Thijs on 6/01/2017.
 */

public class CustomerUtility {
    public static void updateCustomer(final GeneralCallback callback, final CustomerFew customer) {
        final List<String> data = LoginUtility.retrieveUserCredentials();

        CustomerService customerService =
                ServiceGenerator.createService(CustomerService.class, data.get(0), data.get(1));
        Call<Customer> call = customerService.updateCustomer(customer);

        call.enqueue(new Callback<Customer>() {
            @Override
            public void onResponse(Call<Customer> call, Response<Customer> response) {

                if (response.isSuccessful()) {
                    //LoginUtility.storeUserCredentials(customer.getCredentials().getLogin(), data.get(1));
                    callback.onSuccess();

                } else {
                    System.out.println(response.errorBody().toString());
                    System.out.println(response.code());
                    System.out.println(response.raw().toString());
                    callback.onError();
                }
            }

            @Override
            public void onFailure(Call<Customer> call, Throwable t) {
                // Something went seriously wrong
                Log.d("Error", t.getMessage());
            }
        });
    }



    public static void getAllQuestions(final QuestionCallback callback) {

        SecurityService securityService = SecurityService.retrofit.create(SecurityService.class);
        final Call<QuestionWrapper> call = securityService.getAllSecurityQuestions();

        call.enqueue(new Callback<QuestionWrapper>() {
            @Override
            public void onResponse(Call<QuestionWrapper> call, Response<QuestionWrapper> response) {

                callback.onSuccessQuestion(response.body().getElements());

            }

            @Override
            public void onFailure(Call<QuestionWrapper> call, Throwable t) {
                System.out.println(t.getMessage());
                callback.onError();
            }
        });
    }

    public static void updatePassword(final GeneralCallback callback, final PasswordChange password) {
        final List<String> data = LoginUtility.retrieveUserCredentials();

        CustomerService customerService =
                ServiceGenerator.createService(CustomerService.class, data.get(0), data.get(1));
        Call<Customer> call = customerService.updatePassword(password);

        call.enqueue(new Callback<Customer>() {
            @Override
            public void onResponse(Call<Customer> call, Response<Customer> response) {

                if (response.isSuccessful()) {
                    System.out.println("Updated password");
                    LoginUtility.storeUserCredentials(data.get(0), password.getPassword());
                    callback.onSuccess();

                } else {
                    System.out.println(response.errorBody().toString());
                    System.out.println(response.code());
                    System.out.println(response.raw().toString());
                    callback.onError();
                }
            }

            @Override
            public void onFailure(Call<Customer> call, Throwable t) {
                // Something went seriously wrong
                Log.d("Error", t.getMessage());
            }
        });
    }

    public static void createCustomer(final CustomerCreationCallback callback, final Customer customer) {
        CustomerService customerService =
                ServiceGenerator.createService(CustomerService.class);
        Call<Customer> call = customerService.createCustomer(customer);

        call.enqueue(new Callback<Customer>() {
            @Override
            public void onResponse(Call<Customer> call, Response<Customer> response) {

                if (response.isSuccessful()) {
                    callback.onSuccessCreationCustomer();

                } else {


                    callback.onError();
                }
            }

            @Override
            public void onFailure(Call<Customer> call, Throwable t) {
                // Something went seriously wrong
                Log.d("Error", t.getMessage());
            }
        });
    }


    public static void update(final QuestionCallback callback){

        SecurityService securityService = SecurityService.retrofit.create(SecurityService.class);
        final Call<QuestionWrapper> call = securityService.getAllSecurityQuestions();

        call.enqueue(new Callback<QuestionWrapper>() {
            @Override
            public void onResponse(Call<QuestionWrapper> call, Response<QuestionWrapper> response) {

                callback.onSuccessQuestion(response.body().getElements());

            }
            @Override
            public void onFailure(Call<QuestionWrapper> call, Throwable t) {
                System.out.println(t.getMessage());
                callback.onError();
            }
        });
    }
    public static boolean getCustomerData(final CustomerCallback callback) {

        List<String> data = LoginUtility.retrieveUserCredentials();

        CustomerService customerService =
                ServiceGenerator.createService(CustomerService.class, data.get(0), data.get(1));
        Call<Customer> call = customerService.getUserInformation();

        call.enqueue(new Callback<Customer>() {
            @Override
            public void onResponse(Call<Customer> call, Response<Customer> response) {

                if (response.isSuccessful()) {
                    callback.onSuccessCustomer(response.body());

                } else {
                    callback.onError();

                }
            }

            @Override
            public void onFailure(Call<Customer> call, Throwable t) {
                // Something went seriously wrong
                Log.d("Error", t.getMessage());
            }
        });
        return false;
    }
}
