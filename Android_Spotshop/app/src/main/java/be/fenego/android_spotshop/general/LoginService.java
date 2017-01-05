package be.fenego.android_spotshop.general;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Thijs on 5/01/2017.
 */

public interface LoginService {
    @GET("customers/-")
    Call<User> getUserInformation();
}