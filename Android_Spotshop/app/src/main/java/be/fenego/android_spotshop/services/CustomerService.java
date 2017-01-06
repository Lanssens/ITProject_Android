package be.fenego.android_spotshop.services;

import be.fenego.android_spotshop.models.Customer;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Thijs on 5/01/2017.
 */

public interface CustomerService {
    @GET("customers/-")
    Call<Customer> getUserInformation();

    @POST("customers")
    Call<Customer> createCustomer(@Body Customer customer);


}