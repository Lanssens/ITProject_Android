package be.fenego.android_spotshop.services;

import be.fenego.android_spotshop.models.User;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Thijs on 5/01/2017.
 */

public interface LoginService {
    @GET("customers/-")
    Call<User> getUserInformation();
}