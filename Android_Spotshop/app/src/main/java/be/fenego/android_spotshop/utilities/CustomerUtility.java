package be.fenego.android_spotshop.utilities;
import android.util.Log;

import be.fenego.android_spotshop.callbacks.AddressCallback;
import be.fenego.android_spotshop.callbacks.CustomerCallback;
import be.fenego.android_spotshop.callbacks.CustomerCreationCallback;
import be.fenego.android_spotshop.callbacks.GeneralCallback;
import be.fenego.android_spotshop.callbacks.QuestionCallback;
import be.fenego.android_spotshop.callbacks.StringCallback;
import be.fenego.android_spotshop.models.Address;
import be.fenego.android_spotshop.models.Addresses;
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
@SuppressWarnings("DefaultFileTemplate")
public class CustomerUtility {
    @SuppressWarnings("unused")
    public static void updateCustomerFew(final GeneralCallback callback, final CustomerFew customer) {
        CustomerService customerService =
                ServiceGenerator.createService(CustomerService.class, LoginUtility.retrieveAuthToken());
        Call<CustomerFew> call = customerService.updateCustomer(customer);
        call.enqueue(new Callback<CustomerFew>() {
            @SuppressWarnings("unused")
            @Override
            public void onResponse(Call<CustomerFew> call, Response<CustomerFew> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess();
                } else {
                    System.out.println(response.errorBody().toString());
                    System.out.println(response.code());
                    System.out.println(response.raw().toString());
                    callback.onError();
                }
            }
            @SuppressWarnings("unused")
            @Override
            public void onFailure(Call<CustomerFew> call, Throwable t) {
                // Something went seriously wrong
                Log.d("Error", t.getMessage());
            }
        });
    }
    public static void updateCustomerFull(final GeneralCallback callback, final Customer customer) {
        CustomerService customerService =
                ServiceGenerator.createService(CustomerService.class, LoginUtility.retrieveAuthToken());
        Call<Customer> call = customerService.updateCustomerFully(customer);
        call.enqueue(new Callback<Customer>() {
            @Override
            public void onResponse(Call<Customer> call, Response<Customer> response) {
                if (response.isSuccessful()) {
                    System.out.println("Worked!");
                    //
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

        CustomerService customerService =
                ServiceGenerator.createService(CustomerService.class, LoginUtility.retrieveAuthToken());
        Call<Customer> call = customerService.updatePassword(password);
        call.enqueue(new Callback<Customer>() {
            @Override
            public void onResponse(Call<Customer> call, Response<Customer> response) {
                if (response.isSuccessful()) {
                    System.out.println("Updated password");

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
                    System.out.println(response.errorBody().toString());
                    System.out.println(response.raw());
                    callback.onErrorCreationCustomer();
                }
            }
            @Override
            public void onFailure(Call<Customer> call, Throwable t) {
                // Something went seriously wrong
                Log.d("Error", t.getMessage());
            }
        });
    }
    @SuppressWarnings("unused")
    public static void update(final QuestionCallback callback){
        SecurityService securityService = SecurityService.retrofit.create(SecurityService.class);
        final Call<QuestionWrapper> call = securityService.getAllSecurityQuestions();
        call.enqueue(new Callback<QuestionWrapper>() {
            @SuppressWarnings("unused")
            @Override
            public void onResponse(Call<QuestionWrapper> call, Response<QuestionWrapper> response) {
                callback.onSuccessQuestion(response.body().getElements());
            }
            @SuppressWarnings("unused")
            @Override
            public void onFailure(Call<QuestionWrapper> call, Throwable t) {
                System.out.println(t.getMessage());
                callback.onError();
            }
        });
    }
    @SuppressWarnings({"UnusedReturnValue", "SameReturnValue"})
    public static boolean getCustomerData(final CustomerCallback callback) {
        System.out.println(LoginUtility.retrieveAuthToken());
        CustomerService customerService =
                ServiceGenerator.createService(CustomerService.class, LoginUtility.retrieveAuthToken());
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
    @SuppressWarnings({"UnusedReturnValue", "SameReturnValue"})
    public static boolean getCustomerAddressUri(final StringCallback callback) {

        CustomerService customerService =
                ServiceGenerator.createService(CustomerService.class, LoginUtility.retrieveAuthToken());
        Call<Addresses> call = customerService.getCustomerAddresses();
        call.enqueue(new Callback<Addresses>() {
            @Override
            public void onResponse(Call<Addresses> call, Response<Addresses> response) {
                if (response.isSuccessful()) {
                    String uri = response.body().getElements().get(0).getUri().split("Site/-/customers/-/addresses/")[1];
                    //getCustomerAddressUri(callback, uri);
                    System.out.println(uri);
                    callback.onSuccessString(uri);
                } else {
                    callback.onErrorString();
                }
            }
            @Override
            public void onFailure(Call<Addresses> call, Throwable t) {
                // Something went seriously wrong
                Log.d("Error", t.getMessage());
            }
        });
        return false;
    }
    @SuppressWarnings({"UnusedReturnValue", "SameReturnValue"})
    public static boolean getCustomerAddress(final AddressCallback callback, final String uri) {

        CustomerService customerService =
                ServiceGenerator.createService(CustomerService.class, LoginUtility.retrieveAuthToken());
        Call<Address> call = customerService.getCustomerAddress(uri);
        call.enqueue(new Callback<Address>() {
            @Override
            public void onResponse(Call<Address> call, Response<Address> response) {
                if (response.isSuccessful()) {
                    System.out.println(response.body().getStreet());
                    callback.onSuccessAddress(response.body());
                } else {
                    callback.onAddressError();
                }
            }
            @Override
            public void onFailure(Call<Address> call, Throwable t) {
                // Something went seriously wrong
                Log.d("Error", t.getMessage());
            }
        });
        return false;
    }
    @SuppressWarnings({"UnusedReturnValue", "SameReturnValue", "UnusedParameters"})
    public static boolean updateCustomerAddress(final GeneralCallback callback, final String uri, Address address) {

        CustomerService customerService =
                ServiceGenerator.createService(CustomerService.class, LoginUtility.retrieveAuthToken());
        Call<Address> call = customerService.putCustomerAddress(uri, address);
        call.enqueue(new Callback<Address>() {
            @Override
            public void onResponse(Call<Address> call, Response<Address> response) {
                if (response.isSuccessful()) {
                    System.out.println(response.body().getStreet());
                }
            }
            @Override
            public void onFailure(Call<Address> call, Throwable t) {
                // Something went seriously wrong
                Log.d("Error", t.getMessage());
            }
        });
        return false;
    }
}